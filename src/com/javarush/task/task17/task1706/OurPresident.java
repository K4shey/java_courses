package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    static {
         if (president == null) {
           synchronized (OurPresident.class) {
//                synchronized (president) {
                    president = new OurPresident();
            }
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}






























