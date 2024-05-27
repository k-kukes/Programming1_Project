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
    private String courseName;
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
            if (finalScores.get(i) != null) {
                double finalScore = finalScores.get(i);
                averages[i] = (int) Math.round(finalScore);
            }
        }
        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (assignmentName == null || weight <= 0) {
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
        System.out.printf("Course: %s(%s)\n\t\t\t\t\t", courseName, courseId);
        for (Assignment assignment : assignments) {
            System.out.printf("%s\t\t", assignment.getAssignmentName());
        }
        System.out.println("Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%s\t\t", student.getStudentName());

            for (Assignment assignment : assignments) {
                int score = 0;
                if (assignment.getScores() != null && i < assignment.getScores().size()) {
                    score = assignment.getScores().get(i);
                }
                String studentScore = "";
                if (score != 0) {
                    studentScore = String.valueOf(score);
                } else {
                    studentScore = "--";
                }
                System.out.print(studentScore + "\t\t\t\t");
            }
            double finalScore = 0.0;
            if (finalScores.get(i) != null) {
                finalScore = finalScores.get(i);
            }
            System.out.printf("%.2f\t\t\n", finalScore);
        }
        System.out.print("Average\t\t");
        for (Assignment assignment : assignments) {
            assignment.calcAssignmentAvg();
            System.out.printf("\t%.0f\t\t\t", assignment.getAssignmentAverage());
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return String.format("%s - %s (%.1f credits", courseId, courseName, credits);
    }

    @Override
    public String toString() {
        String output = "";
        output += String.format("Course ID: %s\nCourseName: %s\nCredits: %.1f\nDepartment: %s\n",
                courseId, courseName, credits, department);
        output += String.format("Assignments: \n");
        for (Assignment assignment : assignments) {
            output += String.format("   %s\n", assignment.toString());
        }
        output += "Registered Students:\n";
        for (Student student : registeredStudents) {
            output += String.format("   %s\n", student.toSimplifiedString());
        }
        return output;
    }
}
