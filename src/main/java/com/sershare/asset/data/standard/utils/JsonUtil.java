package com.sershare.asset.data.standard.utils;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sershare.asset.data.standard.common.SysConstant;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonUtil {
    //增加日志
    private  static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    /**
     * 单位缩进字符串。
     */
    private static String SPACE = "   ";

    /**
     * 返回格式化JSON字符串。
     *
     * @param json 未格式化的JSON字符串。
     * @return 格式化的JSON字符串。
     */
    public String formatJson(String json) {
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        char key = 0;
        //遍历输入字符串。
        for (int i = 0; i < length; i++) {
            //1、获取当前字符。
            key = json.charAt(i);
            //2、如果当前字符是前方括号、前花括号做如下处理：
            if((key == '[') || (key == '{') ) {
                //（1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }
                //（2）打印：当前字符。
                result.append(key);
                //（3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');
                //（4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));
                //（5）进行下一次循环。
                continue;
            }
            //3、如果当前字符是后方括号、后花括号做如下处理：
            if((key == ']') || (key == '}') ) {
                //（1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');
                //（2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));
                //（3）打印：当前字符。
                result.append(key);
                //（4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if(((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }
                //（5）继续下一次循环。
                continue;
            }
            //4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }
            //5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private String indent(int number)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++)
        {
            result.append(SPACE);
        }
        return result.toString();
    }

    /**
     *  处理abs校验结果
     * @param json
     * @return
     */
    public static Map<String,String> getVerifi(String json){
        Map<String,String> map = new HashMap<String,String>();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        JsonObject returnData = new JsonParser().parse(json).getAsJsonObject();
        JsonArray dataList = returnData.getAsJsonArray("data");
        Iterator dataIt = dataList.iterator();
        while(dataIt.hasNext()){
            JsonElement data = (JsonElement)dataIt.next();
            JsonElement jsonElement = data.getAsJsonObject().get("apiFileDetailPOMap");
            if(jsonElement.isJsonNull()){
                continue;
            }
            JsonObject apiFileDetailPOMap = jsonElement.getAsJsonObject();
            Type type = new TypeToken<Map<String, JsonObject>>() {}.getType();
            Map<String, JsonObject> map2 = gson.fromJson(apiFileDetailPOMap, type);
            for (String keyString : map2.keySet()) {
                JsonArray jsonArray = apiFileDetailPOMap.getAsJsonObject(keyString).getAsJsonArray("apiErrorLogPOList");
                Iterator it = jsonArray.iterator();
                while(it.hasNext()){
                    JsonElement e = (JsonElement)it.next();
                    JsonElement element = e.getAsJsonObject().get("fserialNumber");
                    if(!element.isJsonNull()){
                        map.put(keyString+ SysConstant.UNDERLINE+element.getAsString(),"1");
                    }
                }
            }
        }
        return map;
    }

    /**
     * 判断abs是否已校验完毕
     * @return
     * @throws Exception
     */
    public static boolean isVerifiJson(String json){
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        JsonObject returnData = new JsonParser().parse(json).getAsJsonObject();
        JsonArray dataList = returnData.getAsJsonArray("data");
        return dataList.size() !=0 ;
    }


    /**
     * 是否是合法的Gson字符串
     * @param targetStr
     * @return
     */

    public static boolean isGoodJson(String targetStr) {
        try {
            JsonElement  je =new JsonParser().parse(targetStr);
            return je.isJsonObject();
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * 是否是合法的Gson字符串
     * @param targetStr
     * @return
     */

    public static boolean isGoodJoOrGoodJa(String targetStr) {
        try {
            JsonElement  je =new JsonParser().parse(targetStr);
            return je.isJsonObject() || je.isJsonArray();
        } catch (JsonParseException e) {
            return false;
        }
    }

    private static boolean isGoodGson(String targetStr,Class clazz) {
        if(StringUtils.isBlank(targetStr)){
            return false;
        }
        try {
            new Gson().fromJson(targetStr,clazz);
            return true;
        } catch(JsonSyntaxException ex) {
            logger.error("targetStr={} is not a valid {}",targetStr,clazz.getName(),ex);
            return false;
        }
    }

    /**
     * 是否是合法的JsonArray (alibaba 认为前1种不是JSON串)
     * 例如：[{a:b}]  [{'a':'b'}]  [{"a":"b"}]
     * @param targetStr
     * @return
     */
    public static boolean isJsonArray(String targetStr){
        return isGoodGson(targetStr,JsonArray.class);
    }

    /**
     * 是否是合法的JsonObject(alibaba 认为前1种不是JSON串)
     * 例如：{a:b} {'a':'b'} {"a":"b"}
     * @param targetStr
     * @return
     */
    public static boolean isJsonObject(String targetStr){
        return isGoodGson(targetStr,JsonObject.class);
    }

    /**
     * bean to json
     * @param bean
     * @return
     */
    public static String beanToJSONString(Object bean) {
        return new Gson().toJson(bean);
    }

    /**
     * @Auther: xiaomudong
     * @Date: 2018/7/13 14:03
     * @Description: json 字符串 加 property  key:value
     */
    public static String jsonAddProperty(String json,String key,String value){
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.addProperty(key,value);
        return jsonObject.toString();
    }

    /**
     * @Author xiaomudong
     * @Description //字符串转义
     * @Date 14:28 2018/7/16
     * @Param
     * @return
     **/
    public static String unEscape (String str){
        str = str.replaceAll(" ","");
        str = str.replaceAll("\n","");
        Map<String,String> map = new HashMap<>();
        map.put("key",str);
        Gson gson = new Gson();
        JsonObject returnData = new JsonParser().parse(gson.toJson(map)).getAsJsonObject();
        return returnData.get("key").toString();
    }

    /**json格式化 by InputStream*/
    public static JSONObject formatStream (InputStream in)throws Exception{
        String inStr = readStream(in);
        JSONObject json = JSONObject.parseObject(inStr);
        return json;
    }


    public static String readStream(InputStream in)throws Exception {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }finally {
            IOUtils.closeQuietly(reader);
        }
        return buffer.toString();
    }

    /**string to JsonObject*/
    public static JsonObject stringToJsonObject(String jsonStr){
        JsonObject jsonObject = null;
        if(isJsonObject(jsonStr)){
            jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
        }
        return jsonObject;
    }


    /**string to JsonArray*/
    public static JsonArray stringToJsonArray(String jsonStr){
        JsonArray jsonArray = null;
        if(isJsonArray(jsonStr)){
            jsonArray = new JsonParser().parse(jsonStr).getAsJsonArray();
        }
        return jsonArray;
    }


}
