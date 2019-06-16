package cc3002.abilities;

import cc3002.abilityvisitors.IAbilityVisitor;
import cc3002.energytypes.EnergyContainer;

/**
 * This class contents implements the IAbility interface
 *
 * @author F. Giovanni Sanguineti
 */
public class Ability extends AbstractAbility {

    /**
     * Creates a new ability.
     * @param name a String with the ability name.
     * @param description a short description of the ability.
     * @param costs a EnergyContainer with the cost of the ability.
     */
    Ability(String name, String description, EnergyContainer costs) {
        super(name, description, costs);
    }

    @Override
    public void accept(IAbilityVisitor v) {
        v.visitAbility(this);
    }
    /**
     * Compares the Ability with another Attack.
     *
     * @param o Another Attack .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        return super.equals(o);
    }
}
