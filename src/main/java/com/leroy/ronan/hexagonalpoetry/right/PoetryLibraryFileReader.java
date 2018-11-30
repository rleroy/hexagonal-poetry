package com.leroy.ronan.hexagonalpoetry.right;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface PoetryLibraryFileReader {
    List<Poem> getPoems(InputStream input) throws IOException;
}
