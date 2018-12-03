package com.leroy.ronan.hexagonalpoetry.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class PoetryReaderShould {

    private static final Poem ALISTAIR_POEM = new Poem(
            "If you could read a leaf or tree\n" +
            "you’d have no need of books.\n" +
            "-- © Alistair Cockburn (1987)"
    );
    private static final Poem MASAOKA_SHIKI_POEM = new Poem(
            "I want to sleep\n" +
            "Swat the files\n" +
            "Softly, please.\n" +
            "-- Masaoka Shiki (1867 - 1902)."
    );

    @Test
    public void retrieve_poetry_from_library() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                ALISTAIR_POEM
        );
        PoetryReader poetryReader = new PoetryReader(library);

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                ALISTAIR_POEM.getPoem(),
                poem
        );
    }

    @Test
    public void retrieve_poetry_from_multi_poems_library() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                ALISTAIR_POEM,
                MASAOKA_SHIKI_POEM
        );
        PoetryReader poetryReader = new PoetryReader(library, new Random(42L));

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                MASAOKA_SHIKI_POEM.getPoem(),
                poem
        );
    }
}