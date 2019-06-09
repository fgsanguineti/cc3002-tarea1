package cc3002.pokemonTypes;

import cc3002.Trainer;

public interface IPhaseOnePokemon {
    void evolveToPhaseTwo(IPhaseTwoPokemon other);
    void checkBasicPrePokemon(Trainer aTrainer);
}
