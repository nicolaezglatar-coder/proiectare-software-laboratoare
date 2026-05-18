package ro.ulbs.proiectaresoftware.lab7.forms;

public class Circle extends Form {
    private final float radius;

    public Circle(float radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", " + super.toString() +
                '}';
    }
}