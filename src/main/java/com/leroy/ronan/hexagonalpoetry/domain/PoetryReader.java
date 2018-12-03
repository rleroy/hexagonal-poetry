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
        return format(
                poems.get(random.nextInt(poems.size()))
        );
    }

    private String format(Poem poem) {
        return formatTitle(poem) +
                poem.getPoem() +
                formatAuthorAndDate(poem);
    }

    private String formatTitle(Poem poem) {
        String res = "";
        if (poem.getTitle() != null) {
            res = "== " + poem.getTitle() + " ==\n";
        }
        return res;
    }

    private String formatAuthorAndDate(Poem poem) {
        String res = "";
        if (poem.getAuthor() != null) {
            res += "\n-- " + poem.getAuthor();
            if (poem.getPublicationYear() != null) {
                res += " (" + poem.getPublicationYear() + ")";
            }
        }
        return res;
    }
}
