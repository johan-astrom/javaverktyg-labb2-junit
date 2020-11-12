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
    @NullSource
    void test_null(String s){
        assertNull(s, "String should be null");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/toUpperValues.csv")
    void test_toUpper(String input, String result){
        assertEquals(result, textProcessor.toUpper(input));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void test_toUpper_empty(String s){
        assertTrue(textProcessor.toUpper(s).isBlank(), "Should return true for blank strings");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/toLowerValues.csv")
    void test_toLower(String input, String result){
        assertEquals(result, textProcessor.toLower(input));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void test_toLower_empty(String s){
        assertTrue(textProcessor.toLower(s).isBlank(), "Should return true for blank strings");
    }

    
    
    
    @AfterAll
    static void messageAfter(){
        System.out.println("TextProcessor tests completed.");
    }

}
