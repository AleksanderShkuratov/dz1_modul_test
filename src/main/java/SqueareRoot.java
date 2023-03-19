public class SqueareRoot {

    double[] solve(double a, double b, double c, double epsilon) {

        double D = Math.pow(b, 2) - 4 * a * c;

        // discriminant < 0
        if(D < -epsilon) {
            return new double[0];
        }

        return new double[1];
    }







}
