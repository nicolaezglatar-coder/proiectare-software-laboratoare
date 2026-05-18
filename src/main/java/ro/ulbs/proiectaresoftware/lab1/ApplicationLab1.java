package ro.ulbs.proiectaresoftware.lab1;

interface Shape {
    double getArea();
    String getName();
}

abstract class AbstractShape implements Shape {
    protected String color;

    public AbstractShape(String color) {
        this.color = color;
    }

    public void printColor() {
        System.out.println("Culoare: " + color);
    }
}

class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side, String color) {
        this(side, side, color);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return getName() + " width=" + width + ", height=" + height + ", area=" + getArea();
    }
}

class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return getName() + " radius=" + radius + ", area=" + getArea();
    }
}

class Drawing {
    private Shape shape;

    public Drawing(Shape shape) {
        this.shape = shape;
    }

    public void showShape() {
        System.out.println(shape);
    }
}

public class ApplicationLab1 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5, "red");
        Rectangle r2 = new Rectangle(3, "blue");
        Circle c1 = new Circle(2, "green");

        System.out.println(r1);
        r1.printColor();

        System.out.println(r2);
        r2.printColor();

        System.out.println(c1);
        c1.printColor();

        Drawing drawing = new Drawing(c1);
        drawing.showShape();
    }
}