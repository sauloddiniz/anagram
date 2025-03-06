package br.com;

import br.com.anagram.AnagramOrchestrator;
import br.com.validation.AnagramValidation;
import br.com.validation.AnagramValidator;
import br.com.validation.CharacterValidation;
import br.com.validation.CharacterValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    private CharacterSetBuilder characterSetBuilder;
    private CharacterValidation characterValidation;
    private AnagramValidation anagramValidation;

    @BeforeEach
    void setUp() {
        characterSetBuilder = new CharacterSetBuilder();
        characterValidation = new CharacterValidator();
        anagramValidation = new AnagramValidator();
    }

    @Test
    public void testCreate() {

        String[] args = {"a,b"};
        final int expectedSizeAnagrams = 2;

        AnagramOrchestrator anagram =
                new AnagramOrchestrator(characterSetBuilder, characterValidation, anagramValidation);

        List<String> anagrams = anagram.create(args);

        assertNotNull(anagrams);
        assertEquals(expectedSizeAnagrams, anagrams.size());
        assertTrue(anagrams.contains("ab"));
        assertTrue(anagrams.contains("ba"));
    }
}
