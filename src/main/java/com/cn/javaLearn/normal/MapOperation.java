package com.cn.javaLearn.normal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: javaLearn
 * @description: 测试
 * @author: liyan
 * @create: 2024-05-13 08:36
 **/
public class MapOperation {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuilder sbd = new StringBuilder();
        System.out.println(sb.equals(sbd));
        List list = new ArrayList<>();

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(null, "asss");
        hashMap.remove(null);

        System.out.println(hashMap.get(null));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, String>();
        concurrentHashMap.get("ass");
        concurrentHashMap.put("a", "b");


        // linkedHashMap
        LinkedHashMap<String, String> lamp = new LinkedHashMap<>();
        lamp.put("a", "b");
        lamp.put("b", "b");
        lamp.put("c", "b");
        lamp.get("a");

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", "123");

    }
}
