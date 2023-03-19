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

}