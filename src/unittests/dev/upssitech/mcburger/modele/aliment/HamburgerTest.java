package dev.upssitech.mcburger.modele.aliment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburgerTest {

    public static final String expected = "Hamburger [nom='{{}}']";
    public static final String name = "Mc Burger";
    public static Hamburger hamburger;


    @BeforeAll
    static void setup() {
        Assumptions.assumeTrue(expected != null);
        hamburger = new Hamburger(name);
    }


    @Test
    void testGetNom() {
        Assertions.assertEquals(hamburger.getNom(), name);
    }

    @Test
    void testToString() {
        Assertions.assertEquals(hamburger.toString(), expected.replace("{{}}", name));
    }

}