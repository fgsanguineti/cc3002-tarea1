package cc3002.energyTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricEnergyTest {
    private IEnergy  firstElecricEnergy, secondElecricEnergy, thirdElecricEnergy;

    @Before
    public void setUp() {
        firstElecricEnergy = new ElectricEnergy();
        secondElecricEnergy = new ElectricEnergy();
        thirdElecricEnergy = new ElectricEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Electric Energy", firstElecricEnergy.getCardName());
        assertEquals("Electric Energy", secondElecricEnergy.getCardName());
        assertEquals("Electric Energy", thirdElecricEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstElecricEnergy, new ElectricEnergy());
        assertEquals(secondElecricEnergy, new ElectricEnergy());
        assertEquals(thirdElecricEnergy, new ElectricEnergy());
        assertEquals(firstElecricEnergy, secondElecricEnergy);
        assertEquals(thirdElecricEnergy, secondElecricEnergy);
        assertEquals(firstElecricEnergy, thirdElecricEnergy);
    }
}