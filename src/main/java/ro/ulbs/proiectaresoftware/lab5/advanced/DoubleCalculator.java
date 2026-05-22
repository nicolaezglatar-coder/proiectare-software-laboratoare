package ro.ulbs.proiectaresoftware.lab5.advanced;

public class DoubleCalculator extends ACalculator {
    @Override
    public DoubleCalculator init(Object value) {
        state = (Double) value;
        return this;
    }

    public DoubleCalculator add(Double value) {
        state = (Double) state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        state = (Double) state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        state = (Double) state * value;
        return this;
    }
}