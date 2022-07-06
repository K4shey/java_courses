package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        if (students != null) {
            Student student = students.get(0);
            double maxAverageGrade = student.getAverageGrade();
            for (int i = 1; i < students.size(); i++) {
                if (students.get(i).getAverageGrade() > maxAverageGrade) {
                    maxAverageGrade = students.get(i).getAverageGrade();
                    student = students.get(i);
                }
            }
            return student;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        if (students != null) {
            Student student = students.get(0);
            double minAverageGrade = student.getAverageGrade();
            for (int i = 1; i < students.size(); i++) {
                if (students.get(i).getAverageGrade() < minAverageGrade) {
                    minAverageGrade = students.get(i).getAverageGrade();
                    student = students.get(i);
                }
            }
            return student;
        }
        return null;

    }

    public void expel(Student student) {
        int index = students.indexOf(student);
        if (index != -1) {
            students.remove(index);
        }
    }
}





























