package cc3002.pokemontypes.fire;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemontypes.IPhaseOnePokemon;

public class PhaseOneFirePokemon extends AbstractFirePokemon implements IPhaseOnePokemon {
    private int basicPokemonToEvolveID;
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    PhaseOneFirePokemon(String cardName, int id, int hp, AttackContainer attackList, int basicPokemonToEvolveID) {
        super(cardName, id, hp, attackList);
        this.basicPokemonToEvolveID = basicPokemonToEvolveID;
    }

    @Override
    public int getBasicPokemonToEvolveID() {
        return this.basicPokemonToEvolveID;
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
        if (!(o instanceof PhaseOneFirePokemon)) return false;
        return super.equals(o);
    }
}
