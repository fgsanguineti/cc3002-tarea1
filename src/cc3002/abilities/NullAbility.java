package cc3002.abilities;

import cc3002.abilities.effects.NullEffect;
import cc3002.energies.EnergyContainer;
import cc3002.visitor.ability.IAbilityVisitor;

public class NullAbility extends AbstractAbility implements IAttack {
    private int baseDamage;

    /**
     * Creates a new NullAbility.
     */
    public NullAbility() {
        super("", "", new EnergyContainer(0, 0, 0, 0, 0, 0), new NullEffect());
        this.baseDamage = 0;
    }

    @Override
    public void accept(IAbilityVisitor v) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NullAbility)) return false;
        if (!super.equals(o)) return false;
        NullAbility that = (NullAbility) o;
        return baseDamage == that.baseDamage;
    }

    @Override
    public int getBaseDamage() {
        return this.baseDamage;
    }
}
