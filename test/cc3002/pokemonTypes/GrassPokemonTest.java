package cc3002.pokemonTypes;

import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassPokemonTest {

    private GrassPokemon chikorita, bulbasaur;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        chikorita = new GrassPokemon("Chikorita", 33, 60);
        bulbasaur = new GrassPokemon("Bulbasaur", 85, 100);
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
    void getCardName() {
        assertEquals(chikorita.getCardName(), "Chikorita");
        assertEquals(bulbasaur.getCardName(), "Bulbasaur");
    }

    @Test
    void getID() {
        assertEquals(chikorita.getID(), 33);
        assertEquals(bulbasaur.getID(), 85);
    }

    @Test
    void getHP() {
        assertEquals(chikorita.getHP(), 60);
        assertEquals(bulbasaur.getHP(), 100);
    }
    @Test
    void receiveElectricEnergy() {
        chikorita.receiveElectricEnergy(electric1);
        chikorita.receiveElectricEnergy(electric2);
        bulbasaur.receiveElectricEnergy(electric3);
        assertEquals(chikorita.getElectricEnergyQuantity(), 2);
        assertEquals(bulbasaur.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        bulbasaur.receiveFightingEnergy(fighting1);
        bulbasaur.receiveFightingEnergy(fighting2);
        chikorita.receiveFightingEnergy(fighting3);
        assertEquals(chikorita.getFightingEnergyQuantity(),1);
        assertEquals(bulbasaur.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        bulbasaur.receiveFireEnergy(fire1);
        bulbasaur.receiveFireEnergy(fire2);
        bulbasaur.receiveFireEnergy(fire3);
        assertEquals(bulbasaur.getFireEnergyQuantity(), 3);
        assertEquals(chikorita.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        chikorita.receiveGrassEnergy(grass1);
        chikorita.receiveGrassEnergy(grass2);
        chikorita.receiveGrassEnergy(grass3);
        assertEquals(chikorita.getGrassEnergyQuantity(), 3);
        assertEquals(bulbasaur.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        chikorita.receivePsychicEnergy(psychic1);
        chikorita.receivePsychicEnergy(psychic2);
        bulbasaur.receivePsychicEnergy(psychic3);
        assertEquals(chikorita.getPsychicEnergyQuantity(), 2);
        assertEquals(bulbasaur.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        bulbasaur.receiveWaterEnergy(water1);
        bulbasaur.receiveWaterEnergy(water2);
        chikorita.receiveWaterEnergy(water3);
        assertEquals(chikorita.getWaterEnergyQuantity(),1);
        assertEquals(bulbasaur.getWaterEnergyQuantity(),2);
    }



}