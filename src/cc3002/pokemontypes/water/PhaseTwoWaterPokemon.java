package cc3002.pokemontypes.water;

import cc3002.Abilities.AttackContainer;
import cc3002.pokemontypes.IPhaseTwoPokemon;

public class PhaseTwoWaterPokemon extends AbstractWaterPokemon implements IPhaseTwoPokemon {
    private int phaseOnePokemonToEvolveID;
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    PhaseTwoWaterPokemon(String cardName, int id, int hp, AttackContainer attackList, int phaseOnePokemonToEvolveID) {
        super(cardName, id, hp, attackList);
        this.phaseOnePokemonToEvolveID = phaseOnePokemonToEvolveID;
    }

    @Override
    public int getPhaseOnePokemonToEvolveID() {
        return this.phaseOnePokemonToEvolveID;
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
        if (!(o instanceof PhaseTwoWaterPokemon)) return false;
        return super.equals(o);
    }
}
