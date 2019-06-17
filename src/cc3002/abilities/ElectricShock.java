package cc3002.abilities;

import cc3002.abilities.effects.concrete.ElectricShockEffect;
import cc3002.energies.EnergyContainer;

/**
 * This class define the behavior of the ElectricShock Attack.
 * Flip a coin, if Tails, then this Pokemon receive X of damage, where X is defined in a new instance of the object.
 *
 * @author F. Giovanni Sanguineti
 */
public class ElectricShock extends Attack {
    /**
     * Creates a new Electric Shock attack.
     */
    public ElectricShock(int x) {
        super("Electric Shock", "Flip a coin, if Tails, then this Pokemon receive X of damage.",
                100, new EnergyContainer(1, 0, 0, 0, 0, 0), new ElectricShockEffect(x));
    }
}
