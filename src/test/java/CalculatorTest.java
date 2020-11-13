import org.junit.jupiter.api.*;

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
        this.calc = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 2.5, 3.12345, 10.234, -101, -1235.76543, Double.MAX_VALUE-1, Double.MIN_VALUE})
    @DisplayName("Add method test")
    void test_add_method(double num){
        assertEquals(1+num, calc.add(1, num));
    }

    @Test
    @DisplayName("Add method not equals test")
    void test_add_method_not_equals(){
        assertNotEquals(5, calc.add(2, 2));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 2.5, 3.12345, 10.234, -101, -1235.76543, Double.MAX_VALUE, Double.MIN_VALUE+1})
    @DisplayName("Subtract method test")
    void test_subtract_method(double num){
        assertEquals(num-1, calc.subtract(num, 1));
    }

    @Test
    @DisplayName("Subtract method not equals test")
    void test_subtract_method_not_equals(){
        assertNotEquals(5.3, calc.subtract(6.5, 2.2));
    }

    @ParameterizedTest
    @CsvSource({"1.4, 2.23", "2.123, 3", "10, -101", "2347543.123, 435.2"})
    @DisplayName("Multiply method test")
    void test_multiply_method(double num1, double num2){
        assertEquals(num1*num2, calc.multiply(num1, num2));
    }

    @Test
    @DisplayName("Multiply method not equals test")
    void test_multiply_method_not_equals(){
        assertNotEquals(5.2, calc.multiply(6.23, 2));
    }

    @ParameterizedTest
    @CsvSource({"1.4, 2.23", "2.123, 3", "10, -101", "2347543.123, 435.2"})
    @DisplayName("Divide method test")
    void test_divide_method(double num1, double num2){
        assertEquals(num1/num2, calc.divide(num1, num2));
    }

    @Test
    @DisplayName("Divide method not equals test")
    void test_divide_method_not_equals(){
        assertNotEquals(5.3, calc.divide(6.234, 2.34));
    }

    @Test
    @DisplayName("Test exception")
    void test_exception(){
        assertThrows(NumberFormatException.class, () -> calc.add(Integer.parseInt("a"), 2));
    }

    @Disabled
    @DisplayName("Check test speed")
    @RepeatedTest(10000)
    void repeated_test(){
        calc.multiply(Integer.MAX_VALUE/2, 2);
    }

    @Disabled
    @Test
    @DisplayName("Cross-method test")
    void cross_method_test(){
        assertEquals((3-2)+(2*2), calc.add(calc.subtract(3,2), calc.multiply(2, 2)));
    }

    @AfterAll
    static void messageAfter(){
        System.out.println("Calculator tests completed.");
    }

}
