import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @CsvSource()

}
