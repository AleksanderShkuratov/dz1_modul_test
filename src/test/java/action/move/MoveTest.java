package action.move;

import entity.Vector;
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

class MoveTest {
    Movable movable;
    Move move;

    @BeforeEach
    void setUp(){
        movable = mock(Movable.class);
        move = new Move(movable);
    }

    @Test
    @DisplayName("Для объекта, находящегося в точке (12, 5) " +
            "и движущегося со скоростью (-7, 3) " +
            "движение меняет положение объекта на (5, 8)")
    void changingPositionOfObjectBodyTest() {
        doReturn(new Vector(12, 5))
                .when(movable)
                .getPosition();
        doReturn(new Vector(-7, 3))
                .when(movable)
                .getVelocity();
        doNothing()
                .when(movable)
                .setPosition(any());

        move.execute();

        verify(movable).setPosition(eq(new Vector(5, 8)));
    }

    @Test
    @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке")
    void test2() {
        doThrow(new NullPointerException())
                .when(movable)
                .getPosition();

        Assertions.assertThrows(Exception.class, () -> {
            move.execute();
        });
    }

    @Test
    @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке")
    void test3() {
        doReturn(new Vector(12, 5))
                .when(movable)
                .getPosition();
        doThrow(new NullPointerException())
                .when(movable)
                .getVelocity();

        Assertions.assertThrows(Exception.class, () -> {
            move.execute();
        });
    }

    @Test
    @DisplayName("Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке")
    void test4() {
        doReturn(new Vector(12, 5))
                .when(movable)
                .getPosition();
        doReturn(new Vector(-7, 3))
                .when(movable)
                .getVelocity();
        doThrow(new RuntimeException())
                .when(movable)
                .setPosition(any());

        Assertions.assertThrows(Exception.class, () -> {
            move.execute();
        });
    }

}