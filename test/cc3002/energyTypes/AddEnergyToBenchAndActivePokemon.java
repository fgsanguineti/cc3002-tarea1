package cc3002.energyTypes;

import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.Trainer;
import cc3002.pokemontypes.IBasicPokemon;
import cc3002.pokemontypes.fire.BasicFirePokemon;
import cc3002.pokemontypes.psychic.BasicPsychicPokemon;
import cc3002.pokemontypes.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddEnergyToBenchAndActivePokemon {
    private AbstractEnergy electric, fighting, fire, grass, psychic, water;
    private IBasicPokemon one, two, three;
    private EnergyContainer first = new EnergyContainer(0, 1, 2, 1, 2, 1);
    private Attack firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
            40, first);
    private AttackContainer firstContainer = new AttackContainer(firstAttack, null, null, null);

    private Trainer franco;

    @Before
    public void setUp() {
        electric = new ElectricEnergy();
        fighting = new FightingEnergy();
        fire = new FireEnergy();
        grass = new GrassEnergy();
        psychic = new PsychicEnergy();
        water = new WaterEnergy();
        one = new BasicFirePokemon("one", 15, 43, firstContainer);
        two = new BasicWaterPokemon("two", 54, 45, firstContainer);
        three = new BasicPsychicPokemon("three", 67, 56, firstContainer);
        franco = new Trainer("Franco");
    }

    @Test
    public void addEnergyTest() {

        franco.addCardToHand(electric);
        franco.addCardToHand(fighting);
        franco.addCardToHand(fire);
        franco.addCardToHand(grass);
        franco.addCardToHand(psychic);
        franco.addCardToHand(water);

        franco.addCardToHand(one);
        franco.addCardToHand(two);
        franco.addCardToHand(three);

        franco.play(one);
        franco.play(two);
        franco.play(three);

        franco.setSelectedPokemon(franco.getActivePokemon());
        franco.play(electric);
        franco.play(fighting);
        franco.unselectPokemon();
        assertEquals(franco.getActivePokemon().getAllEnergyQuantity(), new EnergyContainer(1, 1, 0, 0, 0, 0));
        franco.setSelectedPokemon(franco.getBench().get(0));
        franco.play(fire);
        franco.play(grass);
        franco.unselectPokemon();
        assertEquals(franco.getBench().get(0).getAllEnergyQuantity(), new EnergyContainer(0, 0, 1, 1, 0, 0));
        franco.setSelectedPokemon(franco.getBench().get(1));
        franco.play(psychic);
        franco.play(water);
        franco.unselectPokemon();
        assertEquals(franco.getBench().get(1).getAllEnergyQuantity(), new EnergyContainer(0, 0, 0, 0, 1, 1));

    }
}
