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
    public void format_a_poem_using_its_author_and_date() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                new Poem(
                        "Alistair Cockburn",
                        null,
                        "1987",
                        "If you could read a leaf or tree\n" +
                                "you’d have no need of books."
                )
        );
        PoetryReader poetryReader = new PoetryReader(library);

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertEquals(
                "If you could read a leaf or tree\n" +
                "you’d have no need of books.\n" +
                "-- Alistair Cockburn (1987)",
                poem
        );
    }

    @Test
    public void format_a_poem_using_its_title() throws LibraryException {
        PoetryLibrary library = () -> List.of(
                new Poem(
                        "Charles BAUDELAIRE",
                        "L'albatros",
                        null,
                        "Souvent, pour s'amuser, les hommes d'équipage\nPrennent des albatros, vastes oiseaux des mers,\nQui suivent, indolents compagnons de voyage,\nLe navire glissant sur les gouffres amers.\n\nA peine les ont-ils déposés sur les planches,\nQue ces rois de l'azur, maladroits et honteux,\nLaissent piteusement leurs grandes ailes blanches\nComme des avirons traîner à côté d'eux.\n\nCe voyageur ailé, comme il est gauche et veule !\nLui, naguère si beau, qu'il est comique et laid !\nL'un agace son bec avec un brûle-gueule,\nL'autre mime en boitant, l'infirme qui volait !\n\nLe Poète est semblable au prince des nuées\nQui hante la tempête et se rit de l'archer ;\nExilé sur le sol au milieu des huées,\nSes ailes de géant l'empêchent de marcher."
                )
        );
        PoetryReader poetryReader = new PoetryReader(library);

        String poem = poetryReader.giveMeSomePoetry();

        Assert.assertTrue(poem.startsWith("== L'albatros ==\n"));
        Assert.assertTrue(poem.contains("\nPrennent des albatros, vastes oiseaux des mers,\n"));
        Assert.assertTrue(poem.endsWith("\n-- Charles BAUDELAIRE"));
    }
}