package com.leroy.ronan.hexagonalpoetry.domain;

import java.util.List;

public interface PoetryLibrary {
    List<Poem> getAllPoems() throws LibraryException;
}
