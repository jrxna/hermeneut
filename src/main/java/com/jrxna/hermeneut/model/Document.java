package com.jrxna.hermeneut.model;

import java.time.LocalDate;
import java.util.List;

public record Document(
        String title,
        String thumbnail,
        LocalDate date,
        String category,
        List<String> tags,
        List<Block> blocks) {
}