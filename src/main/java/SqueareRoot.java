public class SqueareRoot {

    double[] solve(double a, double b, double c, double epsilon) throws Exception {

        check(a);
        check(b);
        check(c);

        if(!(Math.abs(a) >= epsilon)){
           throw  new Exception();
        }

        double D = Math.pow(b, 2) - 4 * a * c;

        // discriminant < 0
        if (D < -epsilon) {
            return new double[0];

            // discriminant > 0 но меньше эпсилона
        } else if (Math.abs(D) < epsilon) {
            double[] result = new double[2];
            result[0] = -b / (2 * a);
            result[1] = -b / (2 * a);
            return result;
        }

        // discriminant > 0 и больше эпсилона
        double[] result = new double[2];

        // не работает формула из доп. материалов стр.20
        // при b = 0.0 Math.signum(b) получается равным 0.0
        // дальнейшее умножение на Math.sqrt(D) и деление на 2 приводит к результату x1 = -0.0 и x2 = Infinity
//            result[0] = -(b + Math.signum(b) * Math.sqrt(D)) / 2;
//            result[1] = c / x1;

        // "школьная" формула работает
        result[0] = (-b + Math.sqrt(D)) / 2;
        result[1] = (-b - Math.sqrt(D)) / 2;
        return result;
    }

    private void check(double i) throws Exception{if(Double.isNaN(Math.abs(i)) || Math.abs(i) == Double.NEGATIVE_INFINITY || Math.abs(i) == Double.POSITIVE_INFINITY){
            throw  new Exception();
        }
    }

}
