package com.leroy.ronan.hexagonalpoetry.left.web;

import com.leroy.ronan.hexagonalpoetry.domain.PoetryLibrary;
import com.leroy.ronan.hexagonalpoetry.domain.PoetryReader;
import com.leroy.ronan.hexagonalpoetry.domain.VersesProvider;
import com.leroy.ronan.hexagonalpoetry.right.PoetryLibraryFileAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    public PoetryLibrary poetryLibrary() {
        return new PoetryLibraryFileAdapter("C:\\library\\Poetry.json");
    }

    @Bean
    public VersesProvider poetryReader(PoetryLibrary library) {
        return new PoetryReader(library);
    }
}
