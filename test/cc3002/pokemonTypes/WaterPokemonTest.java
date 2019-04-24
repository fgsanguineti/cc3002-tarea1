package cc3002.pokemonTypes;

import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterPokemonTest {

    private WaterPokemon squirtle, gyarados;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        squirtle = new WaterPokemon("Squirtle", 33, 60);
        gyarados = new WaterPokemon("Gyarados", 85, 100);
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
        assertEquals(squirtle.getCardName(), "Squirtle");
        assertEquals(gyarados.getCardName(), "Gyarados");
    }

    @Test
    void getID() {
        assertEquals(squirtle.getID(), 33);
        assertEquals(gyarados.getID(), 85);
    }

    @Test
    void getHP() {
        assertEquals(squirtle.getHP(), 60);
        assertEquals(gyarados.getHP(), 100);
    }
    @Test
    void receiveElectricEnergy() {
        squirtle.receiveElectricEnergy(electric1);
        squirtle.receiveElectricEnergy(electric2);
        gyarados.receiveElectricEnergy(electric3);
        assertEquals(squirtle.getElectricEnergyQuantity(), 2);
        assertEquals(gyarados.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        gyarados.receiveFightingEnergy(fighting1);
        gyarados.receiveFightingEnergy(fighting2);
        squirtle.receiveFightingEnergy(fighting3);
        assertEquals(squirtle.getFightingEnergyQuantity(),1);
        assertEquals(gyarados.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        gyarados.receiveFireEnergy(fire1);
        gyarados.receiveFireEnergy(fire2);
        gyarados.receiveFireEnergy(fire3);
        assertEquals(gyarados.getFireEnergyQuantity(), 3);
        assertEquals(squirtle.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        squirtle.receiveGrassEnergy(grass1);
        squirtle.receiveGrassEnergy(grass2);
        squirtle.receiveGrassEnergy(grass3);
        assertEquals(squirtle.getGrassEnergyQuantity(), 3);
        assertEquals(gyarados.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        squirtle.receivePsychicEnergy(psychic1);
        squirtle.receivePsychicEnergy(psychic2);
        gyarados.receivePsychicEnergy(psychic3);
        assertEquals(squirtle.getPsychicEnergyQuantity(), 2);
        assertEquals(gyarados.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        gyarados.receiveWaterEnergy(water1);
        gyarados.receiveWaterEnergy(water2);
        squirtle.receiveWaterEnergy(water3);
        assertEquals(squirtle.getWaterEnergyQuantity(),1);
        assertEquals(gyarados.getWaterEnergyQuantity(),2);
    }




}