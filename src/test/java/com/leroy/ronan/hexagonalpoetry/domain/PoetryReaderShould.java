package com.leroy.ronan.hexagonalpoetry.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class PoetryReaderShould {

    @Test
    public void retrieve_poetry_from_library() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                new Poem(
                        "If you could read a leaf or tree\n" +
                        "you’d have no need of books.\n" +
                        "-- © Alistair Cockburn (1987)"
                )
        );
        PoetryReader poetryReader = new PoetryReader(library);

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                new Poem(
                        "If you could read a leaf or tree\n" +
                        "you’d have no need of books.\n" +
                        "-- © Alistair Cockburn (1987)"
                ).getPoem(),
                poem
        );
    }

    @Test
    public void retrieve_poetry_from_multi_poems_library() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                new Poem(
                        "If you could read a leaf or tree\n" +
                        "you’d have no need of books.\n" +
                        "-- © Alistair Cockburn (1987)"
                ),
                new Poem(
                        "I want to sleep\n" +
                        "Swat the files\n" +
                        "Softly, please.\n" +
                        "-- Masaoka Shiki (1867 - 1902)."
                )
        );
        PoetryReader poetryReader = new PoetryReader(library, new Random(42L));

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                "I want to sleep\n" +
                "Swat the files\n" +
                "Softly, please.\n" +
                "-- Masaoka Shiki (1867 - 1902).",
                poem
        );
    }

    @Test
    public void format_a_poem_using_its_title_author_and_date() {

    }
}