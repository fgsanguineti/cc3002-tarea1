package cc3002;

import cc3002.abilities.Attack;
import cc3002.abilities.AttackContainer;
import cc3002.energytypes.EnergyContainer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AttackContainerTest {
    private EnergyContainer first = new EnergyContainer(0, 1, 5, 0, 0, 0);
    private EnergyContainer second = new EnergyContainer(4, 0, 2, 0, 0, 0);
    private EnergyContainer third = new EnergyContainer(0, 1, 2, 1, 2, 1);
    private EnergyContainer fourth = new EnergyContainer(0, 1, 1, 0, 2, 1);

    private Attack firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
            40, first);
    private Attack secondAttack = new Attack("Placaje", "Le pega un buen colpe al oponente con su cuerpo",
            30, second);
    private Attack thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente",
            50, third);
    private Attack fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate",
            20, fourth);

    private AttackContainer aFirst;
    private AttackContainer aSecond;
    private AttackContainer aThird;
    private AttackContainer aFourth;
    private AttackContainer aFifth;

    @Before
    public void setUp() {
        aFirst = new AttackContainer(null, null, null, null);
        aSecond = new AttackContainer(firstAttack, null, null, null);
        aThird = new AttackContainer(secondAttack, firstAttack, null, null);
        aFourth = new AttackContainer(thirdAttack, firstAttack, secondAttack, null);
        aFifth = new AttackContainer(firstAttack, secondAttack, thirdAttack, fourthAttack);
    }

    @Test
    public void getAttack() {
        assertNull(aFirst.getAttack(1));
        assertNull(aFirst.getAttack(2));
        assertNull(aFirst.getAttack(3));
        assertNull(aFirst.getAttack(4));
        assertNotNull(aFirst);
        assertNotNull(aSecond);
        assertNotNull(aThird);
        assertNotNull(aFourth);
        assertNotNull(aFifth);
        assertEquals(aSecond.getAttack(1), firstAttack);
        assertEquals(aThird.getAttack(1), secondAttack);
        assertEquals(aThird.getAttack(2), firstAttack);
        assertEquals(aFourth.getAttack(1), thirdAttack);
        assertEquals(aFourth.getAttack(2), firstAttack);
        assertEquals(aFourth.getAttack(3), secondAttack);

        assertEquals(aFifth.getAttack(1), firstAttack);
        assertEquals(aFifth.getAttack(2), secondAttack);
        assertEquals(aFifth.getAttack(3), thirdAttack);
        assertEquals(aFifth.getAttack(4), fourthAttack);

        assertEquals(aSecond, new AttackContainer(firstAttack, null, null, null));
        assertEquals(aThird, new AttackContainer(secondAttack, firstAttack, null, null));
        assertEquals(aFourth, new AttackContainer(thirdAttack, firstAttack, secondAttack, null));
        assertEquals(aFifth, new AttackContainer(firstAttack, secondAttack, thirdAttack, fourthAttack));
    }
}