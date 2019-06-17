package cc3002.abilities;

import cc3002.abilities.effects.IEffect;
import cc3002.energies.EnergyContainer;
import cc3002.visitor.ability.IAbilityVisitor;

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
    Ability(String name, String description, EnergyContainer costs, IEffect effect) {
        super(name, description, costs, effect);
    }

    /**
     * {@inheritDoc}
     *
     * @param v the Visitor that performs the operation.
     */
    @Override
    public void accept(IAbilityVisitor v) {
        v.visitAbility(this);
    }
    /**
     * Compares the ability with another Attack.
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
