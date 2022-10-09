package VTB.lecture9.homework1;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestDriveHomework1 {

    private static Connection connection = null;
    private static Statement statement = null;
    private static String tableName = null;
    private static PreparedStatement preparedStatement = null;

    public static void main(String[] args) {

        init();
        createTable(Cat.class);
//        ArrayList<Object> students = new ArrayList<>();
//        students.add(new Student("Bob", 5));
//        students.add(new Student("Ann", 3));
//        students.add(new Student("John", 2));
//        students.add(new Student("Beth", 7));
//        students.add(new Student("Garry", 4));
//        addRows(students);
        ArrayList<Object> cats = new ArrayList<>();
        cats.add(new Cat("Bob", 5.5, 4));
        cats.add(new Cat("Ann", 3.3, 3));
        cats.add(new Cat("John",2.2, 2));
        cats.add(new Cat("Beth", 5.7, 7));
        cats.add(new Cat("Garry",4.2,  4));
        addRows(cats);

        try {
            preparedStatement.close();
            statement.close();
            connection.close();
            System.out.println("Connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void init() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:d:\\Portable\\sqlite\\test.db");
            statement = connection.createStatement();
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Class inputClass) {
        AnnotationsHandler annotationsHandler = new AnnotationsHandler();
//        tableName = annotationsHandler.handleTable(Student.class);
        tableName = annotationsHandler.handleTable(inputClass);
//        List<String> fieldsList = annotationsHandler.handleColumns(Student.class);
        List<String> fieldsList = annotationsHandler.handleColumns(inputClass);
        StringBuilder text = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (").append("\n");
        text.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ").append("\n");
        for (int i = 0; i < fieldsList.size(); i++) {
            text.append(fieldsList.get(i));
            if (i < fieldsList.size() - 1) {
                text.append(",\n");
            }
        }
        text.append("\n);");
        System.out.println(text);
        try {
            statement.executeUpdate(text.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addRows(ArrayList<Object> arrayList) {
        AnnotationsHandler annotationsHandler = new AnnotationsHandler();
        for (int i = 0; i < arrayList.size(); i++) {
            HashMap<String, Object> fields = annotationsHandler.HandleObject(arrayList.get(i));
            StringBuilder text = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
            for (String field : fields.keySet()) {
                text.append(field).append(", ");
            }
            text.delete(text.length() - 2, text.length());
            text.append(") VALUES (");
            for (Object value : fields.values()) {
                text.append("?").append(", ");
            }
            text.setLength(text.length() - 2);
            text.append(");");
            try {
                preparedStatement = connection.prepareStatement(text.toString());
                int index = 1;
                for (String key : fields.keySet()) {
                    preparedStatement.setObject(index, fields.get(key));
                    index++;
                }
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(text);
        }
    }
}