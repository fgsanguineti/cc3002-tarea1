package cc3002;

import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.energyTypes.*;
import cc3002.pokemonTypes.IPokemon;
import cc3002.pokemonTypes.electric.ElectricPokemon;
import cc3002.pokemonTypes.fighting.FightingPokemon;
import cc3002.pokemonTypes.fire.FirePokemon;
import cc3002.pokemonTypes.grass.GrassPokemon;
import cc3002.pokemonTypes.psychic.PsychicPokemon;
import cc3002.pokemonTypes.water.WaterPokemon;
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
    private ElectricPokemon pikachu, jolteon;
    private FightingPokemon riolu, lucario;
    private FirePokemon tepig, flareon;
    private GrassPokemon chikorita, bulbasaur;
    private PsychicPokemon espeon, mewto;
    private WaterPokemon squirtle, gyarados;
    private ElectricEnergy electric1;
    private FightingEnergy fighting1;
    private FireEnergy fire1;
    private GrassEnergy grass1;
    private PsychicEnergy psychic1;
    private WaterEnergy water1;

    @Before
    public void setUp() {
        Franco = new Trainer("Franco");
        Giovanni = new Trainer("Giovanni");

        electric1 = new ElectricEnergy();
        fighting1 = new FightingEnergy();
        fire1 = new FireEnergy();
        grass1 = new GrassEnergy();
        psychic1 = new PsychicEnergy();
        water1 = new WaterEnergy();


        Attack firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first);
        Attack secondAttack = new Attack("Placaje", "Le pega un buen colpe al oponente con su cuerpo",
                30, second);
        Attack thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente", 50, third);
        Attack fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate", 20, fourth);

        AttackContainer firstContainer = new AttackContainer(firstAttack, secondAttack, null, null);
        AttackContainer secondContainer = new AttackContainer(thirdAttack, null, null, null);
        AttackContainer thirdContainer = new AttackContainer(firstAttack, secondAttack, thirdAttack, null);
        AttackContainer fourthContainer = new AttackContainer(fourthAttack, thirdAttack, secondAttack, firstAttack);

        // Franco
        pikachu = new ElectricPokemon("Pikachu", 54, 60, firstContainer);
        lucario = new FightingPokemon("Lucario", 85, 100, secondContainer);
        tepig = new FirePokemon("Tepig", 3, 70, thirdContainer);
        bulbasaur = new GrassPokemon("Bulbasaur", 85, 100, firstContainer);
        espeon = new PsychicPokemon("Espeon", 33, 60, fourthContainer);
        gyarados = new WaterPokemon("Gyarados", 85, 100, thirdContainer);

        //Giovanni
        jolteon = new ElectricPokemon("Jolteon", 28, 160, fourthContainer);
        riolu = new FightingPokemon("Riolu", 33, 60, firstContainer);
        flareon = new FirePokemon("Flareon", 88, 90, fourthContainer);
        chikorita = new GrassPokemon("Chikorita", 33, 60, secondContainer);
        mewto = new PsychicPokemon("Mewto", 85, 100, firstContainer);
        squirtle = new WaterPokemon("Squirtle", 33, 60, secondContainer);

    }

    @Test
    public void getPlayerName() {
        assertEquals(Franco.getPlayerName(), "Franco");
        assertEquals(Giovanni.getPlayerName(), "Giovanni");
    }

    @Test
    public void getActivePokemon() {
        Franco.addCardToHand(pikachu);
        Giovanni.addCardToHand(squirtle);
        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(pikachu)));
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(squirtle)));
        assertEquals(Franco.getActivePokemon(), pikachu);
        assertEquals(Giovanni.getActivePokemon(), squirtle);
    }

    @Test
    public void getHand() {
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

        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(pikachu)));
        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(lucario)));

        ArrayList<IPokemon> bench = new ArrayList<>();
        bench.add(lucario);

        assertEquals(bench, Franco.getBench());

        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(tepig)));
        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(bulbasaur)));
        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(espeon)));
        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(gyarados)));

        bench.add(tepig);
        bench.add(bulbasaur);
        bench.add(espeon);
        bench.add(gyarados);

        assertEquals(bench, Franco.getBench());

        Franco.Play(Franco.getHand().get(Franco.getHand().indexOf(mewto)));
        bench.add(mewto);
        assertNotEquals(bench, Franco.getBench());
    }

    @Test
    public void Play() {

        Giovanni.addCardToHand(jolteon);
        Giovanni.addCardToHand(riolu);
        Giovanni.addCardToHand(flareon);
        Giovanni.addCardToHand(electric1);
        Giovanni.addCardToHand(fighting1);
        Giovanni.addCardToHand(fire1);
        Giovanni.addCardToHand(grass1);

        ArrayList<ICard> bench = new ArrayList<>();

        assertEquals(Giovanni.getHand().size(), 7);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(jolteon)));
        assertEquals(Giovanni.getHand().size(), 6);
        assertEquals(Giovanni.getActivePokemon(), jolteon);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(grass1)));
        assertEquals(Giovanni.getHand().size(), 5);
        jolteon.receiveGrassEnergy(grass1);
        assertEquals(Giovanni.getActivePokemon(), jolteon);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(flareon)));
        assertEquals(Giovanni.getHand().size(), 4);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(riolu)));
        assertEquals(Giovanni.getHand().size(), 3);
        bench.add(flareon);
        bench.add(riolu);
        assertEquals(Giovanni.getBench(), bench);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(fire1)));
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(electric1)));
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(fighting1)));
        assertEquals(Giovanni.getHand().size(), 0);
        jolteon.receiveFireEnergy(fire1);
        jolteon.receiveElectricEnergy(electric1);
        jolteon.receiveFightingEnergy(fighting1);
        assertEquals(jolteon, Giovanni.getActivePokemon());
    }

    @Test
    public void makeAnAttack() {
        Franco.addCardToHand(flareon);
        Franco.addCardToHand(pikachu);
        Franco.Play(Franco.getHand().get(0));
        Franco.Play(Franco.getHand().get(0));

        Giovanni.addCardToHand(jolteon);
        Giovanni.addCardToHand(fighting1);
        Giovanni.addCardToHand(fire1);
        Giovanni.addCardToHand(water1);
        Giovanni.addCardToHand(psychic1);

        Giovanni.Play(Giovanni.getHand().get(0));
        Giovanni.Play(Giovanni.getHand().get(0));
        Giovanni.Play(Giovanni.getHand().get(0));
        Giovanni.Play(Giovanni.getHand().get(0));
        Giovanni.Play(Giovanni.getHand().get(0));
        Giovanni.makeAnAttack(4, Franco);
        assertEquals(Franco.getActivePokemon().getHP(), 50);
        Giovanni.makeAnAttack(2, Franco);
        assertEquals(pikachu, Franco.getActivePokemon());
    }

    @Test
    public void equals() {
        assertNotEquals(Franco, Giovanni);
        assertEquals(Franco, new Trainer("Franco"));
        Giovanni.addCardToHand(pikachu);
        Giovanni.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(pikachu)));
        Trainer Giova = new Trainer("Giovanni");
        Giova.addCardToHand(pikachu);
        Giova.Play(Giova.getHand().get(Giova.getHand().indexOf(pikachu)));
        assertEquals(Giova, Giovanni);

        Giovanni.addCardToHand(pikachu);
        Giova.Play(Giovanni.getHand().get(Giovanni.getHand().indexOf(pikachu)));


    }
}