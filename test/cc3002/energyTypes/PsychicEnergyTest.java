package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PsychicEnergyTest {
    private IEnergy firstPsychicEnergy, secondPsychicEnergy, thirdPsychicEnergy;
    @BeforeEach
    void setUp() {
        firstPsychicEnergy = new PsychicEnergy();
        secondPsychicEnergy = new PsychicEnergy();
        thirdPsychicEnergy = new PsychicEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Psychic Energy", firstPsychicEnergy.getCardName());
        assertEquals("Psychic Energy", secondPsychicEnergy.getCardName());
        assertEquals("Psychic Energy", thirdPsychicEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstPsychicEnergy, new PsychicEnergy());
        assertEquals(secondPsychicEnergy, new PsychicEnergy());
        assertEquals(thirdPsychicEnergy, new PsychicEnergy());
        assertEquals(firstPsychicEnergy, secondPsychicEnergy);
        assertEquals(thirdPsychicEnergy, secondPsychicEnergy);
        assertEquals(firstPsychicEnergy, thirdPsychicEnergy);

    }
}