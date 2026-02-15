package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dal.HashCalculator;

public class HashCalculatorTest {

    @Test
    void testSameInputSameHash() throws Exception {

        // same content should produce same hash
        String text = "hello world";

        String hash1 = HashCalculator.calculateHash(text);
        String hash2 = HashCalculator.calculateHash(text);

        assertEquals(hash1, hash2);
    }

    @Test
    void testModifiedTextChangesHash() throws Exception {

        // editing text should change hash
        String original = "hello world";
        String edited   = "hello world edited";

        String originalHash = HashCalculator.calculateHash(original);
        String editedHash   = HashCalculator.calculateHash(edited);

        assertNotEquals(originalHash, editedHash);
    }
}
