package ro.ulbs.proiectaresoftware.lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test adunare")
    void testAdd() {
        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test scadere")
    void testSubtract() {
        int result = calculator.subtract(10, 4);

        assertEquals(6, result);
    }

    @Test
    @DisplayName("Test inmultire")
    void testMultiply() {
        int result = calculator.multiply(5, 4);

        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test impartire")
    void testDivide() {
        double result = calculator.divide(10, 2);

        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test impartire la zero")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @DisplayName("Test numar pozitiv")
    void testIsPositive() {
        assertTrue(calculator.isPositive(7));
        assertFalse(calculator.isPositive(-3));
    }

    @Test
    @DisplayName("Test obiect calculator nenul")
    void testCalculatorIsNotNull() {
        assertNotNull(calculator);
    }
}