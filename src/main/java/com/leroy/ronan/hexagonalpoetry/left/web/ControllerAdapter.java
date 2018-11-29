package com.leroy.ronan.hexagonalpoetry.left.web;

import com.leroy.ronan.hexagonalpoetry.domain.LibraryException;
import com.leroy.ronan.hexagonalpoetry.domain.VersesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdapter {

    private VersesProvider poetryReader;

    @Autowired
    public ControllerAdapter(VersesProvider poetryReader) {
        this.poetryReader = poetryReader;
    }

    @RequestMapping("/")
    public String showMeSomePoetry() throws LibraryException {
        return poetryReader.giveMeSomePoetry();
    }
}
