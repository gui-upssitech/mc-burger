package dev.upssitech.mcburger.modele.aliment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoissonTest {

    public static final String expected = "Boisson [nom='Mc EAU']";

    @Test
    void testToString() {
        Boisson boisson = new Boisson("Mc EAU");
        Assertions.assertEquals(boisson.toString(), expected);
    }
}