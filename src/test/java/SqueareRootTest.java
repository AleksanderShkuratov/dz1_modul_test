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
            double b = getDoubleRandom();
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);

        });

    }

    @Test
    void solveTest5() throws Exception{

        // подобрать такие коэффициенты квадратного уравнения для случая одного корня кратности два,
        // чтобы дискриминант был отличный от нуля, но меньше заданного эпсилон.

        // arrange
        // выбираем данные из заданной функции

        double a = 1;
        double b = 2.01;
        double c = 1;
        double epsilon = 1.0e-1;

        // act
        SqueareRoot squeare = new SqueareRoot();
        double[] result = squeare.solve(a, b, c, epsilon);

        int length = result.length;

        // assert
        Assertions.assertEquals(2, length);
        Assertions.assertEquals(-1.005, result[0]);
        Assertions.assertEquals(-1.005, result[0]);

    }

    @Test
    void solveTest6() throws Exception{

        // Посмотреть какие еще значения могут принимать числа типа double,
        // кроме числовых и написать тест с их использованием на все коэффициенты.
        // solve должен выбрасывать исключение.

        // assert a

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = Double.NaN;
            double b = getDoubleRandom();
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = Double.NEGATIVE_INFINITY;
            double b = getDoubleRandom();
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = Double.POSITIVE_INFINITY;
            double b = getDoubleRandom();
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        // assert b

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = Double.NaN;
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = Double.NEGATIVE_INFINITY;
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = Double.POSITIVE_INFINITY;
            double c = getDoubleRandom();
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        // assert c

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = getDoubleRandom();
            double c = Double.NaN;
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = getDoubleRandom();
            double c = Double.NEGATIVE_INFINITY;
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

        Assertions.assertThrows(Exception.class, ()->{
            // arrange
            double a = getDoubleRandom();
            double b = getDoubleRandom();
            double c = Double.POSITIVE_INFINITY;
            double epsilon = 1.0e-10;

            // act
            SqueareRoot squeare = new SqueareRoot();
            double[] result = squeare.solve(a, b, c, epsilon);
        });

    }

    private double getDoubleRandom(){
        Random r = new Random();
        double rangeMin = Double.MIN_VALUE;
        double rangeMax = Double.MAX_VALUE;
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }


}