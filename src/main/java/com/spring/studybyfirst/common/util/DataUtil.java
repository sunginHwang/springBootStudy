package com.spring.studybyfirst.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.bind.v2.model.core.TypeRef;

public class DataUtil {
    private static Gson gson = new Gson();

    public static String toJson(Object o){
        return gson.toJson(o);
    }

    public static <T> T fromJson(String json, Class<T> T){
        return gson.fromJson(json,T);
    }

    public static <T> T fromJsonList(String json, TypeToken<T> typeToken){
        return gson.fromJson(json,typeToken.getType());
    }
}
