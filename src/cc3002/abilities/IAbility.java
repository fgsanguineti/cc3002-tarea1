package cc3002.abilities;

import cc3002.abilityvisitors.IAbilityVisitor;
import cc3002.energytypes.EnergyContainer;
import cc3002.pokemontypes.IPokemon;

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

    void accept(IAbilityVisitor v);

    IPokemon getAssociatedPokemon();

    void setAssociatedPokemon(IPokemon aPokemon);
}
