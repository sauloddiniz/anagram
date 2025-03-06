package br.com.validation;

public class CharacterValidator implements CharacterValidation {

    @Override
    public void validate(String character) {
        if (character == null || character.isEmpty()) {
            throw new IllegalArgumentException("character cannot be null or empty");
        }
        if (!character.matches("^[a-zA-Z]$")) {
            throw new IllegalArgumentException("character must be a letter");
        }
    }

}
