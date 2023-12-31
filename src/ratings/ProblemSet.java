package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {

    public static double average(ArrayList<Double> numbers) {
        Double sum = 0.0;
        // numbers.forEach((num) -> sum += num);
        for (Double num : numbers) {
            sum += num;
        }
        return numbers.size() == 0 ? sum : sum / numbers.size();

        // TODO: Implement this method to return the average of all the numbers in the
        // input ArrayList
        // If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0

    }

    public static void main(String[] args) {
        HashMap<String, Integer> bills = new HashMap<>();
        bills.put("Allen", 17);
        bills.put("Diggs", 14);
        System.out.print("What is Allen's number? ");
        System.out.println(bills.get("Allen"));
        System.out.println(bills);
        for (String key : bills.keySet()) {
            System.out.println(key);
        }
        for (Integer value : bills.values()) {
            System.out.println(value);
        }
        for (String key : bills.keySet()) {
            int value = bills.get(key);
            System.out.print(key + "'s number is: ");
            System.out.println(value);
        }
        double a = 6.0;
        int b = 4;
        double c = a + b;
        System.out.println(c);
    }

    // TODO: Write a public static method named sumOfDigits that takes an int as a
    // parameter and
    // returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += Math.abs(num) % 10;
            num /= 10;
        }
        return sum;
    }

    // TODO: Write a public static method named bestKey that takes a HashMap of
    // String to Integer
    // as a parameter and returns a key mapping to the largest Integer. Ties can be
    // broken arbitrarily.
    // If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""
    public static String bestKey(HashMap<String, Integer> map) {
        String ret = "";
        int maxScore = 0;
        for (String key : map.keySet()) {
            int score = map.get(key);
            if (score > maxScore) {
                ret = key;
                maxScore = score;
            }
        }
        return ret;
    }

}
