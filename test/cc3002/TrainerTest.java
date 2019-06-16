package cc3002;

import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.abilities.NullAbility;
import cc3002.energytypes.*;
import cc3002.pokemontypes.IPokemon;
import cc3002.pokemontypes.electric.BasicElectricPokemon;
import cc3002.pokemontypes.fighting.BasicFightingPokemon;
import cc3002.pokemontypes.fire.BasicFirePokemon;
import cc3002.pokemontypes.grass.BasicGrassPokemon;
import cc3002.pokemontypes.psychic.BasicPsychicPokemon;
import cc3002.pokemontypes.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class TrainerTest {
    private EnergyContainer first = new EnergyContainer(0, 1, 0, 0, 0, 0);
    private EnergyContainer second = new EnergyContainer(4, 0, 2, 0, 0, 0);
    private EnergyContainer third = new EnergyContainer(0, 1, 1, 0, 0, 0);
    private EnergyContainer fourth = new EnergyContainer(0, 1, 1, 0, 2, 1);
    private Trainer Franco, Giovanni;
    private BasicElectricPokemon pikachu, jolteon;
    private BasicFightingPokemon riolu, lucario;
    private BasicFirePokemon tepig, flareon;
    private BasicGrassPokemon chikorita, bulbasaur;
    private BasicPsychicPokemon espeon, mewto;
    private BasicWaterPokemon squirtle, gyarados;
    private ElectricEnergy electric1;
    private FightingEnergy fighting1;
    private FireEnergy fire1;
    private GrassEnergy grass1;
    private PsychicEnergy psychic1;
    private WaterEnergy water1;

    @Before
    public void setUp() {
        electric1 = new ElectricEnergy();
        fighting1 = new FightingEnergy();
        fire1 = new FireEnergy();
        grass1 = new GrassEnergy();
        psychic1 = new PsychicEnergy();
        water1 = new WaterEnergy();


        AbilityContainer firstContainer = new AbilityContainer(new Attack("Látigo Cepa", "",
                40, first), new Attack("Placaje", "",
                30, second), new NullAbility(), new NullAbility());
        AbilityContainer secondContainer = new AbilityContainer(
                new Attack("Vuelo", "", 50, third), new NullAbility(), new NullAbility(), new NullAbility());
        AbilityContainer thirdContainer = new AbilityContainer(new Attack("Látigo Cepa", "",
                40, first), new Attack("Placaje", "",
                30, second), new Attack("Vuelo", "", 50, third), new NullAbility());
        AbilityContainer fourthContainer = new AbilityContainer(
                new Attack("Golpe Karate", "", 20, fourth),
                new Attack("Vuelo", "", 50, third),
                new Attack("Placaje", "", 30, second),
                new Attack("Látigo Cepa", "", 40, first));


        // Franco
        pikachu = new BasicElectricPokemon("Pikachu", 54, 60, firstContainer);
        lucario = new BasicFightingPokemon("Lucario", 85, 100, secondContainer);
        tepig = new BasicFirePokemon("Tepig", 3, 70, thirdContainer);
        bulbasaur = new BasicGrassPokemon("Bulbasaur", 85, 100, firstContainer);
        espeon = new BasicPsychicPokemon("Espeon", 33, 60, fourthContainer);
        gyarados = new BasicWaterPokemon("Gyarados", 85, 100, thirdContainer);

        //Giovanni
        jolteon = new BasicElectricPokemon("Jolteon", 28, 160, fourthContainer);
        riolu = new BasicFightingPokemon("Riolu", 33, 60, firstContainer);
        flareon = new BasicFirePokemon("Flareon", 88, 90, firstContainer);
        chikorita = new BasicGrassPokemon("Chikorita", 33, 60, secondContainer);
        mewto = new BasicPsychicPokemon("Mewto", 85, 100, firstContainer);
        squirtle = new BasicWaterPokemon("Squirtle", 33, 60, secondContainer);

    }

    @Test
    public void getPlayerName() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);
        assertEquals(Franco.getPlayerName(), "Franco");
        assertEquals(Giovanni.getPlayerName(), "Giovanni");
    }

    @Test
    public void getActivePokemon() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);
        Franco.addCardToHand(pikachu);
        Giovanni.addCardToHand(squirtle);
        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(pikachu)));
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(squirtle)));
        assertEquals(Franco.getActivePokemon(), pikachu);
        assertEquals(Giovanni.getActivePokemon(), squirtle);
    }

    @Test
    public void getHand() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);
        Franco.addCardToHand(pikachu);
        Franco.addCardToHand(lucario);
        Franco.addCardToHand(tepig);
        Franco.addCardToHand(bulbasaur);
        Franco.addCardToHand(espeon);
        Franco.addCardToHand(gyarados);
        Franco.addCardToHand(electric1);
        Franco.addCardToHand(fighting1);
        Franco.addCardToHand(fire1);
        Franco.addCardToHand(grass1);
        Franco.addCardToHand(psychic1);
        Franco.addCardToHand(water1);

        Giovanni.addCardToHand(jolteon);
        Giovanni.addCardToHand(riolu);
        Giovanni.addCardToHand(flareon);
        Giovanni.addCardToHand(chikorita);
        Giovanni.addCardToHand(mewto);
        Giovanni.addCardToHand(squirtle);
        Giovanni.addCardToHand(electric1);
        Giovanni.addCardToHand(fighting1);
        Giovanni.addCardToHand(fire1);
        Giovanni.addCardToHand(grass1);
        Giovanni.addCardToHand(psychic1);
        Giovanni.addCardToHand(water1);

        ArrayList<ICard> francoHand = new ArrayList<>();
        ArrayList<ICard> giovanniHand = new ArrayList<>();

        francoHand.add(pikachu);
        francoHand.add(lucario);
        francoHand.add(tepig);
        francoHand.add(bulbasaur);
        francoHand.add(espeon);
        francoHand.add(gyarados);
        francoHand.add(electric1);
        francoHand.add(fighting1);
        francoHand.add(fire1);
        francoHand.add(grass1);
        francoHand.add(psychic1);
        francoHand.add(water1);

        giovanniHand.add(jolteon);
        giovanniHand.add(riolu);
        giovanniHand.add(flareon);
        giovanniHand.add(chikorita);
        giovanniHand.add(mewto);
        giovanniHand.add(squirtle);
        giovanniHand.add(electric1);
        giovanniHand.add(fighting1);
        giovanniHand.add(fire1);
        giovanniHand.add(grass1);
        giovanniHand.add(psychic1);
        giovanniHand.add(water1);

        assertEquals(francoHand, Franco.getHand());
        assertEquals(giovanniHand, Giovanni.getHand());
    }

    @Test
    public void getBench() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);
        Franco.addCardToHand(pikachu);
        Franco.addCardToHand(lucario);
        Franco.addCardToHand(tepig);
        Franco.addCardToHand(bulbasaur);
        Franco.addCardToHand(espeon);
        Franco.addCardToHand(gyarados);
        Franco.addCardToHand(jolteon);
        Franco.addCardToHand(riolu);
        Franco.addCardToHand(flareon);
        Franco.addCardToHand(chikorita);
        Franco.addCardToHand(mewto);

        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(pikachu)));
        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(lucario)));

        ArrayList<IPokemon> bench = new ArrayList<>();
        bench.add(lucario);

        assertEquals(bench, Franco.getBench());

        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(tepig)));
        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(bulbasaur)));
        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(espeon)));
        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(gyarados)));

        bench.add(tepig);
        bench.add(bulbasaur);
        bench.add(espeon);
        bench.add(gyarados);

        assertEquals(bench, Franco.getBench());

        Franco.play(Franco.getHand().get(Franco.getHand().indexOf(mewto)));
        bench.add(mewto);
        assertNotEquals(bench, Franco.getBench());
    }

    @Test
    public void Play() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);

        Giovanni.addCardToHand(jolteon);
        Giovanni.addCardToHand(riolu);
        Giovanni.addCardToHand(flareon);
        Giovanni.addCardToHand(electric1);
        Giovanni.addCardToHand(fighting1);
        Giovanni.addCardToHand(fire1);
        Giovanni.addCardToHand(grass1);

        ArrayList<ICard> bench = new ArrayList<>();
        assertEquals(Giovanni.getHand().size(), 7);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(jolteon)));
        assertEquals(Giovanni.getHand().size(), 6);
        assertEquals(Giovanni.getActivePokemon(), jolteon);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(grass1)));
        assertEquals(Giovanni.getHand().size(), 5);
        jolteon.receiveGrassEnergy(grass1);
        assertEquals(Giovanni.getActivePokemon(), jolteon);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(flareon)));
        assertEquals(Giovanni.getHand().size(), 4);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(riolu)));
        assertEquals(Giovanni.getHand().size(), 3);
        bench.add(flareon);
        bench.add(riolu);
        assertEquals(Giovanni.getBench(), bench);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(fire1)));
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(electric1)));
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(fighting1)));
        assertEquals(Giovanni.getHand().size(), 0);
        jolteon.receiveFireEnergy(fire1);
        jolteon.receiveElectricEnergy(electric1);
        jolteon.receiveFightingEnergy(fighting1);
        assertEquals(jolteon, Giovanni.getActivePokemon());
    }

    @Test
    public void makeAnAttack() {
        Trainer t1 = new Trainer("Franco");
        Trainer t2 = new Trainer("Giovanni");

        t1.setOpponent(t2);
        t2.setOpponent(t1);

        t1.addCardToHand(flareon);
        t1.addCardToHand(pikachu);

        t2.addCardToHand(jolteon);
        t2.addCardToHand(fighting1);
        t2.addCardToHand(fire1);
        t2.addCardToHand(water1);
        t2.addCardToHand(psychic1);

        t1.play(flareon);
        t1.play(pikachu);

        t2.play(jolteon);
        t2.setSelectedPokemon(jolteon);
        t2.play(fighting1);
        t2.play(fire1);
        t2.play(water1);
        t2.play(psychic1);
        t2.unselectPokemon();

        t2.makeAnAbility(4);
        assertEquals(t1.getActivePokemon().getHP(), 50);
        t2.makeAnAbility(2);
        assertEquals(pikachu, t1.getActivePokemon());
    }

    @Test
    public void equals() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");
        Giovanni.setOpponent(Franco);
        Franco.setOpponent(Giovanni);
        assertNotEquals(Franco, Giovanni);
        assertEquals(Franco, new Trainer("Franco"));
        Giovanni.addCardToHand(pikachu);
        Giovanni.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(pikachu)));
        Trainer giova = new Trainer("Giovanni");
        giova.addCardToHand(pikachu);
        giova.play(giova.getHand().get(giova.getHand().indexOf(pikachu)));
        assertEquals(giova, Giovanni);

        Giovanni.addCardToHand(pikachu);
        giova.play(Giovanni.getHand().get(Giovanni.getHand().indexOf(pikachu)));


    }
}