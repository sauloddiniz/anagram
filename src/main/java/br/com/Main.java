package br.com;

import br.com.anagram.AnagramOrchestrator;
import br.com.validation.AnagramValidation;
import br.com.validation.AnagramValidator;
import br.com.validation.CharacterValidation;
import br.com.validation.CharacterValidator;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        final Logger log = Logger.getLogger(Main.class.getName());
        final CharacterSetBuilder characterSetBuilder = new CharacterSetBuilder();
        final CharacterValidation characterValidation = new CharacterValidator();
        final AnagramValidation anagramValidation = new AnagramValidator();

        log.info("Starting application");

        AnagramOrchestrator anagram =
                new AnagramOrchestrator(characterSetBuilder, characterValidation, anagramValidation);
        List<String> anagrams = anagram.create(args);
        log.info("Anagrams created");
        for (String ana : anagrams) {
            System.out.println(ana);
        }
        System.out.println("total anagrams: " + anagrams.size());
        log.info("Application finished");
    }
}
