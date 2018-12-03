package com.leroy.ronan.hexagonalpoetry.right.text;

import com.leroy.ronan.hexagonalpoetry.domain.Poem;
import com.leroy.ronan.hexagonalpoetry.right.PoetryLibraryFileReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class PoetryLibraryTextFileReader implements PoetryLibraryFileReader {

    @Override
    public List<Poem> getPoems(InputStream input) {
        Poem poem = new Poem(getPoemFromText(input));
        return List.of(poem);
    }

    private String getPoemFromText(InputStream input) {
        return new BufferedReader(
                new InputStreamReader(input)
        ).lines().collect(Collectors.joining("\n"));
    }
}
