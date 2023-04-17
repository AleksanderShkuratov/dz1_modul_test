package action.rotate;

import action.Command;

public class Rotate implements Command {

    private final Rotatable rotatable;

    public Rotate(Rotatable rotatable) {
        this.rotatable = rotatable;
    }

    @Override
    public void execute() {
        rotatable.setDirection(rotatable.getDirection().next(rotatable.getAngularVelocity()));
    }
}
