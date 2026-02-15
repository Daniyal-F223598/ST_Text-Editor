package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dal.TFIDFCalculator;

public class TFIDFCalculatorTest {

    @Test
    void testTFIDFPositive() {

        // should compute TF-IDF score for known corpus
        TFIDFCalculator calc = new TFIDFCalculator();

        calc.addDocumentToCorpus("apple banana");
        calc.addDocumentToCorpus("apple apple orange");
        double score = calc.calculateDocumentTfIdf("apple banana");

        // score should be a valid numeric value
        assertTrue(score >= 0);
    }

    @Test
    void testTFIDFEmptyInput() {

        // should handle empty document without crashing
        TFIDFCalculator calc = new TFIDFCalculator();

        calc.addDocumentToCorpus("apple banana");
        double score = calc.calculateDocumentTfIdf("");

        // depending on implementation, NaN or 0 may appear
        assertFalse(Double.isInfinite(score));
    }
}
