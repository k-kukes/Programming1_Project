package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId = "S";
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private Course[] registeredCourses;
    private static int nextId;

    public boolean registerCourse(Course course) {
        // creates a new registeredCourse array, replaces the old one
        if (registeredCourses == null) {
            registeredCourses =  new Course[1];
        } else {
            Course[] tempArray = registeredCourses;
            registeredCourses = new Course[registeredCourses.length + 1];
            for (int i = 0; i < tempArray.length; i++) {
                registeredCourses[i] = tempArray[i];
            }
        }

        // returns false if the course is already registered
        for (int i = 0; i < registeredCourses.length; i++) {
            if (registeredCourses[i] == course) {
                return false;
            }
        }

        // adds the course
        for (int i = 0; i < registeredCourses.length; i++) {
            if (registeredCourses[i] == null) {
                registeredCourses[i] = course;
            }
        }

        course.registerStudent(this); // registers student to the course

        // TO ADD: appends a `null` for the `scores` of each assignment of the course
        return true;
    }

    public boolean dropCourse(Course course) {
        boolean hasCourse = false;
        outer:
        for (Course course1 : registeredCourses) {
            if (course1 == course) {
                hasCourse = true;
                break outer;
            }
        }
        // if not registered, returns false
        if (!hasCourse) {
            return false;
        }
        // removes course
        for (int i = 0; i < registeredCourses.length; i++) {
            if (registeredCourses[i] == course) {
                registeredCourses[i] = null;
            }
        }
        // TO ADD: remove the student from the course's registeredStudents list
        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
    }


}
