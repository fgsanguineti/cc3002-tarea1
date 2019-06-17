package cc3002.abilities;

import cc3002.abilities.effects.concrete.ElectricShockEffect;
import cc3002.energies.EnergyContainer;

public class ElectricShock extends Attack {
    /**
     * Creates a new Electric Shock attack.
     */
    public ElectricShock(int x) {
        super("Electric Shock", "Flip a coin, if Tails, then this Pokemon receive X of damage.",
                100, new EnergyContainer(1, 0, 0, 0, 0, 0), new ElectricShockEffect(x));
    }
}
