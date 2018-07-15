package com.spring.studybyfirst.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static <T, R> Collector<T, ?, Stream<T>> distinctByKey(Function<T, R> keyExtractor) {
        return Collectors.collectingAndThen(
                Collectors.toMap(
                        keyExtractor,
                        t -> t,
                        (t1, t2) -> t1
                ),
                (Map<R, T> map) -> map.values().stream()
        );
    }
}
