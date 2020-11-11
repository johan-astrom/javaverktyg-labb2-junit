import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
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
    @ValueSource(ints = {1, 2, 3, 10, -101, Integer.MAX_VALUE-1, Integer.MIN_VALUE})
    void test_add_method(int num){
        assertEquals(1+num, calc.add(1, num));
    }

    @Test
    void test_add_method_not_equals(){
        assertNotEquals(5, calc.add(2, 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, -101, Integer.MAX_VALUE, Integer.MIN_VALUE+1})
    void test_subtract_method(int num){
        assertEquals(num-1, calc.subtract(num, 1));
    }

    @Test
    void test_subtract_method_not_equals(){
        assertNotEquals(5, calc.subtract(6, 2));
    }



}
