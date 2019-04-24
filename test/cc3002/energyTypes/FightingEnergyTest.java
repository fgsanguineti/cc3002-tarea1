package cc3002.energyTypes;

import cc3002.IEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightingEnergyTest {
    private IEnergy  firstFightingEnergy, secondFightingEnergy, thirdFightingEnergy;
    @BeforeEach
    void setUp() {
        firstFightingEnergy = new FightingEnergy();
        secondFightingEnergy = new FightingEnergy();
        thirdFightingEnergy = new FightingEnergy();

    }

    @Test
    void getCardName() {
        assertEquals("Fighting Energy", firstFightingEnergy.getCardName());
        assertEquals("Fighting Energy", secondFightingEnergy.getCardName());
        assertEquals("Fighting Energy", thirdFightingEnergy.getCardName());
    }

    @Test
    void equalsTest() {
        assertEquals(firstFightingEnergy, new FightingEnergy());
        assertEquals(secondFightingEnergy, new FightingEnergy());
        assertEquals(thirdFightingEnergy, new FightingEnergy());
        assertEquals(firstFightingEnergy, secondFightingEnergy);
        assertEquals(thirdFightingEnergy, secondFightingEnergy);
        assertEquals(firstFightingEnergy, thirdFightingEnergy);


    }
}