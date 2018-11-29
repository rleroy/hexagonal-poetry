package com.leroy.ronan.hexagonalpoetry.left;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import com.leroy.ronan.hexagonalpoetry.domain.VersesProvider;

public class ConsoleAdapter {

    private VersesProvider versesProvider;

    public ConsoleAdapter(VersesProvider versesProvider) {
        this.versesProvider = versesProvider;
    }

    public void showMeSomePoetry() throws LibraryException {
        System.out.println(versesProvider.giveMeSomePoetry());
    }
}
