package br.com;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CharacterSetBuilder {

    public Set<String> build(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("args cannot be null");
        }
        if (args[0] != null && args[0].contains(",")) {
            return Arrays.stream(args[0].split(","))
                    .filter(isNotBlank())
                    .collect(Collectors.toSet());
        }
        throw new IllegalArgumentException("args contains invalid characters");
    }

    private static Predicate<String> isNotBlank() {
        return c -> !c.isBlank();
    }

}
