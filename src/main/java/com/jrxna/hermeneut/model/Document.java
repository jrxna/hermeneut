package com.jrxna.hermeneut.model;

import java.time.LocalDate;
import java.util.List;

public record Document(
                String title,
                String thumbnail,
                String category,
                LocalDate date,
                List<String> tags,
                List<Block> blocks) {
}