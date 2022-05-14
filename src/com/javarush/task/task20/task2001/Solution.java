package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("d:\\Downloads\\your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.equals(ivanov));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            outputStream.write(("name:" + name + "\n").getBytes());
            outputStream.write((name + "\n").getBytes());
            if (assets != null) {
                for (Asset nextAsset : assets) {
//                    outputStream.write(("asset:" + nextAsset.getName() + ";" + nextAsset.getPrice() + "\n").getBytes());
                    outputStream.write((nextAsset.getName() + ";" + nextAsset.getPrice() + "\n").getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[] buffer = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
            }
            String res = new String(buffer);
            String[] array = res.split("\n");
            name = array[0];
            if (array.length > 1) {
                for (int i = 1; i < array.length; i++) {
                    String nextLine = array[i];
                    String assetName = nextLine.substring(0, nextLine.indexOf(";"));
                    String strPrice = array[i].substring(nextLine.indexOf(";") + 1, nextLine.length());
                    Double assetPrice = Double.parseDouble(strPrice);
                    Asset loadedAsset = new Asset(assetName, assetPrice);
                    assets.add(loadedAsset);
                }
            }
        }
    }
}






























