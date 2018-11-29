package com.leroy.ronan.hexagonalpoetry.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PoetryReaderShould {

    private PoetryLibrary library;

    @Before
    public void setUp() {
        library = () -> "If you could read a leaf or tree\n" +
                "you’d have no need of books.\n" +
                "-- © Alistair Cockburn (1987)";
    }

    @Test
    public void retrieve_poetry_from_library() throws LibraryException {
        PoetryReader poetryReader = new PoetryReader(library);

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                "If you could read a leaf or tree\n" +
                        "you’d have no need of books.\n" +
                        "-- © Alistair Cockburn (1987)",
                poem
        );
    }

}
