package cc3002.pokemonTypes.water;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemonTypes.AbstractPokemon;

public abstract class AbstractWaterPokemon extends AbstractPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public AbstractWaterPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }
}