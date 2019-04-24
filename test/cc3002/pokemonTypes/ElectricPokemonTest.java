package cc3002.pokemonTypes;

import cc3002.ICard;
import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricPokemonTest {
    private ElectricPokemon pikachu, jolteon;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        pikachu = new ElectricPokemon("Pikachu", 54, 60);
        jolteon = new ElectricPokemon("Jolteon", 28, 160);
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
        assertEquals(pikachu.getCardName(), "Pikachu");
        assertEquals(jolteon.getCardName(), "Jolteon");
    }

    @Test
    void getID() {
        assertEquals(pikachu.getID(), 54);
        assertEquals(jolteon.getID(), 28);
    }

    @Test
    void getHP() {
        assertEquals(pikachu.getHP(), 60);
        assertEquals(jolteon.getHP(), 160);
    }
    @Test
    void receiveElectricEnergy() {
        pikachu.receiveElectricEnergy(electric1);
        pikachu.receiveElectricEnergy(electric2);
        jolteon.receiveElectricEnergy(electric3);
        assertEquals(pikachu.getElectricEnergyQuantity(), 2);
        assertEquals(jolteon.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        jolteon.receiveFightingEnergy(fighting1);
        jolteon.receiveFightingEnergy(fighting2);
        pikachu.receiveFightingEnergy(fighting3);
        assertEquals(pikachu.getFightingEnergyQuantity(),1);
        assertEquals(jolteon.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        jolteon.receiveFireEnergy(fire1);
        jolteon.receiveFireEnergy(fire2);
        jolteon.receiveFireEnergy(fire3);
        assertEquals(jolteon.getFireEnergyQuantity(), 3);
        assertEquals(pikachu.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        pikachu.receiveGrassEnergy(grass1);
        pikachu.receiveGrassEnergy(grass2);
        pikachu.receiveGrassEnergy(grass3);
        assertEquals(pikachu.getGrassEnergyQuantity(), 3);
        assertEquals(jolteon.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        pikachu.receivePsychicEnergy(psychic1);
        pikachu.receivePsychicEnergy(psychic2);
        jolteon.receivePsychicEnergy(psychic3);
        assertEquals(pikachu.getPsychicEnergyQuantity(), 2);
        assertEquals(jolteon.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        jolteon.receiveWaterEnergy(water1);
        jolteon.receiveWaterEnergy(water2);
        pikachu.receiveWaterEnergy(water3);
        assertEquals(pikachu.getWaterEnergyQuantity(),1);
        assertEquals(jolteon.getWaterEnergyQuantity(),2);
    }

}