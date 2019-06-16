package cc3002.abilities;

import cc3002.abilities.effects.NullEffect;
import cc3002.pokemontypes.IPokemon;

import java.util.Arrays;

/**
 * This class allows to store up to four abilities.
 *
 * @author F. Giovanni Sanguineti
 */
public class AbilityContainer {
    private IAbility[] abilityContainer;

    /**
     * Build the AbilityContainer.
     * @param a Stores the first ability.
     * @param b Stores the second ability.
     * @param c Stores the third ability.
     * @param d Stores the fourth ability.
     */
    public AbilityContainer(IAbility a, IAbility b, IAbility c, IAbility d) {
        abilityContainer = new IAbility[4];
        this.abilityContainer[0] = a;
        this.abilityContainer[1] = b;
        this.abilityContainer[2] = c;
        this.abilityContainer[3] = d;
    }

    /**
     * Returns the ability specified object.
     * @param n The number of the ability. Values must be a integer between 1 and 4.
     * @return The specified ability.
     */
    public IAbility getAbility(int n) {
        return this.abilityContainer[n - 1];
    }

    public void setAssociatedPokemonToAllAbilities(IPokemon aPokemon) {
        for (IAbility a : this.abilityContainer) {
            if (!a.equals(new NullAbility())) {
                a.setAssociatedPokemon(aPokemon);
                if (!a.getEffect().equals(new NullEffect())) a.getEffect().setAssociatedAbility(a);
            }
        }
    }
    /**
     * Compares the AbilityContainer with another AbilityContainer.
     * @param o  Another AbilityContainer .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbilityContainer)) return false;
        AbilityContainer that = (AbilityContainer) o;
        return Arrays.equals(abilityContainer, that.abilityContainer);
    }
}

