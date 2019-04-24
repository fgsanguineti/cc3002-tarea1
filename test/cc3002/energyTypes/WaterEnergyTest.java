package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterEnergyTest {
    private IEnergy firstWaterEnergy, secondWaterEnergy, thirdWaterEnergy;
    @BeforeEach
    void setUp() {
        firstWaterEnergy = new WaterEnergy();
        secondWaterEnergy = new WaterEnergy();
        thirdWaterEnergy = new WaterEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Water Energy", firstWaterEnergy.getCardName());
        assertEquals("Water Energy", secondWaterEnergy.getCardName());
        assertEquals("Water Energy", thirdWaterEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstWaterEnergy, new WaterEnergy());
        assertEquals(secondWaterEnergy, new WaterEnergy());
        assertEquals(thirdWaterEnergy, new WaterEnergy());
        assertEquals(firstWaterEnergy, secondWaterEnergy);
        assertEquals(thirdWaterEnergy, secondWaterEnergy);
        assertEquals(firstWaterEnergy, thirdWaterEnergy);

    }
}