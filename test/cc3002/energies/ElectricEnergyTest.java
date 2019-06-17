package cc3002.energies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricEnergyTest {
    private ElectricEnergy firstElectricEnergy, secondElectricEnergy, thirdElectricEnergy;

    @Before
    public void setUp() {
        firstElectricEnergy = new ElectricEnergy();
        secondElectricEnergy = new ElectricEnergy();
        thirdElectricEnergy = new ElectricEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Electric Energy", firstElectricEnergy.getCardName());
        assertEquals("Electric Energy", secondElectricEnergy.getCardName());
        assertEquals("Electric Energy", thirdElectricEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstElectricEnergy, new ElectricEnergy());
        assertEquals(secondElectricEnergy, new ElectricEnergy());
        assertEquals(thirdElectricEnergy, new ElectricEnergy());
        assertEquals(firstElectricEnergy, secondElectricEnergy);
        assertEquals(thirdElectricEnergy, secondElectricEnergy);
        assertEquals(firstElectricEnergy, thirdElectricEnergy);
    }
}