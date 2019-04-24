package cc3002.pokemonTypes;

import cc3002.energyTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightningPokemonTest {

    private FightningPokemon riolu, lucario;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    @BeforeEach
    void setUp() {
        riolu = new FightningPokemon("Riolu", 33, 60);
        lucario = new FightningPokemon("Lucario", 85, 100);

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
        assertEquals(riolu.getCardName(), "Riolu");
        assertEquals(lucario.getCardName(), "Lucario");
    }

    @Test
    void getID() {
        assertEquals(riolu.getID(), 33);
        assertEquals(lucario.getID(), 85);
    }

    @Test
    void getHP() {
        assertEquals(riolu.getHP(), 60);
        assertEquals(lucario.getHP(), 100);
    }
    @Test
    void receiveElectricEnergy() {
        riolu.receiveElectricEnergy(electric1);
        riolu.receiveElectricEnergy(electric2);
        lucario.receiveElectricEnergy(electric3);
        assertEquals(riolu.getElectricEnergyQuantity(), 2);
        assertEquals(lucario.getElectricEnergyQuantity(), 1);
    }

    @Test
    void receiveFightingEnergy() {
        lucario.receiveFightingEnergy(fighting1);
        lucario.receiveFightingEnergy(fighting2);
        riolu.receiveFightingEnergy(fighting3);
        assertEquals(riolu.getFightingEnergyQuantity(),1);
        assertEquals(lucario.getFightingEnergyQuantity(),2);
    }

    @Test
    void receiveFireEnergy() {
        lucario.receiveFireEnergy(fire1);
        lucario.receiveFireEnergy(fire2);
        lucario.receiveFireEnergy(fire3);
        assertEquals(lucario.getFireEnergyQuantity(), 3);
        assertEquals(riolu.getFireEnergyQuantity(), 0);


    }

    @Test
    void receiveGrassEnergy() {
        riolu.receiveGrassEnergy(grass1);
        riolu.receiveGrassEnergy(grass2);
        riolu.receiveGrassEnergy(grass3);
        assertEquals(riolu.getGrassEnergyQuantity(), 3);
        assertEquals(lucario.getGrassEnergyQuantity(), 0);

    }

    @Test
    void receivePsychicEnergy() {
        riolu.receivePsychicEnergy(psychic1);
        riolu.receivePsychicEnergy(psychic2);
        lucario.receivePsychicEnergy(psychic3);
        assertEquals(riolu.getPsychicEnergyQuantity(), 2);
        assertEquals(lucario.getPsychicEnergyQuantity(), 1);
    }

    @Test
    void receiveWaterEnergy() {
        lucario.receiveWaterEnergy(water1);
        lucario.receiveWaterEnergy(water2);
        riolu.receiveWaterEnergy(water3);
        assertEquals(riolu.getWaterEnergyQuantity(),1);
        assertEquals(lucario.getWaterEnergyQuantity(),2);
    }


}