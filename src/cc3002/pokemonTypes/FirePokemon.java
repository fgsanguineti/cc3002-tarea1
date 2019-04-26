package cc3002.pokemonTypes;

import cc3002.*;

public class FirePokemon extends AbstractPokemon {

    FirePokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void playCard(Trainer aTrainer) {
    }

    @Override
    public void receiveWaterPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveFirePokemonAttack(super.getActiveAttack());
    }
}
