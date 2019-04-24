package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassEnergyTest {
    private IEnergy firstGrassEnergy, secondGrassEnergy, thirdGrassEnergy;
    @BeforeEach
    void setUp() {
        firstGrassEnergy = new GrassEnergy();
        secondGrassEnergy = new GrassEnergy();
        thirdGrassEnergy = new GrassEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Grass Energy", firstGrassEnergy.getCardName());
        assertEquals("Grass Energy", secondGrassEnergy.getCardName());
        assertEquals("Grass Energy", thirdGrassEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstGrassEnergy, new GrassEnergy());
        assertEquals(secondGrassEnergy, new GrassEnergy());
        assertEquals(thirdGrassEnergy, new GrassEnergy());
        assertEquals(firstGrassEnergy, secondGrassEnergy);
        assertEquals(thirdGrassEnergy, secondGrassEnergy);
        assertEquals(firstGrassEnergy, thirdGrassEnergy);

    }
    }