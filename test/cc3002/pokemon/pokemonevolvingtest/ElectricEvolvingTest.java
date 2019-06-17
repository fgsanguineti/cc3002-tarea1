package cc3002.pokemon.pokemonevolvingtest;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.abilities.effects.NullEffect;
import cc3002.energies.EnergyContainer;
import cc3002.pokemon.electric.BasicElectricPokemon;
import cc3002.pokemon.electric.PhaseOneElectricPokemon;
import cc3002.pokemon.electric.PhaseTwoElectricPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElectricEvolvingTest {
    private BasicElectricPokemon electricBasic, electricBasicTwo;
    private PhaseOneElectricPokemon electricPhaseOne, secondElectricPhaseOne;
    private PhaseTwoElectricPokemon electricPhaseTwo, secondElectricPhaseTwo;

    private EnergyContainer first, two;

    private Trainer trainer;

    private AbilityContainer firstContainer;

    private Attack firstAttack;

    @Before
    public void setUp() {
        first = new EnergyContainer(0, 1, 2, 1, 2, 1);
        two = new EnergyContainer(0, 1, 1, 0, 2, 1);

        firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first, new NullEffect());
        firstContainer = new AbilityContainer(firstAttack, new NullAbility(), new NullAbility(), new NullAbility());

        electricBasic = new BasicElectricPokemon("Pichu", 32, 40, firstContainer);
        electricPhaseOne = new PhaseOneElectricPokemon("Pikachu", 132, 60, firstContainer, 32);
        electricPhaseTwo = new PhaseTwoElectricPokemon("Raichu", 232, 90, firstContainer, 132);

        electricBasicTwo = new BasicElectricPokemon("Pichu2", 33, 40, firstContainer);
        secondElectricPhaseOne = new PhaseOneElectricPokemon("Pikachu2", 133, 60, firstContainer, 33);
        secondElectricPhaseTwo = new PhaseTwoElectricPokemon("Raichu2", 233, 90, firstContainer, 133);


        trainer = new Trainer("Franco");
    }

    @Test
    public void electricEvolve() {

        electricBasic.setEnergyContainer(first);
        electricPhaseOne.setEnergyContainer(first);
        electricPhaseTwo.setEnergyContainer(first);

        electricBasicTwo.setEnergyContainer(two);
        secondElectricPhaseOne.setEnergyContainer(two);
        secondElectricPhaseTwo.setEnergyContainer(two);


        trainer.addCardToHand(electricBasic);
        trainer.addCardToHand(electricBasicTwo);
        trainer.play(trainer.getHand().get(0));
        trainer.play(trainer.getHand().get(0));

        assertEquals(trainer.getActivePokemon(), electricBasic);
        assertEquals(trainer.getBench().get(0), electricBasicTwo);

        trainer.addCardToHand(electricPhaseOne);
        trainer.addCardToHand(electricPhaseTwo);
        trainer.addCardToHand(secondElectricPhaseOne);
        trainer.addCardToHand(secondElectricPhaseTwo);

        trainer.setSelectedPokemon(electricBasic);
        trainer.play(trainer.getHand().get(0));
        trainer.unSelectPokemon();
        assertEquals(trainer.getActivePokemon(), electricPhaseOne);
        assertEquals(trainer.getActivePokemon().getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(0), electricBasic);

        trainer.setSelectedPokemon(electricBasicTwo);
        trainer.play(secondElectricPhaseOne);
        trainer.unSelectPokemon();
        assertEquals(trainer.getBench().get(0), secondElectricPhaseOne);
        assertEquals(trainer.getBench().get(0).getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(1), electricBasicTwo);

        trainer.setSelectedPokemon(electricPhaseOne);
        trainer.play(electricPhaseTwo);
        trainer.unSelectPokemon();
        assertEquals(trainer.getActivePokemon(), electricPhaseTwo);
        assertEquals(trainer.getActivePokemon().getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(2), electricPhaseOne);

        trainer.setSelectedPokemon(secondElectricPhaseOne);
        trainer.play(secondElectricPhaseTwo);
        trainer.unSelectPokemon();
        assertEquals(trainer.getBench().get(0), secondElectricPhaseTwo);
        assertEquals(trainer.getBench().get(0).getAllEnergyQuantity(), first);
        assertEquals(trainer.getDiscardHeap().get(3), secondElectricPhaseOne);
    }
}

