package ro.ulbs.proiectaresoftware.lab5;

class IntCalculator {
    protected int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    public IntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public IntCalculator subtract(int value) {
        this.state -= value;
        return this;
    }

    public IntCalculator multiply(int value) {
        this.state *= value;
        return this;
    }

    public int result() {
        return this.state;
    }

    public IntCalculator clear() {
        this.state = 0;
        return this;
    }
}

class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int state) {
        super(state);
    }

    public AdvancedCalculator divide(int value) {
        this.state /= value;
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        this.state = (int) Math.pow(this.state, exponent);
        return this;
    }

    public AdvancedCalculator root(int n) {
        this.state = (int) Math.pow(this.state, 1.0 / n);
        return this;
    }
}

public class AppLab5 {
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);

        int result = calculator.add(5).subtract(3).multiply(2).result();

        System.out.println("a) " + result);

        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);

        int result2 = advancedCalculator
                .divide(2)
                .power(2)
                .root(2)
                .result();

        System.out.println("b) " + result2);
    }
}