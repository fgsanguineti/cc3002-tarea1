package cc3002;

import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.energytypes.EnergyContainer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class AbilityContainerTest {
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

    private AbilityContainer aFirst;
    private AbilityContainer aSecond;
    private AbilityContainer aThird;
    private AbilityContainer aFourth;
    private AbilityContainer aFifth;

    @Before
    public void setUp() {
        aFirst = new AbilityContainer(new NullAbility(), new NullAbility(), new NullAbility(), new NullAbility());
        aSecond = new AbilityContainer(firstAttack, new NullAbility(), new NullAbility(), new NullAbility());
        aThird = new AbilityContainer(secondAttack, firstAttack, new NullAbility(), new NullAbility());
        aFourth = new AbilityContainer(thirdAttack, firstAttack, secondAttack, new NullAbility());
        aFifth = new AbilityContainer(firstAttack, secondAttack, thirdAttack, fourthAttack);
    }

    @Test
    public void getAttack() {
        assertEquals(aFirst.getAbility(1), new NullAbility());
        assertEquals(aFirst.getAbility(2), new NullAbility());
        assertEquals(aFirst.getAbility(3), new NullAbility());
        assertEquals(aFirst.getAbility(4), new NullAbility());
        assertNotNull(aFirst);
        assertNotNull(aSecond);
        assertNotNull(aThird);
        assertNotNull(aFourth);
        assertNotNull(aFifth);
        assertEquals(aSecond.getAbility(1), firstAttack);
        assertEquals(aThird.getAbility(1), secondAttack);
        assertEquals(aThird.getAbility(2), firstAttack);
        assertEquals(aFourth.getAbility(1), thirdAttack);
        assertEquals(aFourth.getAbility(2), firstAttack);
        assertEquals(aFourth.getAbility(3), secondAttack);

        assertEquals(aFifth.getAbility(1), firstAttack);
        assertEquals(aFifth.getAbility(2), secondAttack);
        assertEquals(aFifth.getAbility(3), thirdAttack);
        assertEquals(aFifth.getAbility(4), fourthAttack);

        assertEquals(aSecond, new AbilityContainer(firstAttack, new NullAbility(), new NullAbility(), new NullAbility()));
        assertEquals(aThird, new AbilityContainer(secondAttack, firstAttack, new NullAbility(), new NullAbility()));
        assertEquals(aFourth, new AbilityContainer(thirdAttack, firstAttack, secondAttack, new NullAbility()));
        assertEquals(aFifth, new AbilityContainer(firstAttack, secondAttack, thirdAttack, fourthAttack));
    }
}