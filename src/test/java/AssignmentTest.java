import org.example.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentTest {

    @Test
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Assignment1", 100, 0.3);
        assignment.setScores(Arrays.asList(40, 50, 10));
        double expectedResult = 50;
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Assignment1", 100, 0.3);
        assignment.setScores(Arrays.asList(0, 50, 10));
        double expectedResult = 30;
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Assignment1", 100, 0.3);
        assignment.setScores(Arrays.asList(40, 0, 10));
        double expectedResult = 25;
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Assignment1", 100, 0.3);
        assignment.setScores(Arrays.asList(40, 50, 0));
        double expectedResult = 45;
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcAssignmentAvg5() {
        Assignment assignment = new Assignment("Assignment1", 100, 0.3);
        assignment.setScores(Arrays.asList(0, 0, 0));
        double expectedResult = 0;
        double result = assignment.getAssignmentAverage();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void isAssignmentTotalWeightValid1() {

    }
}
