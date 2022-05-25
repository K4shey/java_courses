package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> tst = new HashMap<>();
        tst.put("name", "Ivanov");
        tst.put("country", "Ukraine");
        tst.put("city", "Kiev");
        tst.put("age", null);
        System.out.println(tst.toString());
        System.out.println(getQuery(tst));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            if (result.length() > 0) {
                result.append(" and ");
            }
            result.append(entry.getKey()).append(" = ").append("'").append(entry.getValue()).append("'");
        }
        return result.toString();
    }
}






























