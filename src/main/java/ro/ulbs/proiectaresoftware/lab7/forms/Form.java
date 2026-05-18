package ro.ulbs.proiectaresoftware.lab7.forms;

public abstract class Form {
    private static int instanceCount = 0;
    private final String color;

    public Form(String color) {
        this.color = color;
        instanceCount++;
    }

    public String getColor() {
        return color;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public abstract float getArea();

    @Override
    public String toString() {
        return "color='" + color + '\'';
    }
}