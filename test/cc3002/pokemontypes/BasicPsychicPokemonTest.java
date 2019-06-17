package cc3002.pokemontypes;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.abilities.effects.NullEffect;
import cc3002.energies.*;
import cc3002.pokemontypes.psychic.BasicPsychicPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BasicPsychicPokemonTest {
    private Attack firstAttack;
    private Attack secondAttack;
    private BasicPsychicPokemon espeon, mewto;

    private ElectricEnergy electric1, electric2, electric3;
    private FightingEnergy fighting1, fighting2, fighting3;
    private FireEnergy fire1, fire2, fire3;
    private GrassEnergy grass1, grass2, grass3;
    private PsychicEnergy psychic1, psychic2, psychic3;
    private WaterEnergy water1, water2, water3;

    private AbilityContainer firstContainer;

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
        Attack thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente", 50, third, new NullEffect());
        Attack fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate", 20, fourth, new NullEffect());

        firstContainer = new AbilityContainer(firstAttack, secondAttack, new NullAbility(), new NullAbility());
        AbilityContainer fourthContainer = new AbilityContainer(fourthAttack, thirdAttack, secondAttack, firstAttack);

        espeon = new BasicPsychicPokemon("Espeon", 33, 60, fourthContainer);
        mewto = new BasicPsychicPokemon("Mewto", 85, 100, firstContainer);
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
        assertEquals(espeon.getCardName(), "Espeon");
        assertEquals(mewto.getCardName(), "Mewto");
    }

    @Test
    public void getID() {
        assertEquals(espeon.getID(), 33);
        assertEquals(mewto.getID(), 85);
    }

    @Test
    public void getHP() {
        assertEquals(espeon.getHP(), 60);
        assertEquals(mewto.getHP(), 100);
    }
    @Test
    public void receiveElectricEnergy() {
        espeon.receiveElectricEnergy(electric1);
        espeon.receiveElectricEnergy(electric2);
        mewto.receiveElectricEnergy(electric3);
        assertEquals(espeon.getElectricEnergyQuantity(), 2);
        assertEquals(mewto.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        mewto.receiveFightingEnergy(fighting1);
        mewto.receiveFightingEnergy(fighting2);
        espeon.receiveFightingEnergy(fighting3);
        assertEquals(espeon.getFightingEnergyQuantity(),1);
        assertEquals(mewto.getFightingEnergyQuantity(),2);
    }

    @Test
    public void receiveFireEnergy() {
        mewto.receiveFireEnergy(fire1);
        mewto.receiveFireEnergy(fire2);
        mewto.receiveFireEnergy(fire3);
        assertEquals(mewto.getFireEnergyQuantity(), 3);
        assertEquals(espeon.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        espeon.receiveGrassEnergy(grass1);
        espeon.receiveGrassEnergy(grass2);
        espeon.receiveGrassEnergy(grass3);
        assertEquals(espeon.getGrassEnergyQuantity(), 3);
        assertEquals(mewto.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        espeon.receivePsychicEnergy(psychic1);
        espeon.receivePsychicEnergy(psychic2);
        mewto.receivePsychicEnergy(psychic3);
        assertEquals(espeon.getPsychicEnergyQuantity(), 2);
        assertEquals(mewto.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        mewto.receiveWaterEnergy(water1);
        mewto.receiveWaterEnergy(water2);
        espeon.receiveWaterEnergy(water3);
        assertEquals(espeon.getWaterEnergyQuantity(),1);
        assertEquals(mewto.getWaterEnergyQuantity(),2);
    }

    @Test
    public void receiveFightingPokemonAttack() {
        mewto.receiveFightingPokemonAttack(firstAttack);
        assertEquals(mewto.getHP(), 90);
    }

    @Test
    public void receivePsychicPokemonAttack() {
        mewto.receivePsychicPokemonAttack(secondAttack);
        assertEquals(mewto.getHP(), 40);
    }

    @Test
    public void attack() {
        Trainer t1 = new Trainer("Trainer 1");
        Trainer t2 = new Trainer("Trainer 2");

        t1.setOpponent(t2);
        t2.setOpponent(t1);

        t1.addCardToHand(espeon);
        t1.play(t1.getHand().get(0));

        t1.setSelectedPokemon(espeon);
        t1.addCardToHand(electric1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(electric2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fighting1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fighting2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fire1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(fire2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(water1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(water2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(psychic1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(psychic2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(grass1);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.addCardToHand(grass2);
        t1.setSelectedPokemon(espeon);
        t1.play(t1.getHand().get(0));
        t1.unSelectPokemon();

        t2.addCardToHand(mewto);
        t2.play(mewto);
        t1.makeAnAbility(1);

        assertEquals(mewto.getHP(), 60);
    }

    @Test
    public void equals() {
        assertNotEquals(espeon, mewto);
        assertEquals(espeon, espeon);
        assertEquals(mewto, new BasicPsychicPokemon("Mewto", 85, 100, firstContainer));
        assertNotEquals(mewto, new BasicPsychicPokemon("Meto", 85, 100, firstContainer));
    }
}