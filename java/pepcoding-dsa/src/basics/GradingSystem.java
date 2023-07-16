package basics;

public class GradingSystem {
    public static void main (String[] args) {
        int marks = 96;

        if (marks > 90) {
            System.out.println("Excellent");
        } else if (marks > 80) {
            System.out.println("Good");
        } else if (marks > 70) {
            System.out.println("fair");
        } else if (marks > 60) {
            System.out.println("Meets Expectations");
        } else {
            System.out.println("Below par");
        }
    }
}
