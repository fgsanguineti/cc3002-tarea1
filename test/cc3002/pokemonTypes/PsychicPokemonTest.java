package cc3002.pokemonTypes;

import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PsychicPokemonTest {

    private PsychicPokemon espeon, mewto;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        espeon = new PsychicPokemon("Espeon", 33, 60);
        mewto = new PsychicPokemon("Mewto", 85, 100);
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
        assertEquals(espeon.getCardName(), "Espeon");
        assertEquals(mewto.getCardName(), "Mewto");
    }

    @Test
    void getID() {
        assertEquals(espeon.getID(), 33);
        assertEquals(mewto.getID(), 85);
    }

    @Test
    void getHP() {
        assertEquals(espeon.getHP(), 60);
        assertEquals(mewto.getHP(), 100);
    }
    @Test
    void receiveElectricEnergy() {
        espeon.receiveElectricEnergy(electric1);
        espeon.receiveElectricEnergy(electric2);
        mewto.receiveElectricEnergy(electric3);
        assertEquals(espeon.getElectricEnergyQuantity(), 2);
        assertEquals(mewto.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        mewto.receiveFightingEnergy(fighting1);
        mewto.receiveFightingEnergy(fighting2);
        espeon.receiveFightingEnergy(fighting3);
        assertEquals(espeon.getFightingEnergyQuantity(),1);
        assertEquals(mewto.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        mewto.receiveFireEnergy(fire1);
        mewto.receiveFireEnergy(fire2);
        mewto.receiveFireEnergy(fire3);
        assertEquals(mewto.getFireEnergyQuantity(), 3);
        assertEquals(espeon.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        espeon.receiveGrassEnergy(grass1);
        espeon.receiveGrassEnergy(grass2);
        espeon.receiveGrassEnergy(grass3);
        assertEquals(espeon.getGrassEnergyQuantity(), 3);
        assertEquals(mewto.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        espeon.receivePsychicEnergy(psychic1);
        espeon.receivePsychicEnergy(psychic2);
        mewto.receivePsychicEnergy(psychic3);
        assertEquals(espeon.getPsychicEnergyQuantity(), 2);
        assertEquals(mewto.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        mewto.receiveWaterEnergy(water1);
        mewto.receiveWaterEnergy(water2);
        espeon.receiveWaterEnergy(water3);
        assertEquals(espeon.getWaterEnergyQuantity(),1);
        assertEquals(mewto.getWaterEnergyQuantity(),2);
    }




}