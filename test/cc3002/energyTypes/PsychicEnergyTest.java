package cc3002.energyTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PsychicEnergyTest {
    private IEnergy firstPsychicEnergy, secondPsychicEnergy, thirdPsychicEnergy;

    @Before
    public void setUp() {
        firstPsychicEnergy = new PsychicEnergy();
        secondPsychicEnergy = new PsychicEnergy();
        thirdPsychicEnergy = new PsychicEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Psychic Energy", firstPsychicEnergy.getCardName());
        assertEquals("Psychic Energy", secondPsychicEnergy.getCardName());
        assertEquals("Psychic Energy", thirdPsychicEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstPsychicEnergy, new PsychicEnergy());
        assertEquals(secondPsychicEnergy, new PsychicEnergy());
        assertEquals(thirdPsychicEnergy, new PsychicEnergy());
        assertEquals(firstPsychicEnergy, secondPsychicEnergy);
        assertEquals(thirdPsychicEnergy, secondPsychicEnergy);
        assertEquals(firstPsychicEnergy, thirdPsychicEnergy);

    }
}