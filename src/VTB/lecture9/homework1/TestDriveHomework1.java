package VTB.lecture9.homework1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestDriveHomework1 {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {

        init();
        createTable();
        addRow();

        try {
            connection.close();
            System.out.println("Connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void init() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:d:\\Portable\\sqlite\\students.db");
            statement = connection.createStatement();
            System.out.println("Connected successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        AnnotationsHandler annotationsHandler = new AnnotationsHandler();
        String tableName = annotationsHandler.handleTable(Student.class);
        List<String> fieldsList = annotationsHandler.handleColumns(Student.class);
        if (!tableName.equals("")) {
            StringBuilder text = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (").append("\n");
            for (int i = 0; i < fieldsList.size(); i++) {
                text.append(fieldsList.get(i));
                if (i < fieldsList.size() - 1) {
                    text.append(",\n");
                }
            }
            text.append("\n);");
            System.out.println(text.toString());
            try {
                statement.executeUpdate(text.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addRow() {
        String text = "INSERT INTO students (name, score, rate) VALUES ('Bob', 15, 6.5);";
        try {
            statement.executeUpdate(text);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
