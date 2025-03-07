package br.com;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testMain_executesWithoutExceptions() {
        String[] args = {"a","b","c"};

        Main.main(args);
    }

}
