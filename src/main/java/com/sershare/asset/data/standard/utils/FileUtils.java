package com.sershare.asset.data.standard.utils;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author tr
 * @description
 * @time 2018/7/10 14:33
 */
public class FileUtils {

    /**
     * 增加日志
     */
    private  static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static final String FILE_PATH_SEPARATOR = "/";

    /**
     * 获取后缀
     */
    public static String getFileSubffix(String pathandname) {

        int end = pathandname.lastIndexOf(".");
        if(end == -1){
            return null;
        }
        return pathandname.substring(end);
    }

    /**
     * 仅保留文件名不保留后缀
     */
    public static String getFileName(String pathandname) {

    	int start = pathandname.lastIndexOf("/");
        int end = pathandname.lastIndexOf(".");
        if(start == -1 || end == -1){
            return null;
        }
        return pathandname.substring(start + 1, end);
    }

    /**
     * 获取父目录
     * @param path
     * @return
     */
    public static String getParentDirName(String path){
        return path.substring(0, path.lastIndexOf(FILE_PATH_SEPARATOR));
    }
    /**
     * 保留文件名及后缀
     */
    public static String getFileNameWithSuffix(String pathandname) {
        int start = pathandname.lastIndexOf("/");
        if(start == -1){
            return null;
        }
        return pathandname.substring(start + 1);

    }

    /**
     * 创建文件
     *
     * @throws IOException
     */
    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            return false;
        }
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            createFolder(file.getParent());
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 创建文件夹
     *
     * @param folderName
     */
    public static void createFolder(String folderName) {
        File file = new File(folderName);
        while (!file.exists()) {
            if(file.getParentFile().exists()){
                file.mkdirs();
            }else{
                createFolder(file.getParent());
            }
        }
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        if(!file.isFile()){
            deleteDirectory(fileName);
        }
        return deleteFile(fileName);

    }

    /**
     * 删除临时file
     *
     * @param files
     */
    public static void deleteFile(File... files) {
    	for(File file : files) {
    		if(null == file) {
    			return;
    		}
    		
    		try {
    			boolean ret = file.delete();
    			if (ret) {
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if(!file.exists() ||  !file.isFile()){
            return false;
        }
        if (!file.delete()) {
            return false;
        }
        return true;


    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }

            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }

            }
        }
        if (!flag) {
            return false;
        }

        // 删除当前目录
        if (!dirFile.delete()) {
            return false;
        }
        return true;

    }

    public static String findParentDirectory(String dir, String suffix) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return "";
        }

        // 遍历文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].getName().endsWith(suffix)) {
                return files[i].getParent();
            } else if (files[i].isDirectory()) {
                return findParentDirectory(files[i].getAbsolutePath(), suffix);
            }
        }
        return "";
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (null == src || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到文件头
     *
     * @throws IOException
     */
    private static String getFileContent(InputStream fileInput) {
        byte[] b = new byte[28];
        InputStream inputStream = null;
        try {
            inputStream = fileInput;
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return bytesToHexString(b);
    }







    /**
     * 删除临时zip
     */
    public static void deleteZipTemp(File file) {
        String filePath = file.getAbsolutePath();
        try {
            boolean ret = file.delete();
            if (ret) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 获取某一路径下的所有文件名称
     *
     * @param fileDir
     */
    public static List<String> getFileList(String fileDir) {
        List<String> fileList = new ArrayList<String>();
        File file = new File(fileDir);

        /**
         *  获取目录下的所有文件或文件夹
         */
        File[] files = file.listFiles();
        /**
         * 如果目录为空，直接退出
         */
        if (null == files) {
            return fileList;
        }
        /**
         * 遍历，目录下的所有文件
         */
        for (File f : files) {
            fileList.add(f.getName());
        }
        return fileList;
    }

    /**获取文件+后缀 == terms 的文全路径list*/
    public static void getFileList(String strPath, List<String> list, String terms) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath(),list,terms);
                } else if (fileName.equals(terms)) {
                    list.add(files[i].getAbsolutePath());
                } else {
                    continue;
                }
            }
        }
    }


    /**判读是否是文件夹是否存在文件 并以suffix 做后缀*/
    public static boolean hasSuffixFileInDir(String path, String suffix){
        File folder = new File(path);
        File[] files = folder.listFiles();
        boolean flag = false;
        for (int i=0;i<files.length;i++){
            File file = files[i];
            if(file.getName().endsWith(suffix)){
                flag = true;
            }
        }
        return flag;
    }

    /**判读是否是文件夹 */
    public static boolean isDir(String path){
        File file =new File(path);
        if  (!file .exists()  && !file .isDirectory()) {
            return false;
        } else {
            return true;
        }
    }

    /** 删除文件*/
    public static void deleteTempRightNow(String tempDir){
        File folder = new File(tempDir);
        if (!folder.exists()){
            return;
        }
        File[] files = folder.listFiles();
        for (int i=0;i<files.length;i++){
            File file = files[i];
            String filePath = file.getAbsolutePath();
            if(file.isFile()){
                boolean ret = file.delete();
                if(ret){
                    logger.info("delete zip success!|path={}",filePath);
                }
            }else{
                boolean ret = deleteDirectory(filePath);
                if(ret){
                    logger.info("delete temp file success!|path={}",filePath);
                }
            }
        }
    }

    /**
     * 根据指定名称查找对应文件或者目录对应的绝对路径
     * @param file 父目录文件
     * @param name 查找条件
     * @param list 符合条件的目录集合
     */
    public static void scanLocation(File file, String name, List<String> list){
        File[] files = file.listFiles();
        if(Objects.isNull(files) || files.length == 0){
            return ;
        }

        for(File f : files){
            if(f.isFile()){
                if(f.getName().indexOf(name) >= 0) {
                    try {
                        list.add(f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                if(name.equals(f.getName())){
                    try {
                        list.add(f.getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    scanLocation(f,name,list);
                }
            }
        }
    }

    /**
     * 获取目录下及子目录下的所有文件
     * @param fileDir  目录名称
     * @param fileList 文件集合
     */
    public static void getFile(File fileDir, List<File> fileList){
        File[] files = fileDir.listFiles();
        for (File file: files) {
            if(file.isFile()){
                fileList.add(file);
            }else{
                getFile(file,fileList);
            }
        }
    }

    public static boolean deleteAllByPath(File rootFilePath) {
        File[] needToDeleteFiles = rootFilePath.listFiles();
        if (needToDeleteFiles == null) {
            return true;
        }
        for (int i = 0; i < needToDeleteFiles.length; i++) {
            if (needToDeleteFiles[i].isDirectory()) {
                deleteAllByPath(needToDeleteFiles[i]);
            }
            try {
                Files.delete(needToDeleteFiles[i].toPath());
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将参数拼成路径
     * @param pathStr
     * @return
     */
    public static String joinPath(String... pathStr){
        String path = "";
        for(String str : pathStr){
            if(StringUtils.isEmpty(str)){
                continue;
            }
            if(str.startsWith(FILE_PATH_SEPARATOR)){
                path += str;
            }else{
                path += FILE_PATH_SEPARATOR + str;
            }
        }

        return path;
    }

    public static void copyFile(File src, File dest) throws Exception {
        logger.info("starting cope file, src|{}, dest|{}", src.getAbsolutePath(), dest.getAbsolutePath());
        org.apache.commons.io.FileUtils.copyFile(src, dest);
        logger.info("end cope file, success !, src|{}, dest|{}", src.getAbsolutePath(), dest.getAbsolutePath());
    }
    public static void writeByteArrayToFile(File file, byte[] data) throws IOException {
        OutputStream out = null;
        try {
            out = openOutputStream(file, false);
            out.write(data);
            out.close(); // don't swallow close Exception if copy completes normally
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    public static FileOutputStream openOutputStream(File file, boolean append) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canWrite() == false) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        return new FileOutputStream(file, append);
    }

    public static void main(String[] args) {
    	File file = new File("D:\\Users\\jack.hu\\Desktop\\new\\test\\AccountRecord.java");
    	//deleteDirectory(file.getParent());

        createFolder("D:/a/b/c");
	}
}
