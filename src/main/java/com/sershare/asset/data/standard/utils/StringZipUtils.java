package com.sershare.asset.data.standard.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.*;

/**
 * @author xiaomudong
 */
public class StringZipUtils {

    /**

     * 使用gzip进行压缩
     */
    public static String gzip(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        GZIPOutputStream gzip=null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(gzip);
        }


        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     *
     * <p>Description:使用gzip进行解压缩</p>
     * @param compressedStr
     * @return
     */
    public static String gunzip(String compressedStr){
        if(compressedStr==null){
            return null;
        }

        ByteArrayOutputStream out= new ByteArrayOutputStream();
        ByteArrayInputStream in=null;
        GZIPInputStream ginzip=null;
        byte[] compressed=null;
        String decompressed = null;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in=new ByteArrayInputStream(compressed);
            ginzip=new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed=out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(ginzip);
        }

        return decompressed;
    }

    /**
     * 使用zip进行压缩
     * @param str 压缩前的文本
     * @return 返回压缩后的文本
     */
    public static final String zip(String str) {
        if (str == null) {
            return null;
        }
        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
            /*compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);*/
            compressedStr = Base64.encodeBase64String(compressed);
        } catch (IOException e) {
            return "";
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(zout);
        }
        return compressedStr;
    }

    /**
     * 使用zip进行解压缩
     * @param compressedStr 压缩后的文本
     * @return 解压后的字符串
     */
    public static final String unzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed = null;
        try {
            /*byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);*/
            byte[] compressed = Base64.decodeBase64(compressedStr);
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            return "";
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(zin);
        }
        return decompressed;
    }


    public static void main(String[] args) {
        String str = "UEsDBBQACAgIABeDfU4AAAAAAAAAAAAAAAABAAAAMFWR32vTUBTH/5c8KTh3cu/NzY2wh05TzGyxq8nsJC9Z0kBnLW4PisigRWVzWuyorkXnavfzRQKC1LqJ/jPLTfJfWG9WiG+X8znn+z33e6TntnRxdsT7Xd4bJb3vtnTDlhDI2gzgGcRs6Zot8b0zvv8y+rUbvvshuAyAQKBk+DP6FGSQWweQmSqgUSzdLZt5o6CbyyVdYL9WrwIV9NJ1/CVpdQVLmh/j1nvB4uAgbH9INneSg89Xwlcvrqa2FJHrON0pPO2GnbYo5xu5vLNuPSD6U3NJYU8atTtQWJybS/uaA94OptupFBCGjH04bkWnqUy5OJ8B0bfzcP+NABfnh/z1YWavqVquYFTMhdvmJA74l4isAUZs8lIAkawL3+nHJy0xk7XYHvFmWuVbnXB7IJhpFPV7Zq5YSr+sKJjJQCbaJBuqcUtgrHoMe2qVOC4hGrgO9imlnicDY6TqYTERDYM4OIr/9PnX37x3zPcG/x9ZE12Wdanpa0ilVFGBKCsEM3Aczfdk6hBYQdh10u6kO4qHb8NxZ5oFlB2dLSC67pUW15bqq1ZltXF/zXpUuzlvPiYw6z6brVT9Sp4+zE0OsyH9BVBLBwg4pnF4wgEAAHgCAAA\\u003d";

        String zipStr = unzip(str);
        System.out.println("zipStr:"+zipStr);
//        String unZipStr = gunzip(zipStr);
//        System.out.println(str.equals(unZipStr));
    }
}
