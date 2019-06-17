package cc3002.abilities;

import cc3002.abilities.effects.IEffect;
import cc3002.energies.EnergyContainer;
import cc3002.visitor.ability.IAbilityVisitor;

/**
 * This class implements the IAttack interface.
 *
 * @author F. Giovanni Sanguineti
 */
public class Attack extends AbstractAbility implements IAttack {
    private int baseDamage;
    /**
     * Creates a new attack.
     * @param name a String with the attack name.
     * @param description a short description of the attack.
     * @param baseDamage a int value that represent the damage that the attack performs.
     * @param costs a EnergyContainer with the cost of the attack.
     */
    public Attack(String name, String description, int baseDamage, EnergyContainer costs, IEffect effect) {
        super(name, description, costs, effect);
        this.baseDamage = baseDamage;
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

    @Override
    public void accept(IAbilityVisitor v) {
        v.visitAttack(this);
    }

    /**
     * Compares the Attack with another Attack.
     *
     * @param o Another Attack .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attack)) return false;
        if (!super.equals(o)) return false;
        Attack attack = (Attack) o;
        return getBaseDamage() == attack.getBaseDamage();
    }
}
