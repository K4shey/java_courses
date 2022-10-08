package VTB.lecture9.homework1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationsHandler {
    public List<String> handleColumns(Class<?> inputClass) {
        Field[] fields = inputClass.getDeclaredFields();
        List<String> fieldsList = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
//                System.out.println("Created column with name = " + field.getName());
                String type = "";
                if (field.getType().equals(String.class)) {
                    type = "TEXT";
                } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class) ||
                        field.getType().equals(Short.class) || field.getType().equals(short.class) ||
                        field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                    type = "INTEGER";
                } else if (field.getType().equals(Float.class) || field.getType().equals(float.class) ||
                        field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                    type = "REAL";
                }
                String fieldProperty = field.getName() + " " + type;
                fieldsList.add(fieldProperty);
            }
        }
        return fieldsList;
    }

    public String handleTable(Class<?> inputClass) {
        if (inputClass.isAnnotationPresent(Table.class)) {
            Table table = inputClass.getAnnotation(Table.class);
//            System.out.println("Created table with title = " + table.title());
            return table.title();
        }
        return "";
    }
}
