package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName; // TO UPDATE
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private List<Double> finalScores;
    private static int nextId = 0;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid() {
        // adds the weight of assignments together
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        // returns true if sum = 1, else false
        return (sum == 1);
    }

    public boolean registerStudent(Student student) {
        // adds a student to the student list of the course, if already registered returns false
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double finalScore = finalScores.get(i);
            averages[i] = (int) Math.round(finalScore);
        }
        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (assignmentName == null || weight <= 0 || maxScore == 0) {
            return false;
        }
        assignments.add(new Assignment(assignmentName, maxScore, weight));
        return true;
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }

    public void displayScores() {
        System.out.printf("Course: %s(%s)\n", courseName, courseId);
        for (Assignment assignment : assignments) {
            System.out.printf("     %s", assignment.getAssignmentName());
        }
        System.out.println("Final Score");
        for (Student student : registeredStudents) {
            System.out.printf("     %s", student.getStudentName());
        }
    }

    public String toSimplifiedString() {
        return String.format("%s - %s (%.1f credits", courseId, courseName, credits);
    }

    public String toString() {

        return "";
    }
}
