package br.com;

import br.com.anagram.AnagramOrchestrator;
import br.com.validation.AnagramValidation;
import br.com.validation.AnagramValidator;
import br.com.validation.CharacterValidation;
import br.com.validation.CharacterValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    private CharacterSetFabric characterSetFabric;
    private CharacterValidation characterValidation;
    private AnagramValidation anagramValidation;

    @BeforeEach
    void setUp() {
        characterSetFabric = new CharacterSetFabric();
        characterValidation = new CharacterValidator();
        anagramValidation = new AnagramValidator();
    }

    @Test
    @DisplayName("Should create anagrams with one argument")
    public void shouldCreateAnagramsWithOneArgument() {

        String[] args = {"a,b"};
        final int expectedSizeAnagrams = 2;

        AnagramOrchestrator anagram =
                new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

        List<String> anagrams = anagram.create(args);

        assertNotNull(anagrams);
        assertEquals(expectedSizeAnagrams, anagrams.size());
        assertTrue(anagrams.contains("ab"));
        assertTrue(anagrams.contains("ba"));
    }

    @Test
    @DisplayName("Should create anagrams with two arguments")
    public void shouldCreateAnagramsWithTwoArguments() {

        String[] args = {"a", "b"};
        final int expectedSizeAnagrams = 2;

        AnagramOrchestrator anagram =
                new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

        List<String> anagrams = anagram.create(args);

        assertNotNull(anagrams);
        assertEquals(expectedSizeAnagrams, anagrams.size());
        assertTrue(anagrams.contains("ab"));
        assertTrue(anagrams.contains("ba"));
    }

    @Test
    @DisplayName("Should create anagrams with three arguments")
    public void shouldCreateAnagramsWithThreeArguments() {

        String[] args = {"a", "b", "c"};
        final int expectedSizeAnagrams = 6;

        AnagramOrchestrator anagram =
                new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

        List<String> anagrams = anagram.create(args);

        assertNotNull(anagrams);
        assertEquals(expectedSizeAnagrams, anagrams.size());
        assertTrue(anagrams.contains("abc"));
        assertTrue(anagrams.contains("acb"));
        assertTrue(anagrams.contains("bac"));
        assertTrue(anagrams.contains("bca"));
        assertTrue(anagrams.contains("cab"));
        assertTrue(anagrams.contains("cba"));
    }

    @Test
    @DisplayName("Should throw error when arguments are null or empty")
    public void shouldThrowErrorWhenArgumentsAreNullOrEmpty() {

        String[] args = {};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("args cannot be null or empty", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw error when character set size is less than two")
    public void shouldThrowErrorWhenCharacterSetSizeIsLessThanTwo() {

        String[] args = {"a", ""};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("characterSet must have at least 2 characters", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when character set contains null element")
    public void shouldThrowExceptionWhenCharacterSetContainsNullElement() {

        String[] args = {"a", null};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("characterSet must have at least 2 characters", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when character set contains only null element")
    public void shouldThrowExceptionWhenCharacterSetContainsOnlyNullElement() {

        String[] args = {null};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("args cannot be null or empty", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw error when character set size is less than two using 1 arguments")
    public void shouldThrowErrorWhenCharacterSetSizeIsLessThanTwoUsing1Arguments() {

        String[] args = {"a,"};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("characterSet must have at least 2 characters", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when characters contain invalid symbols")
    public void shouldThrowExceptionWhenCharactersContainInvalidSymbols() {

        String[] args = {"a,1,3"};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("character must be a letter", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when character contains invalid format (multiple letters or non-letters)")
    public void shouldThrowExceptionWhenCharacterContainsInvalidFormat() {

        String[] args = {"a", "bd"};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("character must be a letter", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when character set size is less than two")
    public void shouldThrowExceptionWhenCharacterSetSizeIsLessThanTwo() {

        String[] args = {"a,", "b"};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("characterSet must have at least 2 characters", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when character set contains duplicate characters")
    public void shouldThrowExceptionWhenCharacterSetContainsDuplicateCharacters() {

        String[] args = {"a", "a"};

        try {
            AnagramOrchestrator anagram =
                    new AnagramOrchestrator(characterSetFabric, characterValidation, anagramValidation);

            anagram.create(args);
            fail("Should throw exception");
        } catch (Exception exception) {
            assertInstanceOf(IllegalArgumentException.class, exception);
            assertEquals("characterSet must have at least 2 characters", exception.getMessage());
        }
    }

}
