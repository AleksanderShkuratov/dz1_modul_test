package entity;

import java.util.Objects;

public class Direction {
    private final int directionsCount;
    private int position;


    public Direction(int position) {
        this.directionsCount = 8;
        this.position = position;
    }

    public Direction next(int angularVelocity) {
        int newPosition = (this.getPosition() + angularVelocity) % this.getDirectionsCount();
        return new Direction(newPosition >= 0 ? newPosition : this.directionsCount + newPosition);
    }

    public int getDirectionsCount() {
        return directionsCount;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return directionsCount == direction.directionsCount && position == direction.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directionsCount, position);
    }


}
