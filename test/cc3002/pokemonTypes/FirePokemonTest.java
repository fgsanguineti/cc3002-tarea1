package cc3002.pokemonTypes;

import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirePokemonTest {

    private FirePokemon tepig, flareon;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        tepig = new FirePokemon("Tepig", 3, 70);
        flareon = new FirePokemon("Flareon", 88 , 90);

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
        assertEquals(tepig.getCardName(), "Tepig");
        assertEquals(flareon.getCardName(), "Flareon");
    }

    @Test
    void getID() {
        assertEquals(tepig.getID(), 3);
        assertEquals(flareon.getID(), 88);
    }

    @Test
    void getHP() {
        assertEquals(tepig.getHP(), 70);
        assertEquals(flareon.getHP(), 90);
    }
    @Test
    void receiveElectricEnergy() {
        tepig.receiveElectricEnergy(electric1);
        tepig.receiveElectricEnergy(electric2);
        flareon.receiveElectricEnergy(electric3);
        assertEquals(tepig.getElectricEnergyQuantity(), 2);
        assertEquals(flareon.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        flareon.receiveFightingEnergy(fighting1);
        flareon.receiveFightingEnergy(fighting2);
        tepig.receiveFightingEnergy(fighting3);
        assertEquals(tepig.getFightingEnergyQuantity(),1);
        assertEquals(flareon.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        flareon.receiveFireEnergy(fire1);
        flareon.receiveFireEnergy(fire2);
        flareon.receiveFireEnergy(fire3);
        assertEquals(flareon.getFireEnergyQuantity(), 3);
        assertEquals(tepig.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        tepig.receiveGrassEnergy(grass1);
        tepig.receiveGrassEnergy(grass2);
        tepig.receiveGrassEnergy(grass3);
        assertEquals(tepig.getGrassEnergyQuantity(), 3);
        assertEquals(flareon.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        tepig.receivePsychicEnergy(psychic1);
        tepig.receivePsychicEnergy(psychic2);
        flareon.receivePsychicEnergy(psychic3);
        assertEquals(tepig.getPsychicEnergyQuantity(), 2);
        assertEquals(flareon.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        flareon.receiveWaterEnergy(water1);
        flareon.receiveWaterEnergy(water2);
        tepig.receiveWaterEnergy(water3);
        assertEquals(tepig.getWaterEnergyQuantity(),1);
        assertEquals(flareon.getWaterEnergyQuantity(),2);
    }



}