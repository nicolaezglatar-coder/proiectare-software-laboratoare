package ro.ulbs.proiectaresoftware.lab5.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator intCalculator = new NewIntCalculator();

        Object resultInt = intCalculator
                .init(10)
                .add(5)
                .subtract(3)
                .multiply(2)
                .result();

        System.out.println("(10 + 5 - 3) * 2 = " + resultInt);

        DoubleCalculator doubleCalculator = new DoubleCalculator();

        Object resultDouble = doubleCalculator
                .init(10.0)
                .add(5.0)
                .subtract(3.3)
                .multiply(2.2)
                .result();

        System.out.println("(10 + 5 - 3.3) * 2.2 = " + resultDouble);
    }
}