package VTB.lecture9.homework1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnnotationsHandler {
    public List<String> handleColumns(Class<?> inputClass) {
        Field[] fields = inputClass.getDeclaredFields();
        List<String> fieldsList = new ArrayList<>();
        HashMap<Class, String> typeMapping = new HashMap<>();

        typeMapping.put(int.class, "INTEGER");
        typeMapping.put(Integer.class, "INTEGER");
        typeMapping.put(short.class, "INTEGER");
        typeMapping.put(Short.class, "INTEGER");
        typeMapping.put(byte.class, "INTEGER");
        typeMapping.put(Byte.class, "INTEGER");
        typeMapping.put(long.class, "INTEGER");
        typeMapping.put(Long.class, "INTEGER");

        typeMapping.put(float.class, "REAL");
        typeMapping.put(Float.class, "REAL");
        typeMapping.put(double.class, "REAL");
        typeMapping.put(Double.class, "REAL");

        typeMapping.put(String.class, "TEXT");
        typeMapping.put(char.class, "TEXT");
        typeMapping.put(Character.class, "TEXT");

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                String fieldProperty = field.getName() + " " + typeMapping.get(field.getType());
                System.out.println("Created column with title = " + field.getName()
                        + ", type " + typeMapping.get(field.getType()));
                fieldsList.add(fieldProperty);
            }
        }
        return fieldsList;
    }

    public String handleTable(Class<?> inputClass) {
        if (inputClass.isAnnotationPresent(Table.class)) {
            String title = inputClass.getAnnotation(Table.class).title();
            System.out.println("Created table with title = " + title);
            return title;
        } else {
            throw new RuntimeException("Something went wrong");
        }
    }

    public HashMap<String, Object> HandleObject(Object object) {
        HashMap<String, Object> fieldsValues = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                fieldsValues.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldsValues;
    }
}