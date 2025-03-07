package br.com.anagram;

import br.com.CharacterSetFabric;
import br.com.validation.AnagramValidation;
import br.com.validation.CharacterValidation;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


public class AnagramOrchestrator {

    private final CharacterSetFabric fabric;
    private final CharacterValidation validator;
    private final AnagramValidation anagramValidation;
    private final Logger log = Logger.getLogger(AnagramOrchestrator.class.getName());

    public AnagramOrchestrator(CharacterSetFabric fabric, CharacterValidation validator, AnagramValidation anagramValidation) {
        this.fabric = fabric;
        this.validator = validator;
        this.anagramValidation = anagramValidation;
    }

    public List<String> create(String[] args) {
        log.info("Creating anagrams");

        Set<String> characterSet = fabric.create(args);
        log.info("Characters created");

        characterSet.forEach(validator::validate);
        anagramValidation.anagramSizeValidate(characterSet.size());
        log.info("Characters validated");

        List<String> anagrams = AnagramGenerator.generate(characterSet);
        log.info("Anagrams generated");

        return anagrams;
    }
}

