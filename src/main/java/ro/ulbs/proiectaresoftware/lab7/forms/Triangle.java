package ro.ulbs.proiectaresoftware.lab7.forms;

public class Triangle extends Form {
    private final float base;
    private final float height;

    public Triangle(float base, float height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public float getArea() {
        return base * height / 2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", " + super.toString() +
                '}';
    }
}