import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest{

    private TextProcessor textProcessor;

    @BeforeAll
    static void message(){
        System.out.println("Performing TextProcessor tests...");
    }

    @BeforeEach
    void TextProcInstance(){
        this.textProcessor = new TextProcessor();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/toUpperValues.csv")
    void test_toUpper(String input, String result){
        assertEquals(result, textProcessor.toUpper(input));
    }

    @ParameterizedTest
    @NullSource
    void test_toUpper_null(String s){
        assertNull(s, "String should be null");
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void test_toUpper_empty(String s){
        assertTrue(s.isBlank(), "Should return true for blank strings");
    }
    
    
    
    @AfterAll
    static void messageAfter(){
        System.out.println("TextProcessor tests completed.");
    }

}
