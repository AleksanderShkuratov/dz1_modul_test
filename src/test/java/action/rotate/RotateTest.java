package action.rotate;

import entity.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RotateTest {

    Rotatable rotatable;
    Rotate rotate;

    @BeforeEach
    void setUp() {
        rotatable = mock();
        rotate = new Rotate(rotatable);
    }

    @Test
    @DisplayName("Для объекта, " +
            "находящегося в угловом положении 6 из 8 " +
            "и поворачивающегося с угловой скоростью 4, " +
            "движение меняет угловое положение объекта на 2")
    void rotateTest() {
        doReturn(new Direction(6))
                .when(rotatable)
                .getDirection();
        doReturn(4)
                .when(rotatable)
                .getAngularVelocity();
        doNothing()
                .when(rotatable)
                .setDirection(any());

        rotate.execute();

        verify(rotatable).setDirection(eq(new Direction(2)));
    }


    @Test
    @DisplayName("Попытка повернуть объект," +
            " у которого невозможно прочитать угловую скорость," +
            " приводит к ошибке")
    void impossibleToReadAngularVelocityTest() {
        doThrow(new NullPointerException())
                .when(rotatable)
                .getAngularVelocity();

        Assertions.assertThrows(Exception.class, () -> {
            rotate.execute();
        });
    }

    @Test
    @DisplayName("Попытка повернуть объект," +
            " у которого невозможно прочитать направление," +
            " приводит к ошибке")
    void impossibleToReadDirection() {
        doReturn(-4)
                .when(rotatable)
                .getAngularVelocity();
        doThrow(new NullPointerException())
                .when(rotatable)
                .getDirection();

        Assertions.assertThrows(Exception.class, () -> {
            rotate.execute();
        });
    }

    @Test
    @DisplayName("Попытка повернуть объект," +
            " у которого невозможно изменить направление," +
            " приводит к ошибке")
    void impossibleToChangeDirection() {
        doReturn(new Direction(2))
                .when(rotatable)
                .getDirection();
        doReturn(-4)
                .when(rotatable)
                .getAngularVelocity();
        doThrow(new RuntimeException())
                .when(rotatable)
                .setDirection(any());

        Assertions.assertThrows(Exception.class, () -> {
            rotate.execute();
        });
    }

}