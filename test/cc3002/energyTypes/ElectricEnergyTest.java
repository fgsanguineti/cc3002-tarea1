package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricEnergyTest {
    private IEnergy  firstElecricEnergy, secondElecricEnergy, thirdElecricEnergy;
    @BeforeEach
    void setUp() {
        firstElecricEnergy = new ElectricEnergy();
        secondElecricEnergy = new ElectricEnergy();
        thirdElecricEnergy = new ElectricEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Electric Energy", firstElecricEnergy.getCardName());
        assertEquals("Electric Energy", secondElecricEnergy.getCardName());
        assertEquals("Electric Energy", thirdElecricEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstElecricEnergy, new ElectricEnergy());
        assertEquals(secondElecricEnergy, new ElectricEnergy());
        assertEquals(thirdElecricEnergy, new ElectricEnergy());
        assertEquals(firstElecricEnergy, secondElecricEnergy);
        assertEquals(thirdElecricEnergy, secondElecricEnergy);
        assertEquals(firstElecricEnergy, thirdElecricEnergy);


    }
}