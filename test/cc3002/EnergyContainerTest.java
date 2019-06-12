package cc3002;

import cc3002.energytypes.EnergyContainer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnergyContainerTest {
    private EnergyContainer first, second, third;

    @Before
    public void setUp() {
        first = new EnergyContainer(0, 0, 0, 0, 0, 0);
        second = new EnergyContainer(20, 15, 87, 41, 32, 88);
        third = new EnergyContainer(5, 1, 2, 3, 4, 5);
    }

    @Test
    public void getElectric() {
        assertEquals(0, first.getElectric());
        assertEquals(20, second.getElectric());
        assertEquals(5, third.getElectric());
    }

    @Test
    public void getFighting() {
        assertEquals(0, first.getFighting());
        assertEquals(15, second.getFighting());
        assertEquals(1, third.getFighting());
    }

    @Test
    public void getFire() {
        assertEquals(0, first.getFire());
        assertEquals(87, second.getFire());
        assertEquals(2, third.getFire());
    }

    @Test
    public void getGrass() {
        assertEquals(0, first.getGrass());
        assertEquals(41, second.getGrass());
        assertEquals(3, third.getGrass());
    }

    @Test
    public void getPsychic() {
        assertEquals(0, first.getPsychic());
        assertEquals(32, second.getPsychic());
        assertEquals(4, third.getPsychic());
    }

    @Test
    public void getWater() {
        assertEquals(0, first.getWater());
        assertEquals(88, second.getWater());
        assertEquals(5, third.getWater());
    }
}