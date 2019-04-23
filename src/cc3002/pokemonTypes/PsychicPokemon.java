package cc3002.pokemonTypes;

import cc3002.AbstractPokemon;

public class PsychicPokemon extends AbstractPokemon {
    public PsychicPokemon(String cardName, int id, int hp) {
        super(cardName, id, hp);
    }

    @Override
    public String getCardName() {
        return null;
    }

    @Override
    public void playCard() {

    }
}
