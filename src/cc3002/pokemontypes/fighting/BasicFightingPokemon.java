package cc3002.pokemontypes.fighting;

import cc3002.abilities.AbilityContainer;
import cc3002.cardvisitors.ICardVisitor;
import cc3002.pokemontypes.IBasicPokemon;


public class BasicFightingPokemon extends AbstractFightingPokemon implements IBasicPokemon {
    /**
     * Creates a new fighting pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public BasicFightingPokemon(String cardName, int id, int hp, AbilityContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void accept(ICardVisitor v) {
        v.visitBasicPokemon(this);
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
        if (!(o instanceof BasicFightingPokemon)) return false;
        return super.equals(o);
    }
}
