package br.com.anagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AnagramGenerator {

    public static List<String> generate(Set<String> characterSet) {
        List<String> list = new ArrayList<>(characterSet);
        List<String> results = new ArrayList<>();
        permute(list, 0, results);
        return results;
    }

    private static void permute(List<String> list, int index, List<String> results) {
        if (index == list.size() - 1) {
            results.add(String.join("", list));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, i, index);
            permute(list, index + 1, results);
            Collections.swap(list, i, index);
        }
    }
}

