package cc3002.abilities;

import cc3002.Trainer;
import cc3002.energies.EnergyContainer;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.electric.BasicElectricPokemon;
import cc3002.pokemon.fighting.BasicFightingPokemon;
import cc3002.pokemon.fire.BasicFirePokemon;
import cc3002.pokemon.grass.BasicGrassPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnergyBurnTest {
    private IPokemon charizard, electricPokemon, fightingPokemon, grassPokemon, psychicPokemon, waterPokemon;
    private Trainer t1;

    @Before
    public void setUp() {
        charizard = new BasicFirePokemon("Charizard", 102, 120,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        electricPokemon = new BasicElectricPokemon("electric", 123, 4324,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        fightingPokemon = new BasicFightingPokemon("fighting", 13, 213,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        grassPokemon = new BasicGrassPokemon("grass", 23, 234,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        psychicPokemon = new BasicPsychicPokemon("psychic", 45, 65,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        waterPokemon = new BasicWaterPokemon("water", 234, 23,
                new AbilityContainer(new EnergyBurn(), new NullAbility(), new NullAbility(), new NullAbility()));
        t1 = new Trainer("Trainer");
    }

    @Test
    public void checkFirePokemon() {
        charizard.setEnergyContainer(new EnergyContainer(5, 4, 3, 2, 1, 6));
        t1.addCardToHand(charizard);
        t1.play(charizard);
        t1.makeAnAbility(1);
        assertEquals(21, charizard.getAllEnergyQuantity().getTotalEnergyQuantity());
    }

    @Test
    public void checkElectricPokemon() {
        electricPokemon.setEnergyContainer(new EnergyContainer(2, 1, 2, 6, 5, 4));
        t1.addCardToHand(electricPokemon);
        t1.play(electricPokemon);
        t1.makeAnAbility(1);
        assertEquals(20, electricPokemon.getAllEnergyQuantity().getTotalEnergyQuantity());
    }

    @Test
    public void checkFightingPokemon() {
        fightingPokemon.setEnergyContainer(new EnergyContainer(0, 8, 2, 9, 4, 0));
        t1.addCardToHand(fightingPokemon);
        t1.play(fightingPokemon);
        t1.makeAnAbility(1);
        assertEquals(23, fightingPokemon.getAllEnergyQuantity().getTotalEnergyQuantity());
    }

    @Test
    public void checkGrassPokemon() {
        grassPokemon.setEnergyContainer(new EnergyContainer(5, 2, 7, 0, 1, 2));
        t1.addCardToHand(grassPokemon);
        t1.play(grassPokemon);
        t1.makeAnAbility(1);
        assertEquals(17, grassPokemon.getAllEnergyQuantity().getTotalEnergyQuantity());
    }

    @Test
    public void checkWaterPokemon() {
        waterPokemon.setEnergyContainer(new EnergyContainer(0, 1, 2, 1, 2, 1));
        t1.addCardToHand(waterPokemon);
        t1.play(waterPokemon);
        t1.makeAnAbility(1);
        assertEquals(7, waterPokemon.getAllEnergyQuantity().getTotalEnergyQuantity());
    }

    @Test
    public void checkPsychicPokemon() {
        psychicPokemon.setEnergyContainer(new EnergyContainer(0, 0, 2, 3, 1, 2));
        t1.addCardToHand(psychicPokemon);
        t1.play(psychicPokemon);
        t1.makeAnAbility(1);
        assertEquals(8, psychicPokemon.getAllEnergyQuantity().getTotalEnergyQuantity());
    }
}