package cc3002.Abilities;

import cc3002.EnergyContainer;
import cc3002.IPokemon;

/**
 * Common interface for all the abilities. Abilities had a name, a description and a energy cost.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IAbility {
    String getName();
    String getDescription();
    EnergyContainer getCost();
    boolean isEnoughEnergyToUseTheAbility(IPokemon aPokemon);
}