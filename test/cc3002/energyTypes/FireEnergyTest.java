package cc3002.energyTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireEnergyTest {
    private IEnergy firstFireEnergy, secondFireEnergy, thirdFireEnergy;

    @Before
    public void setUp() {
        firstFireEnergy = new FireEnergy();
        secondFireEnergy = new FireEnergy();
        thirdFireEnergy = new FireEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Fire Energy", firstFireEnergy.getCardName());
        assertEquals("Fire Energy", secondFireEnergy.getCardName());
        assertEquals("Fire Energy", thirdFireEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstFireEnergy, new FireEnergy());
        assertEquals(secondFireEnergy, new FireEnergy());
        assertEquals(thirdFireEnergy, new FireEnergy());
        assertEquals(firstFireEnergy, secondFireEnergy);
        assertEquals(thirdFireEnergy, secondFireEnergy);
        assertEquals(firstFireEnergy, thirdFireEnergy);

    }
    }