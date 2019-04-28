package cc3002;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AttackTest {
    private Attack firstAttack, secondAttack, thirdAttack, fourthAttack;

    @BeforeEach
    void setUp() {
        EnergyContainer first = new EnergyContainer(0, 1, 5, 0, 0, 0);
        EnergyContainer second = new EnergyContainer(4, 0, 2, 0, 0, 0);
        EnergyContainer third = new EnergyContainer(0, 1, 2, 1, 2, 1);
        EnergyContainer fourth = new EnergyContainer(0, 1, 1, 0, 2, 1);

        firstAttack = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first);
        secondAttack = new Attack("Placaje", "Le pega un buen colpe al oponente con su cuerpo",
                30, second);
        thirdAttack = new Attack("Vuelo", "Vuela y le pega al oponente", 50, third);
        fourthAttack = new Attack("Golpe Karate", "Le pega un golpe de karate", 20, fourth);

    }

    @Test
    void getName() {
        assertEquals(firstAttack.getName(), "Látigo Cepa");
        assertEquals(secondAttack.getName(), "Placaje");
        assertEquals(thirdAttack.getName(), "Vuelo");
        assertEquals(fourthAttack.getName(), "Golpe Karate");
    }

    @Test
    void getDescription() {
        assertEquals(firstAttack.getDescription(), "Le pega con un látigo cepa al pókemon oponente");
        assertEquals(secondAttack.getDescription(), "Le pega un buen colpe al oponente con su cuerpo");
        assertEquals(thirdAttack.getDescription(), "Vuela y le pega al oponente");
        assertEquals(fourthAttack.getDescription(), "Le pega un golpe de karate");
    }

    @Test
    void getCost() {
        assertEquals(firstAttack.getCost().getFighting(), 1);
        assertEquals(secondAttack.getCost().getGrass(), 0);
        assertEquals(thirdAttack.getCost().getWater(), 1);
        assertEquals(fourthAttack.getCost().getPsychic(), 2);

        assertEquals(fourthAttack.getCost(), new EnergyContainer(0, 1, 1, 0, 2, 1));
    }

    @Test
    void getBaseDamage() {
        assertEquals(firstAttack.getBaseDamage(), 40);
        assertEquals(secondAttack.getBaseDamage(), 30);
        assertEquals(thirdAttack.getBaseDamage(), 50);
        assertEquals(fourthAttack.getBaseDamage(), 20);
    }

    @Test
    void equals() {
        EnergyContainer first = new EnergyContainer(0, 1, 5, 0, 0, 0);
        assertNotEquals(firstAttack, secondAttack);
        assertNotEquals(thirdAttack, fourthAttack);
        Attack test = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                40, first);
        Attack test2 = new Attack("Látigo Cepa", "Le pega con un látigo cepa al pókemon oponente",
                41, first);
        assertEquals(firstAttack, test);
        assertEquals(secondAttack, secondAttack);
        assertNotEquals(firstAttack, test2);
    }
}