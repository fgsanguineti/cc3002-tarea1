package cc3002.energyTypes;

import cc3002.ICard;
import cc3002.pokemontypes.IPokemon;

/**
 * Common interface for all the energies, that also are a card. Besides the card attributes, a energy card also can be
 * added to a target Pokemon.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IEnergy extends ICard {
    void addEnergyToPokemon(IPokemon other);
}
