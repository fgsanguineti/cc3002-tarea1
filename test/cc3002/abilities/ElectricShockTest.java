package cc3002.abilities;

import cc3002.Trainer;
import cc3002.abilities.effects.concrete.ElectricShockEffect;
import cc3002.energies.EnergyContainer;
import cc3002.pokemontypes.IPokemon;
import cc3002.pokemontypes.fire.BasicFirePokemon;
import cc3002.pokemontypes.grass.BasicGrassPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricShockTest {
    private IPokemon firePokemon, grassPokemon;
    private Trainer t1, t2;
    private EnergyContainer enoughEnergyContainer, notEnoughEnergyContainer;
    private ElectricShock firstElectricShock;

    @Before
    public void setUp() {
        firePokemon = new BasicFirePokemon("firePokemon", 102, 120,
                new AbilityContainer(new EnergyBurn(), firstElectricShock = new ElectricShock(50), new NullAbility(), new NullAbility()));
        grassPokemon = new BasicGrassPokemon("grass", 23, 234,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));

        t1 = new Trainer("Trainer 1");
        t2 = new Trainer("Trainer 2");
        t1.setOpponent(t2);
        t2.setOpponent(t1);
        enoughEnergyContainer = new EnergyContainer(5, 5, 5, 5, 5, 5);
        notEnoughEnergyContainer = new EnergyContainer(0, 1, 2, 5, 5, 5);
        t1.addCardToHand(firePokemon);
        t2.addCardToHand(grassPokemon);

    }

    @Test
    public void testElectricShock() {
        t2.play(grassPokemon);
        t1.play(firePokemon);
        int checkedHP;
        firePokemon.setEnergyContainer(enoughEnergyContainer);
        t1.makeAnAbility(2);
        if (((ElectricShockEffect) firstElectricShock.getEffect()).getLastCoinFlippingResult().equals("Tails")) {
            assertEquals(checkedHP = 70, firePokemon.getHP());
            assertEquals(34, grassPokemon.getHP());
        } else {
            assertEquals(checkedHP = 120, firePokemon.getHP());
            assertEquals(34, grassPokemon.getHP());
        }
        firePokemon.setEnergyContainer(notEnoughEnergyContainer);
        t1.makeAnAbility(2);
        assertEquals(checkedHP, firePokemon.getHP());
        assertEquals(34, grassPokemon.getHP());
    }
}