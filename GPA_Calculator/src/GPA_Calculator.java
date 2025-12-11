import java.util.ArrayList;

public class GPA_Calculator {

    public static double gradeToPoint(double grade) {
        if (grade >= 90) return 4.0;
        if (grade >= 85) return 3.7;
        if (grade >= 80) return 3.3;
        if (grade >= 75) return 3.0;
        if (grade >= 70) return 2.7;
        if (grade >= 65) return 2.4;
        if (grade >= 60) return 2.2;
        if (grade >= 50) return 2.0;
        return 0.0;
    }

    public static double calculateGPA(ArrayList<Integer> hours, ArrayList<Double> grades) {
        double totalPoints = 0;
        int totalHours = 0;

        for (int i = 0; i < hours.size(); i++) {
            totalPoints += gradeToPoint(grades.get(i)) * hours.get(i);
            totalHours += hours.get(i);
        }

        return totalPoints == 0 ? 0 : totalPoints / totalHours;
    }
}