import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SqueareRootTest {

    @Test
    void solveTest1() throws Exception {

        // function x^2 + 1 = 0; корней нет
        // необходимо проверить что при x^2 + 1 = 0 функция возвращает пустой массив

        // arrange
        // выбираем данные из заданной функции
        double a = 1;
        double b = 0;
        double c = 1;

        double epsilon = 1.0e-10;

        // act
        SqueareRoot squeare = new SqueareRoot();
        double[] result = squeare.solve(a, b, c, epsilon);

        int length = result.length;

        // assert
        Assertions.assertEquals(0, length);

    }

    @Test
    void solveTest2() throws Exception{

        // function x^2 - 1 = 0; есть два корня кратности 1 (x1=1, x2=-1)
        // необходимо проверить что при x^2 - 1 = 0
        // функция возвращает массив с 2-мя значениями 1 и -1

        // arrange
        // выбираем данные из заданной функции

        double a = 1;
        double b = 0;
        double c = -1;

        double epsilon = 1.0e-10;

        // act
        SqueareRoot squeare = new SqueareRoot();
        double[] result = squeare.solve(a, b, c, epsilon);

        int length = result.length;

        // assert
        Assertions.assertEquals(2, length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(-1, result[1]);

    }

    @Test
    void solveTest3() throws Exception{

        // function x^2+2x+1 = 0; есть ОДИН корень кратности 2(x1=x2=-1)
        // необходимо проверить что при x^2+2x+1 = 0
        // функция возвращает массив с с 2-мя значениями равными -1

        // arrange
        // выбираем данные из заданной функции

        double a = 1;
        double b = 2;
        double c = 1;

        double epsilon = 1.0e-10;

        // act
        SqueareRoot squeare = new SqueareRoot();
        double[] result = squeare.solve(a, b, c, epsilon);

        int length = result.length;

        // assert
        Assertions.assertEquals(2, length);
        Assertions.assertEquals(-1, result[0]);
        Assertions.assertEquals(-1, result[0]);

    }


    @Test
    void solveTest4() throws Exception{

        // коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение.
        // В этом случае solve выбрасывает исключение.

        // assert

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = 0;
            Random r = new Random();
            double rangeMin = 0.0d;
            double rangeMax = 10.0d;
            double b = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            double c = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);

        });

    }


}