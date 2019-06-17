package cc3002.abilities;

import cc3002.abilities.effects.IEffect;
import cc3002.energies.EnergyContainer;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.ability.IAbilityVisitor;

/**
 * Common interface for all the abilities. abilities had a name, a description and a energy cost.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IAbility {
    String getName();
    String getDescription();
    EnergyContainer getCost();
    boolean isEnoughEnergyToUseTheAbility(IPokemon aPokemon);

    IEffect getEffect();
    void accept(IAbilityVisitor v);

    IPokemon getAssociatedPokemon();

    void setAssociatedPokemon(IPokemon aPokemon);
}
