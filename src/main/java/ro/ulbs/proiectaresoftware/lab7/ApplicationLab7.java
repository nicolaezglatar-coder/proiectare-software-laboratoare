package ro.ulbs.proiectaresoftware.lab7;

import ro.ulbs.proiectaresoftware.lab7.forms.Circle;
import ro.ulbs.proiectaresoftware.lab7.forms.Form;
import ro.ulbs.proiectaresoftware.lab7.forms.Square;
import ro.ulbs.proiectaresoftware.lab7.forms.Triangle;
import ro.ulbs.proiectaresoftware.lab7.util.PasswordMaker;

public class ApplicationLab7 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1.1F, 2.0F, "red");
        Circle circle = new Circle(1.5F, "yellow");
        Square square = new Square(1.2F, "blue");

        System.out.println("Area = " + triangle.getArea() + " details: " + triangle);
        System.out.println("Area = " + circle.getArea() + " details: " + circle);
        System.out.println("Area = " + square.getArea() + " details: " + square);

        System.out.println("Total instance count is " + Form.getInstanceCount());

        PasswordMaker passwordMaker1 = PasswordMaker.getInstance();
        PasswordMaker passwordMaker2 = PasswordMaker.getInstance();

        System.out.println("Same singleton instance? " + (passwordMaker1 == passwordMaker2));
        System.out.println("Generated password: " + passwordMaker1.getPassword("Nicolae"));
    }
}