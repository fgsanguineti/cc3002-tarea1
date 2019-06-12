package cc3002.pokemontypes;

import cc3002.abilities.Attack;
import cc3002.abilities.AttackContainer;
import cc3002.energytypes.*;
import cc3002.pokemontypes.grass.BasicGrassPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicGrassPokemonTest {
    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;
    private BasicGrassPokemon chikorita, bulbasaur;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    private AttackContainer firstContainer, secondContainer, thirdContainer, fourthContainer;

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

        firstContainer = new AttackContainer(firstAttack, secondAttack, null, null);
        secondContainer = new AttackContainer(thirdAttack, null, null, null);
        thirdContainer = new AttackContainer(firstAttack, secondAttack, thirdAttack, null);
        fourthContainer = new AttackContainer(fourthAttack, thirdAttack, secondAttack, firstAttack);

        chikorita = new BasicGrassPokemon("Chikorita", 33, 60, secondContainer);
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 85, 100, firstContainer);
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
        assertEquals(chikorita.getCardName(), "Chikorita");
        assertEquals(bulbasaur.getCardName(), "Bulbasaur");
    }

    @Test
    public void getID() {
        assertEquals(chikorita.getID(), 33);
        assertEquals(bulbasaur.getID(), 85);
    }

    @Test
    public void getHP() {
        assertEquals(chikorita.getHP(), 60);
        assertEquals(bulbasaur.getHP(), 100);
    }
    @Test
    public void receiveElectricEnergy() {
        chikorita.receiveElectricEnergy(electric1);
        chikorita.receiveElectricEnergy(electric2);
        bulbasaur.receiveElectricEnergy(electric3);
        assertEquals(chikorita.getElectricEnergyQuantity(), 2);
        assertEquals(bulbasaur.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        bulbasaur.receiveFightingEnergy(fighting1);
        bulbasaur.receiveFightingEnergy(fighting2);
        chikorita.receiveFightingEnergy(fighting3);
        assertEquals(chikorita.getFightingEnergyQuantity(),1);
        assertEquals(bulbasaur.getFightingEnergyQuantity(),2);
    }

    @Test
    public void receiveFireEnergy() {
        bulbasaur.receiveFireEnergy(fire1);
        bulbasaur.receiveFireEnergy(fire2);
        bulbasaur.receiveFireEnergy(fire3);
        assertEquals(bulbasaur.getFireEnergyQuantity(), 3);
        assertEquals(chikorita.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        chikorita.receiveGrassEnergy(grass1);
        chikorita.receiveGrassEnergy(grass2);
        chikorita.receiveGrassEnergy(grass3);
        assertEquals(chikorita.getGrassEnergyQuantity(), 3);
        assertEquals(bulbasaur.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        chikorita.receivePsychicEnergy(psychic1);
        chikorita.receivePsychicEnergy(psychic2);
        bulbasaur.receivePsychicEnergy(psychic3);
        assertEquals(chikorita.getPsychicEnergyQuantity(), 2);
        assertEquals(bulbasaur.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        bulbasaur.receiveWaterEnergy(water1);
        bulbasaur.receiveWaterEnergy(water2);
        chikorita.receiveWaterEnergy(water3);
        assertEquals(chikorita.getWaterEnergyQuantity(),1);
        assertEquals(bulbasaur.getWaterEnergyQuantity(),2);
    }

    @Test
    public void receiveWaterPokemonAttack() {
        bulbasaur.receiveWaterPokemonAttack(thirdAttack);
        assertEquals(bulbasaur.getHP(), 80);

        chikorita.receiveWaterPokemonAttack(fourthAttack);
        assertEquals(chikorita.getHP(), 60);
    }

    @Test
    public void receiveFirePokemonAttack() {
        bulbasaur.receiveFirePokemonAttack(firstAttack);
        assertEquals(bulbasaur.getHP(), 20);
    }

    @Test
    public void attack() {
        chikorita.setActiveAttack(1);
        chikorita.attack(bulbasaur);
        assertEquals(bulbasaur.getHP(), 50);
    }

    @Test
    public void receivePsychicPokemonAttack() {
        bulbasaur.receivePsychicPokemonAttack(firstAttack);
        assertEquals(bulbasaur.getHP(), 60);
    }

    @Test
    public void equals() {
        assertEquals(chikorita, new BasicGrassPokemon("Chikorita", 33, 60, secondContainer));
    }

}