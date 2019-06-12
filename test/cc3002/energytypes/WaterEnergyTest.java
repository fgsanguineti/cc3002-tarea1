package cc3002.energytypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterEnergyTest {
    private WaterEnergy firstWaterEnergy, secondWaterEnergy, thirdWaterEnergy;

    @Before
    public void setUp() {
        firstWaterEnergy = new WaterEnergy();
        secondWaterEnergy = new WaterEnergy();
        thirdWaterEnergy = new WaterEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Water Energy", firstWaterEnergy.getCardName());
        assertEquals("Water Energy", secondWaterEnergy.getCardName());
        assertEquals("Water Energy", thirdWaterEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstWaterEnergy, new WaterEnergy());
        assertEquals(secondWaterEnergy, new WaterEnergy());
        assertEquals(thirdWaterEnergy, new WaterEnergy());
        assertEquals(firstWaterEnergy, secondWaterEnergy);
        assertEquals(thirdWaterEnergy, secondWaterEnergy);
        assertEquals(firstWaterEnergy, thirdWaterEnergy);

    }
}