package com.leroy.ronan.hexagonalpoetry.right;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import org.junit.Assert;
import org.junit.Test;

public class PoetryLibraryFileAdapterShould {

    @Test
    public void retrieve_poetry_from_resources() throws LibraryException {
        PoetryLibraryFileAdapter library = new PoetryLibraryFileAdapter("C:\\library\\Rimbaud.txt");
        String poem = library.getAllPoems().get(0).getPoem();
        Assert.assertEquals(124, poem.split("\n").length);
    }

    @Test
    public void retrieve_poetry_from_json() throws LibraryException {
        PoetryLibraryFileAdapter library = new PoetryLibraryFileAdapter("C:\\library\\Poetry.json");
        String poem = library.getAllPoems().get(0).getPoem();
        Assert.assertEquals(124, poem.split("\n").length);
    }
}
