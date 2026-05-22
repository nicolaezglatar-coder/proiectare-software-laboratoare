package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NewIntCalculatorTest {

    @Test
    public void testInit() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init().result();

        assertEquals(0, result);
    }

    @Test
    public void testAdd() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init().add(10).add(5).result();

        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init().add(10).subtract(3).result();

        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init().add(10).multiply(2).result();

        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init().add(10).divide(2).result();

        assertEquals(5, result);
    }

    @Test
    public void testClear() {
        NewIntCalculator calculator = new NewIntCalculator();

        calculator.init().add(10).clear();

        assertNull(calculator.result());
    }

    @Test
    public void testExpression() {
        NewIntCalculator calculator = new NewIntCalculator();

        Integer result = calculator.init()
                .add(10)
                .add(5)
                .subtract(3)
                .multiply(2)
                .result();

        assertEquals(24, result);
    }
}