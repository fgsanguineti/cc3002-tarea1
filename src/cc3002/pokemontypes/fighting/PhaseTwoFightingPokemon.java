package cc3002.pokemontypes.fighting;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemontypes.IPhaseTwoPokemon;

public class PhaseTwoFightingPokemon extends AbstractFightingPokemon implements IPhaseTwoPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    PhaseTwoFightingPokemon(String cardName, int id, int hp, AttackContainer attackList) {
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
        if (!(o instanceof PhaseTwoFightingPokemon)) return false;
        return super.equals(o);
    }
}
