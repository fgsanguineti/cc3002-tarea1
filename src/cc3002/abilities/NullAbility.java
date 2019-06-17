package cc3002.abilities;

import cc3002.abilities.effects.NullEffect;
import cc3002.energies.EnergyContainer;
import cc3002.visitor.ability.IAbilityVisitor;

/**
 * This class define the behavior of the NullAbility.
 *
 * @author F. Giovanni Sanguineti
 */
public class NullAbility extends AbstractAbility implements IAttack {
    private int baseDamage;

    /**
     * Creates a new NullAbility.
     */
    public NullAbility() {
        super("", "", new EnergyContainer(0, 0, 0, 0, 0, 0), new NullEffect());
        this.baseDamage = 0;
    }

    /**
     * {@inheritDoc}
     *
     * @param v the Visitor that performs the operation.
     */
    @Override
    public void accept(IAbilityVisitor v) {
    }

    /**
     * Compares the NullAbility with another Attack.
     *
     * @param o Another NullAbility .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NullAbility)) return false;
        if (!super.equals(o)) return false;
        NullAbility that = (NullAbility) o;
        return baseDamage == that.baseDamage;
    }

    /**
     * Returns the base damage of the attack.
     *
     * @return A int with the base damage of the attack.
     */
    @Override
    public int getBaseDamage() {
        return this.baseDamage;
    }
}
