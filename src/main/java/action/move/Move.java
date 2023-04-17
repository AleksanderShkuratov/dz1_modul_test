package action.move;

import action.Command;
import entity.Vector;

public class Move implements Command {

    private final Movable movable;

    public Move(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void execute() {
        movable.setPosition(Vector.changingPosition(movable.getPosition(),movable.getVelocity()));
    }
}
