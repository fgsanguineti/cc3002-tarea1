package cc3002.pokemontypes.pokemonevolvingtest;

import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.Trainer;
import cc3002.energyTypes.EnergyContainer;
import cc3002.pokemontypes.fire.BasicFirePokemon;
import cc3002.pokemontypes.fire.PhaseOneFirePokemon;
import cc3002.pokemontypes.fire.PhaseTwoFirePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FireEvolvingTest {
    private BasicFirePokemon basic, basicTwo;
    private PhaseOneFirePokemon phaseOne, secondPhaseOne;
    private PhaseTwoFirePokemon phaseTwo, secondPhaseTwo;

    private EnergyContainer first, two;

    private Trainer trainer;

    private AttackContainer firstContainer;

    private Attack firstAttack;

    @Before
    public void setUp() {
        first = new EnergyContainer(0, 1, 2, 1, 2, 1);
        two = new EnergyContainer(0, 1, 1, 0, 2, 1);

        firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first);
        firstContainer = new AttackContainer(firstAttack, null, null, null);

        basic = new BasicFirePokemon("Pichu", 32, 40, firstContainer);
        phaseOne = new PhaseOneFirePokemon("Pikachu", 132, 60, firstContainer, 32);
        phaseTwo = new PhaseTwoFirePokemon("Raichu", 232, 90, firstContainer, 132);

        basicTwo = new BasicFirePokemon("Pichu2", 33, 40, firstContainer);
        secondPhaseOne = new PhaseOneFirePokemon("Pikachu2", 133, 60, firstContainer, 33);
        secondPhaseTwo = new PhaseTwoFirePokemon("Raichu2", 233, 90, firstContainer, 133);


        trainer = new Trainer("Franco");
    }

    @Test
    public void electricEvolve() {

        basic.setEnergyContainer(first);
        phaseOne.setEnergyContainer(first);
        phaseTwo.setEnergyContainer(first);

        basicTwo.setEnergyContainer(two);
        secondPhaseOne.setEnergyContainer(two);
        secondPhaseTwo.setEnergyContainer(two);


        trainer.addCardToHand(basic);
        trainer.addCardToHand(basicTwo);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));

        assertEquals(trainer.getActivePokemon(), basic);
        assertEquals(trainer.getBench().get(0), basicTwo);

        trainer.addCardToHand(phaseOne);
        trainer.addCardToHand(phaseTwo);
        trainer.addCardToHand(secondPhaseOne);
        trainer.addCardToHand(secondPhaseTwo);

        trainer.setSelectedPokemon(basic);
        trainer.play(trainer.getHand().get(0));
        trainer.unselectPokemon();
        assertEquals(trainer.getActivePokemon(), phaseOne);
        assertEquals(trainer.getActivePokemon().getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(0), basic);

        trainer.setSelectedPokemon(basicTwo);
        trainer.play(secondPhaseOne);
        trainer.unselectPokemon();
        assertEquals(trainer.getBench().get(0), secondPhaseOne);
        assertEquals(trainer.getBench().get(0).getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(1), basicTwo);

        trainer.setSelectedPokemon(phaseOne);
        trainer.play(phaseTwo);
        trainer.unselectPokemon();
        assertEquals(trainer.getActivePokemon(), phaseTwo);
        assertEquals(trainer.getActivePokemon().getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(2), phaseOne);

        trainer.setSelectedPokemon(secondPhaseOne);
        trainer.play(secondPhaseTwo);
        trainer.unselectPokemon();
        assertEquals(trainer.getBench().get(0), secondPhaseTwo);
        assertEquals(trainer.getBench().get(0).getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(3), secondPhaseOne);
    }
}

