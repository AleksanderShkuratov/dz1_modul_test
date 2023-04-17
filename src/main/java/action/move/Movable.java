package action.move;


import entity.Vector;

public interface Movable {
    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector newPosition);
}
