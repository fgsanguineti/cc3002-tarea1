package cc3002.pokemonTypes.psychic;


import cc3002.Abilities.AttackContainer;
import cc3002.Trainer;
import cc3002.pokemonTypes.IPhaseOnePokemon;
import cc3002.pokemonTypes.IPhaseTwoPokemon;

public class PhaseOnePsychicPokemon extends AbstractPsychicPokemon implements IPhaseOnePokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    PhaseOnePsychicPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void evolveToPhaseTwo(IPhaseTwoPokemon other) {

    }

    @Override
    public void checkBasicPrePokemon(Trainer aTrainer) {

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
        if (!(o instanceof PhaseOnePsychicPokemon)) return false;
        return super.equals(o);
    }
}
