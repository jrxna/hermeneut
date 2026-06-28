package com.jrxna.hermeneut;

import com.jrxna.hermeneut.model.Document;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;

class HermeneutTest {

    private static Document document;

    @BeforeAll
    static void parseTestFile() throws IOException {
        String input = Files.readString(Path.of("src/test/resources/test.hmt"));
        document = Hermeneut.parse(input);
    }

    @Test
    void parsesTitleFromFile() throws IOException {
        assertEquals("My First Post", document.title());
    }

    @Test
    void parsesThumbnailFromFile() throws IOException {
        assertEquals("file.png", document.thumbnail());
    }

    @Test
    void parsesCategoryFromFile() throws IOException {
        assertEquals("Beached", document.category());
    }

    @Test
    void parsesDateFromFile() throws IOException {
        assertEquals(LocalDate.parse("2026-06-28"), document.date());
    }

    @Test
    void parsesTagsFromFile() throws IOException {
        List<String> tags = document.tags();
        assertEquals(List.of("java", "parsing", "static-site"), tags);
    }
}