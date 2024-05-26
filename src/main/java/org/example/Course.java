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
        // checks if there even are assignments
        if (assignments == null) {
            return false;
        }
        // adds the weight of assignments together
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.weight;
        }
        // checks if the assignments weight is valid or not and returns
        return (sum == 1) ? true : false;
    }

    public boolean registerStudent(Student student) {
        // checks if there are students registered, then replaces registeredStudents[] with another one
        if (registeredStudents == null) {
            registeredStudents = new Student[1];
        } else {
            Student[] tempArray = registeredStudents;
            registeredStudents = new Student[registeredStudents.length + 1];
            for (int i = 0; i < tempArray.length; i++) {
                registeredStudents[i] = tempArray[i];
            }
        }
        // adds student to the registeredStudents
        for (int i = 0; i < registeredStudents.length; i++) {
            if (registeredStudents[i] == null) {
                registeredStudents[i] = student;
            }
        }
        // TO FIX: add a new 'null' element to each assignment of the course
        for (int i = 0; i < assignments.length; i++) {
            assignments[i] = null;
        }
        // TO ADD: new null element for the finalScores

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
