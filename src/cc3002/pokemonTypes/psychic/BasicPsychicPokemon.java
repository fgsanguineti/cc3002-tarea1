package cc3002.pokemonTypes.psychic;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemonTypes.IBasicPokemon;

public class BasicPsychicPokemon extends AbstractPsychicPokemon implements IBasicPokemon {
    /**
     * Creates a new psychic pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public BasicPsychicPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
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
        if (!(o instanceof BasicPsychicPokemon)) return false;
        return super.equals(o);
    }

}
