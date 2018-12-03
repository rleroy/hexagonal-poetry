package com.leroy.ronan.hexagonalpoetry.domain;

import java.util.List;
import java.util.Random;

public class PoetryReader implements VersesProvider {

    private PoetryLibrary library;
    private Random random;

    public PoetryReader(PoetryLibrary library) {
        this(library, new Random());
        this.library = library;
    }

    PoetryReader(PoetryLibrary library, Random random) {
        this.library = library;
        this.random = random;
    }

    public String giveMeSomePoetry() throws LibraryException {
        List<Poem> poems = library.getAllPoems();
        return poems
                .get(random.nextInt(poems.size()))
                .getPoem();
    }
}
