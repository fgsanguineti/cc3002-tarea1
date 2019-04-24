package cc3002.pokemonTypes;

import cc3002.AbstractPokemon;
import cc3002.Trainer;

public class FightningPokemon extends AbstractPokemon {
    FightningPokemon(String cardName, int id, int hp) {
        super(cardName, id, hp);
    }

    @Override
    public void playCard(Trainer aTrainer) {
    }
}
