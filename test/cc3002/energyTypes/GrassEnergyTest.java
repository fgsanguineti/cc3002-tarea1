package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrassEnergyTest {
    private IEnergy firstGrassEnergy, secondGrassEnergy, thirdGrassEnergy;

    @Before
    public void setUp() {
        firstGrassEnergy = new GrassEnergy();
        secondGrassEnergy = new GrassEnergy();
        thirdGrassEnergy = new GrassEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Grass Energy", firstGrassEnergy.getCardName());
        assertEquals("Grass Energy", secondGrassEnergy.getCardName());
        assertEquals("Grass Energy", thirdGrassEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstGrassEnergy, new GrassEnergy());
        assertEquals(secondGrassEnergy, new GrassEnergy());
        assertEquals(thirdGrassEnergy, new GrassEnergy());
        assertEquals(firstGrassEnergy, secondGrassEnergy);
        assertEquals(thirdGrassEnergy, secondGrassEnergy);
        assertEquals(firstGrassEnergy, thirdGrassEnergy);

    }
    }