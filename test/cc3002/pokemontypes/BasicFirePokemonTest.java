package cc3002.pokemontypes;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.abilities.effects.NullEffect;
import cc3002.energytypes.*;
import cc3002.pokemontypes.fire.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicFirePokemonTest {

    private BasicFirePokemon tepig, flareon;
    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;
    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3, fire4, fire5;
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
        tepig = new BasicFirePokemon("Tepig", 3, 70, thirdContainer);
        flareon = new BasicFirePokemon("Flareon", 88, 90, secondContainer);

        electric1 = new ElectricEnergy();
        electric2 = new ElectricEnergy();
        electric3 = new ElectricEnergy();

        fighting1 = new FightingEnergy();
        fighting2 = new FightingEnergy();
        fighting3 = new FightingEnergy();

        fire1 = new FireEnergy();
        fire2 = new FireEnergy();
        fire3 = new FireEnergy();
        fire4 = new FireEnergy();
        fire5 = new FireEnergy();

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
        assertEquals(tepig.getCardName(), "Tepig");
        assertEquals(flareon.getCardName(), "Flareon");
    }

    @Test
    public void getID() {
        assertEquals(tepig.getID(), 3);
        assertEquals(flareon.getID(), 88);
    }

    @Test
    public void getHP() {
        assertEquals(tepig.getHP(), 70);
        assertEquals(flareon.getHP(), 90);
    }
    @Test
    public void receiveElectricEnergy() {
        tepig.receiveElectricEnergy(electric1);
        tepig.receiveElectricEnergy(electric2);
        flareon.receiveElectricEnergy(electric3);
        assertEquals(tepig.getElectricEnergyQuantity(), 2);
        assertEquals(flareon.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        flareon.receiveFightingEnergy(fighting1);
        flareon.receiveFightingEnergy(fighting2);
        tepig.receiveFightingEnergy(fighting3);
        assertEquals(tepig.getFightingEnergyQuantity(),1);
        assertEquals(flareon.getFightingEnergyQuantity(),2);
    }

    @Test
    public void receiveFireEnergy() {
        flareon.receiveFireEnergy(fire1);
        flareon.receiveFireEnergy(fire2);
        flareon.receiveFireEnergy(fire3);
        assertEquals(flareon.getFireEnergyQuantity(), 3);
        assertEquals(tepig.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        tepig.receiveGrassEnergy(grass1);
        tepig.receiveGrassEnergy(grass2);
        tepig.receiveGrassEnergy(grass3);
        assertEquals(tepig.getGrassEnergyQuantity(), 3);
        assertEquals(flareon.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        tepig.receivePsychicEnergy(psychic1);
        tepig.receivePsychicEnergy(psychic2);
        flareon.receivePsychicEnergy(psychic3);
        assertEquals(tepig.getPsychicEnergyQuantity(), 2);
        assertEquals(flareon.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        flareon.receiveWaterEnergy(water1);
        flareon.receiveWaterEnergy(water2);
        tepig.receiveWaterEnergy(water3);
        assertEquals(tepig.getWaterEnergyQuantity(),1);
        assertEquals(flareon.getWaterEnergyQuantity(),2);
    }

    @Test
    public void receiveWaterPokemonAttack() {
        flareon.receiveWaterPokemonAttack(firstAttack);
        assertEquals(flareon.getHP(), 10);
    }

    @Test
    public void attack() {
        Trainer t1 = new Trainer("Trainer 1");
        Trainer t2 = new Trainer("Trainer 2");

        t1.setOpponent(t2);
        t2.setOpponent(t1);


        t1.addCardToHand(tepig);
        t1.addCardToHand(fire1);
        t1.addCardToHand(fire2);
        t1.addCardToHand(fire3);
        t1.addCardToHand(fire4);
        t1.addCardToHand(fire5);
        t1.addCardToHand(fighting1);

        t2.addCardToHand(flareon);
        t1.play(tepig);

        t1.setSelectedPokemon(tepig);
        t1.play(fighting1);
        t1.setSelectedPokemon(tepig);
        t1.play(fire1);
        t1.setSelectedPokemon(tepig);
        t1.play(fire2);
        t1.setSelectedPokemon(tepig);
        t1.play(fire3);
        t1.setSelectedPokemon(tepig);
        t1.play(fire4);
        t1.setSelectedPokemon(tepig);
        t1.play(fire5);


        t2.play(flareon);
        t1.makeAnAbility(1);
        assertEquals(flareon.getHP(), 50);
    }

    @Test
    public void equals() {
        assertEquals(tepig, new BasicFirePokemon("Tepig", 3, 70, thirdContainer));
    }
}