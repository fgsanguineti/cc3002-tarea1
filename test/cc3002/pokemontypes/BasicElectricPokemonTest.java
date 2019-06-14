package cc3002.pokemontypes;

import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.energytypes.*;
import cc3002.pokemontypes.electric.BasicElectricPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicElectricPokemonTest {
    private BasicElectricPokemon pikachu, jolteon;

    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;

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
                40, first);
        secondAttack = new Attack("Placaje", "Le pega un buen colpe al oponente con su cuerpo",
                30, second);
        thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente", 50, third);
        fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate", 20, fourth);

        firstContainer = new AbilityContainer(firstAttack, secondAttack, null, null);
        secondContainer = new AbilityContainer(thirdAttack, null, null, null);
        thirdContainer = new AbilityContainer(firstAttack, secondAttack, thirdAttack, null);
        fourthContainer = new AbilityContainer(fourthAttack, thirdAttack, secondAttack, firstAttack);

        pikachu = new BasicElectricPokemon("Pikachu", 54, 60, firstContainer);
        jolteon = new BasicElectricPokemon("Jolteon", 28, 160, fourthContainer);


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
        assertEquals(pikachu.getCardName(), "Pikachu");
        assertEquals(jolteon.getCardName(), "Jolteon");
    }

    @Test
    public void getID() {
        assertEquals(pikachu.getID(), 54);
        assertEquals(jolteon.getID(), 28);
    }

    @Test
    public void getHP() {
        assertEquals(pikachu.getHP(), 60);
        assertEquals(jolteon.getHP(), 160);
    }
    @Test
    public void receiveElectricEnergy() {
        pikachu.receiveElectricEnergy(electric1);
        pikachu.receiveElectricEnergy(electric2);
        jolteon.receiveElectricEnergy(electric3);
        assertEquals(pikachu.getElectricEnergyQuantity(), 2);
        assertEquals(jolteon.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        jolteon.receiveFightingEnergy(fighting1);
        jolteon.receiveFightingEnergy(fighting2);
        pikachu.receiveFightingEnergy(fighting3);
        assertEquals(pikachu.getFightingEnergyQuantity(),1);
        assertEquals(jolteon.getFightingEnergyQuantity(),2);
    }

    @Test
    public void receiveFireEnergy() {
        jolteon.receiveFireEnergy(fire1);
        jolteon.receiveFireEnergy(fire2);
        jolteon.receiveFireEnergy(fire3);
        assertEquals(jolteon.getFireEnergyQuantity(), 3);
        assertEquals(pikachu.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        pikachu.receiveGrassEnergy(grass1);
        pikachu.receiveGrassEnergy(grass2);
        pikachu.receiveGrassEnergy(grass3);
        assertEquals(pikachu.getGrassEnergyQuantity(), 3);
        assertEquals(jolteon.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        pikachu.receivePsychicEnergy(psychic1);
        pikachu.receivePsychicEnergy(psychic2);
        jolteon.receivePsychicEnergy(psychic3);
        assertEquals(pikachu.getPsychicEnergyQuantity(), 2);
        assertEquals(jolteon.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        jolteon.receiveWaterEnergy(water1);
        jolteon.receiveWaterEnergy(water2);
        pikachu.receiveWaterEnergy(water3);
        assertEquals(pikachu.getWaterEnergyQuantity(),1);
        assertEquals(jolteon.getWaterEnergyQuantity(),2);
    }

    @Test
    public void receiveFightingPokemonAttack() {
        pikachu.receiveFightingPokemonAttack(thirdAttack);
        assertEquals(pikachu.getHP(), -40);
    }

    @Test
    public void equals() {
        assertEquals(pikachu, new BasicElectricPokemon("Pikachu", 54, 60, firstContainer));
    }
}