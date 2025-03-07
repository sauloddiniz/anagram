package br.com;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CharacterSetFabric {

    public Set<String> create(String[] args) {

        validateArgs(args);

        if (args[0].contains(",")) {
            return generateFromCommaSeparated(args[0]);
        }

        if (args.length > 1) {
            return generateFromArgsArray(args);
        }

        throw new IllegalArgumentException("args contains invalid characters");
    }

    private void validateArgs(String[] args) {
        if (args == null || args.length < 1 || args[0] == null || args[0].isBlank()) {
            throw new IllegalArgumentException("args cannot be null or empty");
        }
    }

    private Set<String> generateFromCommaSeparated(String input) {
        return Arrays.stream(input.split(","))
                .filter(IS_NOT_BLANK)
                .collect(Collectors.toSet());
    }

    private Set<String> generateFromArgsArray(String[] args) {
        return Arrays.stream(args)
                .filter(Objects::nonNull)
                .filter(IS_NOT_BLANK)
                .collect(Collectors.toSet());
    }

    private static final Predicate<String> IS_NOT_BLANK = c -> !c.isBlank();

}
