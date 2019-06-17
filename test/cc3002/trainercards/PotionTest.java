package cc3002.trainercards;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.NullAbility;
import cc3002.pokemon.IPokemon;
import cc3002.pokemon.psychic.BasicPsychicPokemon;
import cc3002.pokemon.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    private Potion firstPotion, secondPotion;
    private IPokemon firstPokemon, secondPokemon;
    private Trainer t1;

    @Before
    public void setUp() {
        firstPokemon = new BasicWaterPokemon("waterPokemon", 54, 87, new AbilityContainer(new NullAbility(), new NullAbility(),
                new NullAbility(), new NullAbility()));
        secondPokemon = new BasicPsychicPokemon("psychicPokemon", 76, 140, new AbilityContainer(new NullAbility(), new NullAbility(),
                new NullAbility(), new NullAbility()));
        t1 = new Trainer("Trainer");
        firstPotion = new Potion(3);
        secondPotion = new Potion(5);
        t1.addCardToHand(firstPokemon);
        t1.addCardToHand(secondPokemon);
        t1.addCardToHand(firstPotion);
        t1.addCardToHand(secondPotion);
    }

    @Test
    public void checkProperlyHPQuantity() {
        t1.play(firstPokemon);
        firstPokemon.modifyHP(-50);
        t1.setSelectedPokemon(firstPokemon);
        t1.play(firstPotion);
        assertEquals(67, t1.getSelectedPokemon().getHP());
        assertEquals(firstPotion, t1.getDiscardHeap().get(0));
        t1.play(secondPotion);
        assertEquals(87, t1.getSelectedPokemon().getHP());
        assertEquals("Recovers up to X damage counters of the selected Pokemon", firstPotion.getDescription());
    }

}