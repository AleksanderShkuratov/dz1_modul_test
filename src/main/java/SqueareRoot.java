public class SqueareRoot {

    double[] solve(double a, double b, double c, double epsilon) {

        double D = Math.pow(b, 2) - 4 * a * c;

        // discriminant < 0
        if (D < -epsilon) {
            return new double[0];
        } else if (D > epsilon) {
            double[] result = new double[2];

            // не работает формула из доп. материалов стр.20
            // при b = 0.0 Math.signum(b) получается равным 0.0
            // дальнейшее умножение на Math.sqrt(D) и деление на 2 приводит к результату x1 = -0.0 и x2 = Infinity
//            double x1 = -(b + Math.signum(b) * Math.sqrt(D)) / 2;
//            double x2 = c / x1;

            // "школьная" формула работает
            double x1 = (-b + Math.sqrt(D)) / 2;
            double x2 = (-b - Math.sqrt(D)) / 2;

            result[0] = x1;
            result[1] = x2;

            return result;
        }

        return new double[1];
    }







}
