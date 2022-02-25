package dev.upssitech.mcburger.modele.profil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteBancaireTest {

    public static final int NUM_CARTE = 123456789;
    public static final int DATE_CARTE = 1234;

    public static final String expected = "CarteBancaire [numeroCarte="+NUM_CARTE+", dateCarte="+DATE_CARTE+"]";

    @Test
    void testToString() {
        CarteBancaire cb = new CarteBancaire(NUM_CARTE, DATE_CARTE);
        Assertions.assertEquals(cb.toString(), expected);
    }
}