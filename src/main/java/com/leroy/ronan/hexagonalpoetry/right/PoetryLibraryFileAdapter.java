package com.leroy.ronan.hexagonalpoetry.right;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import com.leroy.ronan.hexagonalpoetry.domain.PoetryLibrary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PoetryLibraryFileAdapter implements PoetryLibrary {

    private String filePath;

    public PoetryLibraryFileAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getAPoem() throws LibraryException {
        try {
            return Files.lines(Paths.get(filePath))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new LibraryException(e);
        }
    }
}
