package academy.devonline.java.oop.structures;

import java.util.Arrays;

class DynaArrayTest {
    public static void main(String[] args) {

            LinkedList list = new LinkedList();
            list.add(new int[]{0, 1, 2, 3});
            DynaArray dynaArray = new DynaArray();

            dynaArray.add(list);

            System.out.println(dynaArray.asString());

//            DynaArray dynaArray = new DynaArray();
//
//            dynaArray.add(0);
//            dynaArray.add(1);
//            dynaArray.add(2);
//            dynaArray.add(3);
//            dynaArray.add(4);
//
//            System.out.println(dynaArray.asString());
//
//            dynaArray.remove(5);
//            // [0, 1, 2, 3]
//            System.out.println(dynaArray.asString());
//
//            dynaArray.remove(0);
//            // [1, 2, 3]
//            System.out.println(dynaArray.asString());
//
//            dynaArray.remove(2);
//            // [1, 3, 4]
//            System.out.println(dynaArray.asString());
//
//            dynaArray.remove(4);
//            // [1, 3]
//            System.out.println(dynaArray.asString());

    }

}
