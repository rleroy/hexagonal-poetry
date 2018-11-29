package com.leroy.ronan.hexagonalpoetry;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import com.leroy.ronan.hexagonalpoetry.domain.PoetryLibrary;
import com.leroy.ronan.hexagonalpoetry.domain.PoetryReader;
import com.leroy.ronan.hexagonalpoetry.domain.VersesProvider;
import com.leroy.ronan.hexagonalpoetry.left.ConsoleAdapter;
import com.leroy.ronan.hexagonalpoetry.right.PoetryLibraryFileAdapter;

import java.util.Scanner;

public class HexagonalPoetryApplication {

    public static void main(String[] args) throws LibraryException {
        PoetryLibrary library = new PoetryLibraryFileAdapter("C:\\library\\MasaokaShiki.txt");
        VersesProvider poetryReader = new PoetryReader(library);
        ConsoleAdapter application = new ConsoleAdapter(poetryReader);

        System.out.println("Here is some...");
        application.showMeSomePoetry();
        System.out.println("Type enter to exit...");
        new Scanner(System.in).nextLine();
    }
}

