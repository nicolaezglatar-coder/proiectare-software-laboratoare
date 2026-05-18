package ro.ulbs.proiectaresoftware.lab7.forms;

public class Square extends Form {
    private final float side;

    public Square(float side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public float getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", " + super.toString() +
                '}';
    }
}