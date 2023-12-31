package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashMap;
// import java.util.*;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    Double EPSILON = 0.00001;

    @Test
    public void TestAveragePositive() {
        ArrayList<Double> positiveDoubles = new ArrayList<>(
                Arrays.asList(2.0, 3.0, 5.0));
        assertTrue("Test result for positive is ",
                Math.abs(ProblemSet.average(positiveDoubles) - 10.0 / 3.0) < EPSILON);
    }

    @Test
    public void TestAverageNegative() {
        ArrayList<Double> negativeDoubles = new ArrayList<>(
                Arrays.asList(-2.0, -3.0, -5.0));
        assertTrue("Test result for negative is ",
                Math.abs(ProblemSet.average(negativeDoubles) - (-10.0 / 3.0)) < EPSILON);
    }

    @Test
    public void TestAverageZero() {
        ArrayList<Double> zero = new ArrayList<>(
                Arrays.asList(2.0, 3.0, 5.0, 0.0));
        assertTrue("Test result for negative is ",
                Math.abs(ProblemSet.average(zero) - (10.0 / 4)) < EPSILON);
    }

    @Test
    public void TestsumOfDigits() {
        int positive = 103;
        int zero = 0;
        int negative = -123;
        assertTrue(ProblemSet.sumOfDigits(positive) == 4);
        assertTrue(ProblemSet.sumOfDigits(zero) == 0);
        System.out.println(ProblemSet.sumOfDigits(negative));
        assertTrue(ProblemSet.sumOfDigits(negative) == 6);
    }

    @Test
    public void TestbestKey() {
        HashMap<String, Integer> positive = new HashMap<String, Integer>() {
            {
                put("CSE", new Integer(1));
                put("test", new Integer(98));
                put("test3", new Integer(-1));
                put("test2", new Integer(100));
                put("test1", new Integer(0));

            }
        };
        assertTrue(positive.get(ProblemSet.bestKey(positive)).intValue() == 100);
    }

}