package com.leroy.ronan.hexagonalpoetry.domain;

public class Poem {

    private String author;
    private String title;
    private String publicationYear;
    private String poem;

    public Poem(String poem) {
        this.poem = poem;
    }

    public Poem(String author, String title, String publicationYear, String poem) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.poem = poem;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getPoem() {
        return poem;
    }
}
