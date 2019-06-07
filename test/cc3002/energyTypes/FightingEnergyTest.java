package cc3002.energyTypes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FightingEnergyTest {
    private IEnergy  firstFightingEnergy, secondFightingEnergy, thirdFightingEnergy;

    @Before
    public void setUp() {
        firstFightingEnergy = new FightingEnergy();
        secondFightingEnergy = new FightingEnergy();
        thirdFightingEnergy = new FightingEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals("Fighting Energy", firstFightingEnergy.getCardName());
        assertEquals("Fighting Energy", secondFightingEnergy.getCardName());
        assertEquals("Fighting Energy", thirdFightingEnergy.getCardName());
    }

    @Test
    public void equalsTest() {
        assertEquals(firstFightingEnergy, new FightingEnergy());
        assertEquals(secondFightingEnergy, new FightingEnergy());
        assertEquals(thirdFightingEnergy, new FightingEnergy());
        assertEquals(firstFightingEnergy, secondFightingEnergy);
        assertEquals(thirdFightingEnergy, secondFightingEnergy);
        assertEquals(firstFightingEnergy, thirdFightingEnergy);


    }
}