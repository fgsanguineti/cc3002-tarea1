package cc3002.pokemonTypes;

import cc3002.*;

public class FightingPokemon extends AbstractPokemon {

    FightingPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void playCard(Trainer aTrainer) {
    }

    @Override
    public void receiveGrassPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void receivePsychicPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveFightingPokemonAttack(super.getActiveAttack());
    }

}
