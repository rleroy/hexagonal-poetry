package com.leroy.ronan.hexagonalpoetry.right;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PoetryLibraryJsonFileReader implements PoetryLibraryFileReader {

    public List<Poem> getPoems(InputStream input) throws IOException {
        TypeReference<Poems> typeReference = new TypeReference<>(){};
        ObjectMapper mapper = new ObjectMapper();
        Poems poems = mapper.readValue(input, typeReference);
        return poems.getPoems();
    }
}
