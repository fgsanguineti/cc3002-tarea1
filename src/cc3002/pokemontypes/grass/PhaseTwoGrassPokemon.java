package cc3002.pokemontypes.grass;

import cc3002.abilities.AttackContainer;
import cc3002.cardvisitors.ICardVisitor;
import cc3002.pokemontypes.IPhaseTwoPokemon;


public class PhaseTwoGrassPokemon extends AbstractGrassPokemon implements IPhaseTwoPokemon {
    private int phaseOnePokemonToEvolveID;
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public PhaseTwoGrassPokemon(String cardName, int id, int hp, AttackContainer attackList, int phaseOnePokemonToEvolveID) {
        super(cardName, id, hp, attackList);
        this.phaseOnePokemonToEvolveID = phaseOnePokemonToEvolveID;
    }

    @Override
    public void accept(ICardVisitor v) {
        v.visitPhaseTwoPokemon(this);
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
        if (!(o instanceof PhaseTwoGrassPokemon)) return false;
        return super.equals(o);
    }
}
