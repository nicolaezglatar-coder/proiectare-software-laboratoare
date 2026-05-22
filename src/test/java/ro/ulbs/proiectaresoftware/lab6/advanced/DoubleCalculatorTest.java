package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {

    @Test
    public void testInit() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init().result();

        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testAdd() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init().add(10.0).add(5.0).result();

        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testSubtract() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init().add(10.0).subtract(3.3).result();

        assertEquals(6.7, result, 0.0001);
    }

    @Test
    public void testMultiply() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init().add(10.0).multiply(2.2).result();

        assertEquals(22.0, result, 0.0001);
    }

    @Test
    public void testDivide() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init().add(10.0).divide(4.0).result();

        assertEquals(2.5, result, 0.0001);
    }

    @Test
    public void testClear() {
        DoubleCalculator calculator = new DoubleCalculator();

        calculator.init().add(10.0).clear();

        assertNull(calculator.result());
    }

    @Test
    public void testExpression() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init()
                .add(10.0)
                .add(5.0)
                .subtract(3.3)
                .multiply(2.2)
                .result();

        assertEquals(25.74, result, 0.0001);
    }
    @Test
    public void testMultiplyByZero() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init()
                .add(10.0)
                .multiply(0.0)
                .result();

        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testDivideByZero() {
        DoubleCalculator calculator = new DoubleCalculator();

        Double result = calculator.init()
                .add(10.0)
                .divide(0.0)
                .result();

        assertTrue(Double.isInfinite(result));
    }
}