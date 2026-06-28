package com.jrxna.hermeneut;

import com.jrxna.hermeneut.model.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Hermeneut {
    private Hermeneut() {
    }

    public static Document parse(String input) {
        String title = "";
        String thumbnail = "";
        String category = "";
        LocalDate date = LocalDate.now();
        List<String> tags = new ArrayList<>();

        for (String line : input.split("\\R")) {
            if (line.startsWith("title:")) {
                title = line.substring("title:".length()).trim();
            }

            if (line.startsWith("thumbnail:")) {
                thumbnail = line.substring("thumbnail:".length()).trim();
            }

            if (line.startsWith("category:")) {
                category = line.substring("category:".length()).trim();
            }

            if (line.startsWith("date:")) {
                date = LocalDate.parse(line.substring("date:".length()).trim());
            }

            if (line.startsWith("tags:")) {
                String tagsText = line.substring("tags:".length()).trim();

                for (String tag : tagsText.split(",")) {
                    tags.add(tag.trim());
                }

            }
        }

        return new Document(
                title,
                thumbnail,
                category,
                date,
                tags,
                List.of());
    }
}