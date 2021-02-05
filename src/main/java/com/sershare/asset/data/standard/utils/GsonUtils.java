package com.sershare.asset.data.standard.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GsonUtils {
    private static GsonBuilder gsonBuilder = null;
    private static JsonSerializer<Date> ser = new JsonSerializer<Date>() {
        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(DateUtils.date2String(src,DateUtils.DATEPATTERN_YYYY_MM_DD));
        }
    };

    private static Gson createGson() {
        if (gsonBuilder == null) {
            gsonBuilder = new GsonBuilder()
                    .setDateFormat(DateUtils.DATEPATTERN_YYYY_MM_DD)
                    .registerTypeAdapter(Date.class, ser);
        }
        return gsonBuilder.create();
    }

    public static <T> T fromString(String content, Class<T> valueType){
        return createGson().fromJson(content, valueType);
    }

    public static String toString(Object object) {
        return createGson().toJson(object);
    }

    public static Map<String, String> toMap(String jsonStr) {
        Map<String, String> map = null;
        createGson().fromJson(jsonStr, Map.class);
        map = createGson().fromJson(jsonStr, new TypeToken<HashMap<String,String>>(){}.getType());
        return map;
    }

    public static JsonObject stringToJson(String object){
        return new JsonParser().parse(object).getAsJsonObject();
    }

    public static JsonElement objectToJsonTree(Object object) {
        return createGson().toJsonTree(object);
    }

}
