import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {

        // function x^2 + 1 = 0;
        //

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффициент a:");
        double a = scanner.nextDouble();

        System.out.println("Введите коэффициент b:");
        double b = scanner.nextDouble();

        System.out.println("Введите коэффициент c:");
        double c = scanner.nextDouble();

        double epsilon = 1.0e-10;

        SqueareRoot squeare = new SqueareRoot();

        double[] result = squeare.solve(a, b, c, epsilon);

        if (result.length == 0){
            System.out.println("Kорней нет");
        }

        for (double i : result) {
            System.out.println("x = " + i);
        }

    }
}
