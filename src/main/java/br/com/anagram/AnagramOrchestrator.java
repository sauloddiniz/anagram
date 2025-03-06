package br.com.anagram;

import br.com.CharacterSetBuilder;
import br.com.validation.AnagramValidation;
import br.com.validation.CharacterValidation;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


public class AnagramOrchestrator {

    private final CharacterSetBuilder builder;
    private final CharacterValidation validator;
    private final AnagramValidation anagramValidation;
    private final Logger log = Logger.getLogger(AnagramOrchestrator.class.getName());

    public AnagramOrchestrator(CharacterSetBuilder builder, CharacterValidation validator, AnagramValidation anagramValidation) {
        this.builder = builder;
        this.validator = validator;
        this.anagramValidation = anagramValidation;
    }

    public List<String> create(String[] args) {
        log.info("Creating anagrams");

        Set<String> characterSet = builder.build(args);
        log.info("Characters created");

        characterSet.forEach(validator::validate);
        anagramValidation.anagramSizeValidate(characterSet.size());
        log.info("Characters validated");

        List<String> anagrams = AnagramGenerator.generate(characterSet);
        log.info("Anagrams generated");

        return anagrams;
    }
}

