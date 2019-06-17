package cc3002.pokemontypes;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.abilities.effects.NullEffect;
import cc3002.energies.*;
import cc3002.pokemontypes.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicWaterPokemonTest {
    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;
    private BasicWaterPokemon squirtle, gyarados;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    private AbilityContainer firstContainer, secondContainer, thirdContainer, fourthContainer;

    @Before
    public void setUp() {

        EnergyContainer first = new EnergyContainer(0, 1, 5, 0, 0, 0);
        EnergyContainer second = new EnergyContainer(4, 0, 2, 0, 0, 0);
        EnergyContainer third = new EnergyContainer(0, 1, 2, 1, 2, 1);
        EnergyContainer fourth = new EnergyContainer(0, 1, 1, 0, 2, 1);

        firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first, new NullEffect());
        secondAttack = new Attack("Placaje", "Le pega un buen colpe al oponente con su cuerpo",
                30, second, new NullEffect());
        thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente", 50, third, new NullEffect());
        fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate", 20, fourth, new NullEffect());

        firstContainer = new AbilityContainer(firstAttack, secondAttack, new NullAbility(), new NullAbility());
        secondContainer = new AbilityContainer(thirdAttack, new NullAbility(), new NullAbility(), new NullAbility());
        thirdContainer = new AbilityContainer(firstAttack, secondAttack, thirdAttack, new NullAbility());
        fourthContainer = new AbilityContainer(fourthAttack, thirdAttack, secondAttack, firstAttack);

        squirtle = new BasicWaterPokemon("Squirtle", 33, 60, secondContainer);
        gyarados = new BasicWaterPokemon("Gyarados", 85, 100, firstContainer);
        electric1 = new ElectricEnergy();
        electric2 = new ElectricEnergy();
        electric3 = new ElectricEnergy();

        fighting1 = new FightingEnergy();
        fighting2 = new FightingEnergy();
        fighting3 = new FightingEnergy();

        fire1 = new FireEnergy();
        fire2 = new FireEnergy();
        fire3 = new FireEnergy();

        grass1 = new GrassEnergy();
        grass2 = new GrassEnergy();
        grass3 = new GrassEnergy();

        psychic1 = new PsychicEnergy();
        psychic2 = new PsychicEnergy();
        psychic3 = new PsychicEnergy();

        water1 = new WaterEnergy();
        water2 = new WaterEnergy();
        water3 = new WaterEnergy();

    }

    @Test
    public void getCardName() {
        assertEquals(squirtle.getCardName(), "Squirtle");
        assertEquals(gyarados.getCardName(), "Gyarados");
    }

    @Test
    public void getID() {
        assertEquals(squirtle.getID(), 33);
        assertEquals(gyarados.getID(), 85);
    }

    @Test
    public void getHP() {
        assertEquals(squirtle.getHP(), 60);
        assertEquals(gyarados.getHP(), 100);
    }
    @Test
    public void receiveElectricEnergy() {
        squirtle.receiveElectricEnergy(electric1);
        squirtle.receiveElectricEnergy(electric2);
        gyarados.receiveElectricEnergy(electric3);
        assertEquals(squirtle.getElectricEnergyQuantity(), 2);
        assertEquals(gyarados.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        gyarados.receiveFightingEnergy(fighting1);
        gyarados.receiveFightingEnergy(fighting2);
        squirtle.receiveFightingEnergy(fighting3);
        assertEquals(squirtle.getFightingEnergyQuantity(),1);
        assertEquals(gyarados.getFightingEnergyQuantity(),2);
    }

    @Test
    public void receiveFireEnergy() {
        gyarados.receiveFireEnergy(fire1);
        gyarados.receiveFireEnergy(fire2);
        gyarados.receiveFireEnergy(fire3);
        assertEquals(gyarados.getFireEnergyQuantity(), 3);
        assertEquals(squirtle.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        squirtle.receiveGrassEnergy(grass1);
        squirtle.receiveGrassEnergy(grass2);
        squirtle.receiveGrassEnergy(grass3);
        assertEquals(squirtle.getGrassEnergyQuantity(), 3);
        assertEquals(gyarados.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        squirtle.receivePsychicEnergy(psychic1);
        squirtle.receivePsychicEnergy(psychic2);
        gyarados.receivePsychicEnergy(psychic3);
        assertEquals(squirtle.getPsychicEnergyQuantity(), 2);
        assertEquals(gyarados.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        gyarados.receiveWaterEnergy(water1);
        gyarados.receiveWaterEnergy(water2);
        squirtle.receiveWaterEnergy(water3);
        assertEquals(squirtle.getWaterEnergyQuantity(),1);
        assertEquals(gyarados.getWaterEnergyQuantity(),2);
    }

    @Test
    public void receiveElectricPokemonAttack() {
        gyarados.receiveElectricPokemonAttack(secondAttack);
        assertEquals(gyarados.getHP(), 40);
    }

    @Test
    public void receiveGrassPokemonAttack() {
        gyarados.receiveGrassPokemonAttack(fourthAttack);
        assertEquals(gyarados.getHP(), 60);
    }

    @Test
    public void receiveFightingPokemonAttack() {
        gyarados.receiveFightingPokemonAttack(thirdAttack);
        assertEquals(gyarados.getHP(), 80);
    }

    @Test
    public void attack() {

        Trainer t1 = new Trainer("Trainer 1");
        Trainer t2 = new Trainer("Trainer 2");

        t1.setOpponent(t2);
        t2.setOpponent(t1);

        t1.addCardToHand(squirtle);
        t1.play(t1.getHand().get(0));

        t1.setSelectedPokemon(squirtle);
        t1.addCardToHand(electric1);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(electric2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fighting1);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fighting2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fire1);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fire2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(water1);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(water2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(psychic1);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(psychic2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(grass1);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(grass2);
        t1.setSelectedPokemon(squirtle);
        t1.play(t1.getHand().get(0));
        t1.unSelectPokemon();

        t2.addCardToHand(gyarados);
        t2.play(gyarados);
        t1.makeAnAbility(1);

        assertEquals(gyarados.getHP(), 50);
    }

    @Test
    public void equals() {
        assertEquals(gyarados, new BasicWaterPokemon("Gyarados", 85, 100, firstContainer));
    }
}