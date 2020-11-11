import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest{

    private Calculator calc;

    @BeforeAll
    static void message(){
        System.out.println("Performing Calculator tests...");
    }

    @BeforeEach
    void calcInstance(){
        calc = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 2.5, 3.12345, 10.234, -101, -1235.76543, Double.MAX_VALUE-1, Double.MIN_VALUE})
    void test_add_method(double num){
        assertEquals(1+num, calc.add(1, num));
    }

    @Test
    void test_add_method_not_equals(){
        assertNotEquals(5, calc.add(2, 2));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 2.5, 3.12345, 10.234, -101, -1235.76543, Double.MAX_VALUE, Double.MIN_VALUE+1})
    void test_subtract_method(double num){
        assertEquals(num-1, calc.subtract(num, 1));
    }

    @Test
    void test_subtract_method_not_equals(){
        assertNotEquals(5.3, calc.subtract(6.5, 2.2));
    }

    @ParameterizedTest
    @CsvSource({"1.4, 2.23", "2.123, 3", "10, -101", "2347543.123, 435.2"})
    void test_multiply_method(double num1, double num2){
        assertEquals(num1*num2, calc.multiply(num1, num2));
    }

    @Test
    void test_multiply_method_not_equals(){
        assertNotEquals(5.2, calc.multiply(6.23, 2));
    }

    @ParameterizedTest
    @CsvSource({"1.4, 2.23", "2.123, 3", "10, -101", "2347543.123, 435.2"})
    void test_divide_method(double num1, double num2){
        assertEquals(num1*num2, calc.divide(num1, num2));
    }

    @Test
    void test_divide_method_not_equals(){
        assertNotEquals(5.3, calc.multiply(6.234, 2.34));
    }



}
