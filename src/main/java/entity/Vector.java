package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Vector changingPosition (Vector position, Vector velocity){
        return new Vector(sumDouble(position.getX(), velocity.getX()),
                sumDouble(position.getY(), velocity.getY()));
    }

    private static double sumDouble(double summand1, double summand2){
        return BigDecimal.valueOf(summand1).add(BigDecimal.valueOf(summand2)).doubleValue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.getX(), getX()) == 0 && Double.compare(vector.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), y);
    }


}
