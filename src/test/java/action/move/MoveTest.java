package action.move;

import entity.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
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

}