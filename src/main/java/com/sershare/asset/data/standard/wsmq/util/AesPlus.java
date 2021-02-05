package com.sershare.asset.data.standard.wsmq.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Aes工具类
 *
 */
public class AesPlus {


    private static final String KEY_ALGORITHM = "AES";
    private static final String MODE = "ECB";//默认的加密算法 字段
    private static final String PADDING = "pkcs5padding";//默认的加密算法 字段
    private static final String CHARACTER = "utf8";//默认的加密算法 编码


    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM+"/"+MODE+"/"+PADDING);// 创建密码器
            byte[] byteContent = content.getBytes(CHARACTER);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器
            byte[] result = cipher.doFinal(byteContent);// 加密
            return Base64.encodeBase64String(result);//通过Base64转码返回
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM+"/"+MODE+"/"+PADDING);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, CHARACTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            //kg.init(128, new SecureRandom(password.getBytes()));
            kg.init(128, random);

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    /**
     * 初始化 AES Cipher
     * @param passsword
     * @param cipherMode
     * @param mode
     * @param padding
     * @param character
     * @return
     */
    public static Cipher initAESCipher(String passsword, int cipherMode,String mode,String padding,String character) {

        Cipher cipher = null;
        try {
            SecretKey key = getKey(passsword,character);
            cipher = Cipher.getInstance(KEY_ALGORITHM+"/"+MODE+"/"+PADDING);
            cipher.init(cipherMode, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvalidKeyException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return cipher;
    }

    /**
     * 对文件进行AES加密
     * @param sourceFile 待加密文件
     * @param encryptFilePath 加密文件
     * @param sKey 密码
     * @return
     */
    public static boolean encryptFile(File sourceFile, String encryptFilePath, String sKey){

        InputStream inputStream = null;
        OutputStream outputStream = null;
        CipherInputStream cipherInputStream = null;
        try {
            File encryptFile = new File(encryptFilePath);//加密文件
            if(encryptFile.exists()){encryptFile.delete();}
            if(!encryptFile.exists()){encryptFile.createNewFile();}
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(encryptFile);
            Cipher cipher = initAESCipher(sKey,Cipher.ENCRYPT_MODE,MODE,PADDING,CHARACTER);
            //以加密流写入文件
            cipherInputStream = new CipherInputStream(inputStream, cipher);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = cipherInputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            cipherInputStream.close();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }  catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return true;
    }

    /**
     * AES方式解密文件
     * @param sourceFile 待解密文件
     * @param decryptFilePath 解密文件
     * @param sKey 密码
     * @return
     */
    public static boolean decryptFile(File sourceFile,String decryptFilePath,String sKey){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File decryptFile = new File(decryptFilePath);//解密文件
            if(decryptFile.exists()){decryptFile.delete();}
            if(!decryptFile.exists()){decryptFile.createNewFile();}
            Cipher cipher = initAESCipher(sKey,Cipher.DECRYPT_MODE,MODE,PADDING,CHARACTER);
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(decryptFile);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            byte [] buffer = new byte [1024];
            int r;
            while ((r = inputStream.read(buffer)) >= 0) {
                cipherOutputStream.write(buffer, 0, r);
            }
            cipherOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return true;
    }
    private static SecretKey getKey(String password,String character) {
        SecretKeySpec key = null;
        try {
            byte[] passwordBytes = password.getBytes(character);
            key = new SecretKeySpec(passwordBytes, KEY_ALGORITHM);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return key;
    }


    /**
     * starlink字段加密
     * @param value
     * @return
     * @throws Exception
     */
    public static String starlinkEncrypt(String key, String value){
        return encrypt(value,key);
    }

    /**
     * starlink字段解密
     * @param value
     * @return
     * @throws Exception
     */
    public static String starlinkDecrypt(String key, String value){
        return decrypt(value,key);
    }


    public static void main(String[] args) throws IOException {
        //加密
        //File sourceFile = new File("D:\\20180615\\TN_3C_N1_FUNDS_TX_20180604_1.csv");
        //encryptFile(sourceFile, "D:\\20180615\\TN_3C_N1_FUNDS_TX_20180604_en.csv", "1234567812345678");

        //解密
        //File sourceFile1 = new File("D:\\20180615\\TN_3C_N1_FUNDS_TX_20180604_en.csv");
        //decryptFile(sourceFile1, "D:\\20180615\\TN_3C_N1_FUNDS_TX_20180604_de.csv", "1234567812345678");


        String code = "871d0120739d4410b0535238736968c11";
        String key = "tencentabs123456";
        String codD, codE;
        codE = encrypt(code,key);

        codD = decrypt(codE,key);

        System.out.println("原文：" + code);
        System.out.println("密钥：" + key);
        System.out.println("密文：" + codE);
        System.out.println("解密：" + codD);


        String encrypt = "goNEQ4ssyeYZoV4HfG0Q5NdRKO2DbhY33TvynlfEZ4g=";
        System.out.println("12312312312313123123123123");
        System.out.println(encrypt);
        System.out.println(starlinkDecrypt(key,encrypt));

    }

}
