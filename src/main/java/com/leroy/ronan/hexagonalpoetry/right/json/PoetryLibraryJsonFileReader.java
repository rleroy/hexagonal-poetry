package com.leroy.ronan.hexagonalpoetry.right.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leroy.ronan.hexagonalpoetry.domain.Poem;
import com.leroy.ronan.hexagonalpoetry.right.PoetryLibraryFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class PoetryLibraryJsonFileReader implements PoetryLibraryFileReader {

    public List<Poem> getPoems(InputStream input) throws IOException {
        TypeReference<JsonPoems> typeReference = new TypeReference<>(){};
        ObjectMapper mapper = new ObjectMapper();
        JsonPoems poems = mapper.readValue(input, typeReference);
        return poems.getPoems().stream()
                .map(this::jsonPoemToPoem)
                .collect(Collectors.toList());
    }

    private Poem jsonPoemToPoem(JsonPoem json) {
        return new Poem(
                json.getTitle(),
                json.getAuthor(),
                json.getPublicationYear(),
                json.getPoem()
        );
    }
}
