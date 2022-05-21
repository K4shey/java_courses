package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public Object clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();
        Map<String, User> cloneUsers = new LinkedHashMap<>();
        for (Map.Entry<String, User> userEntry: users.entrySet()) {
            User user = (User) userEntry.getValue().clone();
            cloneUsers.put(userEntry.getKey(), user);
        }
        solution.users = cloneUsers;
        return solution;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }
            User obj = (User) o;
            if (age != obj.age) {
                return false;
            }
            if (name == null ? obj.name != null : !name.equals(obj.name)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}






























