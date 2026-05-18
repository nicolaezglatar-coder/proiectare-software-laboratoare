package ro.ulbs.proiectaresoftware.lab6;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Nu se poate imparti la zero");
        }

        return (double) a / b;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }
}