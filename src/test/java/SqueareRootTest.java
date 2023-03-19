import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SqueareRootTest {

    @Test
    void solveTest1() {

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
    void solveTest2(){

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
    void solveTest3(){

        // function x^2+2x+1 = 0; есть ОДИН корень (x1=x2=-1)
        // необходимо проверить что при x^2+2x+1 = 0
        // функция возвращает массив с 1-м значением равным -1

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
        Assertions.assertEquals(1, length);
        Assertions.assertEquals(-1, result[0]);

    }



}