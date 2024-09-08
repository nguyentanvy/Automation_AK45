package supports;

public  class Untils {
    public static String calculateBmi(double weightInKg, double heightInMeters ){
        double bmi = weightInKg / (heightInMeters * heightInMeters*0.0001);

        return String.format("%.1f", bmi);
    }
}
