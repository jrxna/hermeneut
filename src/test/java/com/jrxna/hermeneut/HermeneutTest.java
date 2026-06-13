package com.jrxna.hermeneut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HermeneutTest {
    @Test
    void returnsVersion() {
        assertEquals("0.1.0", Hermeneut.version());
    }
}