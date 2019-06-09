package cc3002.pokemonTypes.fire;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemonTypes.IBasicPokemon;
import cc3002.pokemonTypes.IPhaseOnePokemon;

public class BasicFirePokemon extends AbstractFirePokemon implements IBasicPokemon {
    /**
     * Creates a new fire pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public BasicFirePokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }
    @Override
    public void evolveToPhaseOne(IPhaseOnePokemon other) {
    }
    /**
     * {@inheritDoc}
     *
     * @param o The target Pokemon object
     * @return True if are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicFirePokemon)) return false;
        return super.equals(o);
    }

}
