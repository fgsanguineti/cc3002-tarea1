package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireEnergyTest {
    private IEnergy firstFireEnergy, secondFireEnergy, thirdFireEnergy;
    @BeforeEach
    void setUp() {
        firstFireEnergy = new FireEnergy();
        secondFireEnergy = new FireEnergy();
        thirdFireEnergy = new FireEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Fire Energy", firstFireEnergy.getCardName());
        assertEquals("Fire Energy", secondFireEnergy.getCardName());
        assertEquals("Fire Energy", thirdFireEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstFireEnergy, new FireEnergy());
        assertEquals(secondFireEnergy, new FireEnergy());
        assertEquals(thirdFireEnergy, new FireEnergy());
        assertEquals(firstFireEnergy, secondFireEnergy);
        assertEquals(thirdFireEnergy, secondFireEnergy);
        assertEquals(firstFireEnergy, thirdFireEnergy);

    }
    }