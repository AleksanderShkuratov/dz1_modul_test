package action.rotate;

import entity.Direction;

public interface Rotatable {
    Direction getDirection();

    int getAngularVelocity();

    void setDirection(Direction newDirection);
}
