package VTB.lecture10.homework1;

//INSERT INTO students VALUES (1, 'John', 333,4546);
//        INSERT INTO students VALUES (2, 'Paul', 333,4547);
//        INSERT INTO students VALUES (3, 'Joel', 334,4546);
//        INSERT INTO students VALUES (4, 'Ringo', 334,4546); <--- not unique pair!
//
//
//        INSERT INTO subjects VALUES (1, 'Math');
//        INSERT INTO subjects VALUES (2, 'Physics');
//        INSERT INTO subjects VALUES (3, 'Chemistry');
//
//        INSERT INTO progress VALUES (1, 1, 1, 5);
//        INSERT INTO progress VALUES (2, 2, 1, 2);
//        INSERT INTO progress VALUES (3, 1, 2, 5);
//        INSERT INTO progress VALUES (4, 1, 3, 2);
//        INSERT INTO progress VALUES (5, 4, 3, 4);
//        INSERT INTO progress VALUES (6, 3, 1, 3);


//CREATE TABLE students (id integer PRIMARY KEY, name text, passport_series integer, passport_number integer, UNIQUE (passport_series, passport_number));
//        CREATE TABLE subjects (id integer PRIMARY KEY, name text);
//        CREATE TABLE progress (id integer PRIMARY KEY, student_id integer REFERENCES students (id) ON DELETE CASCADE, subject_id integer REFERENCES subjects (id), mark smallint CHECK (mark >= 2 AND mark < 6));
//        SELECT students.name FROM progress LEFT JOIN students ON (students.id = progress.student_id) WHERE (progress.mark >=3 AND progress.subject_id = 1);
//        SELECT AVG(mark) FROM progress WHERE subject_id = 1;
//        SELECT AVG(mark) FROM progress WHERE student_id = 1;
//        SELECT subjects.name FROM progress
//        LEFT JOIN subjects
//        ON subjects.id = progress.subject_id
//        LEFT JOIN students
//        ON students.id = progress.student_id
//        GROUP BY subjects.id
//        ORDER BY count(students.id) DESC
//        LIMIT 3;

import java.sql.*;

public class TestDriveHomework1 {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {

        try {
            getConnection();
            initializeTables();
            getResult1();
            getResult2();
            getResult3();
            getResult4();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
            System.out.println("Connection closed");
        }

    }

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5433/testdb";
            String user = "postgres";
            String password = "12345";

            try {
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }

    public static void disconnect() {

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void initializeTables() {
        try {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id integer PRIMARY KEY, name text, passport_series integer, passport_number integer," +
                    " UNIQUE (passport_series, passport_number));");
            statement.executeUpdate("INSERT INTO students VALUES (1, 'John', 333,4546);");
            statement.executeUpdate("INSERT INTO students VALUES (2, 'Paul', 333,4547);");
            statement.executeUpdate("INSERT INTO students VALUES (3, 'Joel', 334,4546);");
            statement.executeUpdate("INSERT INTO students VALUES (4, 'Ringo', 334,4548);");

            statement.executeUpdate("CREATE TABLE  IF NOT EXISTS subjects (id integer PRIMARY KEY, name text);");
            statement.executeUpdate("INSERT INTO subjects VALUES (1, 'Math');");
            statement.executeUpdate("INSERT INTO subjects VALUES (2, 'Physics');");
            statement.executeUpdate("INSERT INTO subjects VALUES (3, 'Chemistry');");

            statement.executeUpdate("CREATE TABLE  IF NOT EXISTS progress (id integer PRIMARY KEY, student_id integer REFERENCES students (id) ON DELETE CASCADE" +
                    ", subject_id integer REFERENCES subjects (id), mark smallint CHECK (mark >= 2 AND mark < 6));");
            statement.executeUpdate("INSERT INTO progress VALUES (1, 1, 1, 5);");
            statement.executeUpdate("INSERT INTO progress VALUES (2, 2, 1, 2);");
            statement.executeUpdate("INSERT INTO progress VALUES (3, 1, 2, 5);");
            statement.executeUpdate("INSERT INTO progress VALUES (4, 1, 3, 2);");
            statement.executeUpdate("INSERT INTO progress VALUES (5, 4, 3, 4);");
            statement.executeUpdate("INSERT INTO progress VALUES (6, 3, 1, 3);");

//

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResult1() throws SQLException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT students.name FROM progress LEFT JOIN students ON (students.id = progress.student_id) WHERE (progress.mark >=3 AND progress.subject_id = 1);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResult2() throws SQLException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT AVG(mark) AS avgMark FROM progress WHERE subject_id = 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            System.out.println(rs.getString("avgMark"));
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResult3() throws SQLException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT AVG(mark) AS avgMark FROM progress WHERE student_id = 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            System.out.println(rs.getString("avgMark"));
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResult4() throws SQLException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT subjects.name FROM progress\n" +
                    "        LEFT JOIN subjects\n" +
                    "        ON subjects.id = progress.subject_id\n" +
                    "        LEFT JOIN students\n" +
                    "        ON students.id = progress.student_id\n" +
                    "        GROUP BY subjects.id\n" +
                    "        ORDER BY count(students.id) DESC\n" +
                    "        LIMIT 3;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

