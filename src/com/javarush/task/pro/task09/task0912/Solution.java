package com.javarush.task.pro.task09.task0912;
/*
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        int index = url.indexOf("://");
        if(index != -1 ) {
            String protocol = url.substring(0, index);
            if (protocol.equalsIgnoreCase("http") || protocol.equalsIgnoreCase("https")) {
                return protocol;
            }
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        int index = url.indexOf(".");
        if (index != -1) {
            String domain = url.substring(++index);
            if (domain.equalsIgnoreCase("com") || domain.equalsIgnoreCase("net")
                    || domain.equalsIgnoreCase("org") || domain.equalsIgnoreCase("ru")) {
                return domain;
            }
        }
        return "неизвестный";
    }
}
