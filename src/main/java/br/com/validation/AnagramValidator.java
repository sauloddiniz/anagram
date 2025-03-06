package br.com.validation;

public class AnagramValidator implements AnagramValidation {

    @Override
    public void anagramSizeValidate(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("characterSet must have at least 2 characters");
        }
    }
}
