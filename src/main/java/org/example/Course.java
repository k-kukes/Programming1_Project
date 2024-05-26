package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseName;
    private double credits;
    private Department department;
    private Assignment[] assignments;
    private Student[] registeredStudents;
    private double[] finalScores;
    private static int nextId;

    public boolean isAssignmentWeightValid() {

        return false;
    }

    public boolean registerStudent(Student student) {

        return false;
    }

    public int[] calcStudentsAverage(){

        return new int[1];
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {

        return false;
    }

    public void generateScores() {

    }

    public void displayScores() {

    }

    public String toSimplifiedString() {

        return "";
    }

    public String toString() {

        return "";
    }
}
