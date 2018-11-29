package com.leroy.ronan.hexagonalpoetry.domain;

public class PoetryReader implements VersesProvider {

    private PoetryLibrary library;

    public PoetryReader(PoetryLibrary library) {
        this.library = library;
    }

    public String giveMeSomePoetry() throws LibraryException {
        return library.getAPoem();
    }

}
