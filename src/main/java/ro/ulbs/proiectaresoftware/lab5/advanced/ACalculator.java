package ro.ulbs.proiectaresoftware.lab5.advanced;

public abstract class ACalculator {
    protected Object state;

    public Object result() {
        return state;
    }

    public ACalculator clear() {
        state = null;
        return this;
    }

    public abstract ACalculator init(Object value);
}