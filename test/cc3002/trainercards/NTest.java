package cc3002.trainercards;

import cc3002.ICard;
import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.NullAbility;
import cc3002.energytypes.ElectricEnergy;
import cc3002.energytypes.WaterEnergy;
import cc3002.pokemontypes.electric.BasicElectricPokemon;
import cc3002.pokemontypes.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class NTest {
    private Trainer t1, t2;
    private ArrayList<ICard> firstEnergies, secondEnergies;
    private ArrayList<ICard> firstPokemon, secondPokemon;
    private N n1, n2;

    @Before
    public void setUp() {
        t1 = new Trainer("Trainer 1");
        t2 = new Trainer("Trainer 2");
        t1.setOpponent(t2);
        t2.setOpponent(t1);
        firstEnergies = new ArrayList<>();
        secondEnergies = new ArrayList<>();
        firstPokemon = new ArrayList<>();
        secondPokemon = new ArrayList<>();
        n1 = new N();
        n2 = new N();

        for (int i = 0; i < 20; i++) {
            firstPokemon.add(new BasicElectricPokemon("", 34, 12,
                    new AbilityContainer(new NullAbility(), new NullAbility(), new NullAbility(), new NullAbility())));
        }
        for (int i = 0; i < 15; i++) {
            secondPokemon.add(new BasicWaterPokemon("", 34, 12,
                    new AbilityContainer(new NullAbility(), new NullAbility(), new NullAbility(), new NullAbility())));
        }
        for (int i = 0; i < 30; i++) {
            firstEnergies.add(new ElectricEnergy());
        }
        for (int i = 0; i < 40; i++) {
            secondEnergies.add(new WaterEnergy());
        }
        t1.getDeck().addAll(firstPokemon);
        t1.getDeck().addAll(firstEnergies);
        Collections.shuffle(t1.getDeck());

        t2.getDeck().addAll(secondPokemon);
        t2.getDeck().addAll(secondEnergies);
        Collections.shuffle(t2.getDeck());

        for (int i = 0; i < 6; i++) {
            t1.drawACard();
            t2.drawACard();
        }
        for (int i = 0; i < 4; i++) {
            t1.addCardToPrizeCards();
        }
        for (int i = 0; i < 5; i++) {
            t2.addCardToPrizeCards();
        }

    }

    @Test
    public void checkN() {
        t1.addCardToHand(n1);
        assertEquals(40, t1.getDeck().size());
        assertEquals(44, t2.getDeck().size());

        assertEquals(7, t1.getHand().size());
        assertEquals(6, t2.getHand().size());

        assertEquals(4, t1.getPrizeCards().size());
        assertEquals(5, t2.getPrizeCards().size());

        t1.play(n1);
        assertEquals(42, t1.getDeck().size());
        assertEquals(45, t2.getDeck().size());

        assertEquals(4, t1.getHand().size());
        assertEquals(5, t2.getHand().size());

        t2.addCardToHand(n2);
        assertEquals(6, t2.getHand().size());
        t1.addCardToPrizeCards();


        t2.play(n2);
        assertEquals(40, t1.getDeck().size());
        assertEquals(45, t2.getDeck().size());

        assertEquals(5, t1.getHand().size());
        assertEquals(5, t2.getHand().size());

    }
}