package dev.upssitech.mcburger.modele.aliment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccompagnementTest {

    public static final String expected = "Accompagnement [nom='Mc Frites']";

    @Test
    void testToString() {
        Accompagnement accompagnement = new Accompagnement("Mc Frites");
        Assertions.assertEquals(accompagnement.toString(), expected);
    }

}