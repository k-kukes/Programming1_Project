package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;
    private static int nextId = 0;

    public boolean registerCourse(Course course) {
        // checks if course is already registered
        if (registeredCourses.contains(course)) {
            return false;
        }
        // adds the course to registeredCourses
        registeredCourses.add(course);
        // adds student to the course's registeredStudents list
        course.getRegisteredStudents().add(this);
        // adds null for the scores of each assignment
        for (Assignment assignment: course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    public boolean dropCourse(Course course) {
        // if the course is not registered yet, directly returns `false`
        if (!registeredCourses.contains(course)) {
            return false;
        }
        // remove the course from the registeredCourses
        registeredCourses.remove(course);
        // remove the student from the registeredStudents
        course.getRegisteredStudents().remove(this);
        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.studentId = "S" + String.format("%06d", nextId++);
        this.registeredCourses = new ArrayList<>();
    }

    public String toSimplifiedString() {
        return String.format("%s %s %s", studentId, studentName, department.getDepartmentName());
    }
}
