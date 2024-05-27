package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.Random;

@Getter
@Setter

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private List<Integer> scores;
    private static int nextId;

    public Assignment(String assignmentName, int maxScore, double weight) {
        this.assignmentName = assignmentName;
        this.maxScore = maxScore;
        this.weight = weight;
    }

    public void calcAssignmentAvg() {
        double sum = 0.0;
        for (int score : scores) {
            sum += score;
            System.out.println(sum);
        }
        assignmentAverage = sum / scores.size();
        System.out.println(assignmentAverage);
    }

    public void generateRandomScore() {
        Random random = new Random();
        int randNum = random.nextInt(0, 11);

         int score = switch (randNum) {
            case 0 -> random.nextInt(0, 60);
            case 1, 2 -> random.nextInt(60, 70);
            case 3, 4 -> random.nextInt(70, 80);
            case 5, 6, 7, 8 -> random.nextInt(80, 90);
            case 9, 10 -> random.nextInt(90, 101);
            default -> 0;
        };

         if (scores == null) {
             scores = new ArrayList<>();
         }
         scores.add(score);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
