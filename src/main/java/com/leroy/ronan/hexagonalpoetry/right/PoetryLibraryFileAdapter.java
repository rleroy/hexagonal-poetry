package com.leroy.ronan.hexagonalpoetry.right;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import com.leroy.ronan.hexagonalpoetry.domain.Poem;
import com.leroy.ronan.hexagonalpoetry.domain.PoetryLibrary;
import com.leroy.ronan.hexagonalpoetry.right.json.PoetryLibraryJsonFileReader;
import com.leroy.ronan.hexagonalpoetry.right.text.PoetryLibraryTextFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PoetryLibraryFileAdapter implements PoetryLibrary {

    private Path path;

    public PoetryLibraryFileAdapter(String filePath) {
        this.path = Paths.get(filePath);
    }

    @Override
    public List<Poem> getAllPoems() throws LibraryException {
        return readPoemsFromSource(this.path);
    }

    private List<Poem> readPoemsFromSource(Path path) throws LibraryException {
        PoetryLibraryFileReader reader = getPoetryLibraryFileReader(path);
        try(InputStream input = getLibraryContentStream(path)) {
            return reader.getPoems(input);
        } catch (IOException e) {
            throw new LibraryException(e);
        }
    }

    private PoetryLibraryFileReader getPoetryLibraryFileReader(Path path) {
        return isJson(path)
                ? new PoetryLibraryJsonFileReader()
                : new PoetryLibraryTextFileReader()
                ;
    }

    private InputStream getLibraryContentStream(Path path) throws IOException {
        return Files.exists(path)
                ? Files.newInputStream(path)
                : getResourceAsStream(path)
                ;
    }

    private boolean isJson(Path path) {
        return path.getFileName().toString().endsWith(".json");
    }

    private InputStream getResourceAsStream(Path path) {
        return this.getClass().getClassLoader().getResourceAsStream(
                path.getFileName().toString()
        );
    }
}
