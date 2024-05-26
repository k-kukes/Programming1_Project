package org.example;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address(23, "Spring", "MTL", "QC", "o1b4r4", "CANADA");

        Department department1 = new Department("Computer Science");

        Student student1 = new Student("Kukes Kanthasamy", Gender.MALE, address1, department1);
        Student student2 = new Student("Kukes Kanthasamy", Gender.MALE, address1, department1);
        Student student3 = new Student("Kukes Kanthasamy", Gender.MALE, address1, department1);

        Course course1 = new Course("Programming 1", 3.3, department1);

        course1.registerStudent(student1);
        course1.registerStudent(student2);
        course1.registerStudent(student3);

        course1.addAssignment("Assignment 1", 0.1, 100);
        course1.addAssignment("Assignment 2", 0.1, 100);
        course1.addAssignment("Assignment 3", 0.1, 100);
        course1.addAssignment("Exam 1", 0.4, 100);
        course1.addAssignment("Exam 1", 0.3, 100);

        course1.generateScores();

        course1.displayScores();
    }

}
