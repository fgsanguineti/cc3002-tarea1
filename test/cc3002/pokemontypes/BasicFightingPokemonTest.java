package cc3002.pokemontypes;

import cc3002.Trainer;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.abilities.effects.NullEffect;
import cc3002.energies.*;
import cc3002.pokemontypes.fighting.BasicFightingPokemon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicFightingPokemonTest {
    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;
    private BasicFightingPokemon riolu, lucario;

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


        riolu = new BasicFightingPokemon("Riolu", 33, 60, firstContainer);
        lucario = new BasicFightingPokemon("Lucario", 85, 100, secondContainer);

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
        assertEquals(riolu.getCardName(), "Riolu");
        assertEquals(lucario.getCardName(), "Lucario");
    }

    @Test
    public void getID() {
        assertEquals(riolu.getID(), 33);
        assertEquals(lucario.getID(), 85);
    }

    @Test
    public void getHP() {
        assertEquals(riolu.getHP(), 60);
        assertEquals(lucario.getHP(), 100);
    }

    @Test
    public void receiveElectricEnergy() {
        riolu.receiveElectricEnergy(electric1);
        riolu.receiveElectricEnergy(electric2);
        lucario.receiveElectricEnergy(electric3);
        assertEquals(riolu.getElectricEnergyQuantity(), 2);
        assertEquals(lucario.getElectricEnergyQuantity(), 1);
    }

    @Test
    public void receiveFightingEnergy() {
        lucario.receiveFightingEnergy(fighting1);
        lucario.receiveFightingEnergy(fighting2);
        riolu.receiveFightingEnergy(fighting3);
        assertEquals(riolu.getFightingEnergyQuantity(), 1);
        assertEquals(lucario.getFightingEnergyQuantity(), 2);
    }

    @Test
    public void receiveFireEnergy() {
        lucario.receiveFireEnergy(fire1);
        lucario.receiveFireEnergy(fire2);
        lucario.receiveFireEnergy(fire3);
        assertEquals(lucario.getFireEnergyQuantity(), 3);
        assertEquals(riolu.getFireEnergyQuantity(), 0);


    }

    @Test
    public void receiveGrassEnergy() {
        riolu.receiveGrassEnergy(grass1);
        riolu.receiveGrassEnergy(grass2);
        riolu.receiveGrassEnergy(grass3);
        assertEquals(riolu.getGrassEnergyQuantity(), 3);
        assertEquals(lucario.getGrassEnergyQuantity(), 0);

    }

    @Test
    public void receivePsychicEnergy() {
        riolu.receivePsychicEnergy(psychic1);
        riolu.receivePsychicEnergy(psychic2);
        lucario.receivePsychicEnergy(psychic3);
        assertEquals(riolu.getPsychicEnergyQuantity(), 2);
        assertEquals(lucario.getPsychicEnergyQuantity(), 1);
    }

    @Test
    public void receiveWaterEnergy() {
        lucario.receiveWaterEnergy(water1);
        lucario.receiveWaterEnergy(water2);
        riolu.receiveWaterEnergy(water3);
        assertEquals(riolu.getWaterEnergyQuantity(), 1);
        assertEquals(lucario.getWaterEnergyQuantity(), 2);
    }

    @Test
    public void receiveGrassPokemonAttack() {
        riolu.receiveGrassPokemonAttack(secondAttack);
        assertEquals(riolu.getHP(), 0);
    }

    @Test
    public void receivePsychicPokemonAttack() {
        riolu.receivePsychicPokemonAttack(secondAttack);
        assertEquals(riolu.getHP(), 0);
    }

    @Test
    public void attack() {
        Trainer t1 = new Trainer("Trainer 1");
        Trainer t2 = new Trainer("Trainer 2");

        t1.setOpponent(t2);
        t2.setOpponent(t1);

        t1.addCardToHand(riolu);
        t1.addCardToHand(fire1);
        t1.addCardToHand(fire2);
        t1.addCardToHand(fire3);
        t1.addCardToHand(fire4);
        t1.addCardToHand(fire5);
        t1.addCardToHand(fighting1);

        t2.addCardToHand(lucario);
        t1.play(riolu);

        t1.setSelectedPokemon(riolu);
        t1.play(fighting1);
        t1.setSelectedPokemon(riolu);
        t1.play(fire1);
        t1.setSelectedPokemon(riolu);
        t1.play(fire2);
        t1.setSelectedPokemon(riolu);
        t1.play(fire3);
        t1.setSelectedPokemon(riolu);
        t1.play(fire4);
        t1.setSelectedPokemon(riolu);
        t1.play(fire5);

        t2.play(lucario);
        t1.makeAnAbility(1);
        assertEquals(lucario.getHP(), 60);
    }

    @Test
    public void equals() {
        assertEquals(riolu, new BasicFightingPokemon("Riolu", 33, 60, firstContainer));
    }

}