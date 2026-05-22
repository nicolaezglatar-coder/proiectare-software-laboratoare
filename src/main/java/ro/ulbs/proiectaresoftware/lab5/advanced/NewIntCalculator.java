package ro.ulbs.proiectaresoftware.lab5.advanced;

public class NewIntCalculator extends ACalculator {
    @Override
    public NewIntCalculator init(Object value) {
        state = (Integer) value;
        return this;
    }

    public NewIntCalculator add(Integer value) {
        state = (Integer) state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        state = (Integer) state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        state = (Integer) state * value;
        return this;
    }
}