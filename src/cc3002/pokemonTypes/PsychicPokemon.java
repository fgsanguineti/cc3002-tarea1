package cc3002.pokemonTypes;

import cc3002.*;

public class PsychicPokemon extends AbstractPokemon {
    PsychicPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public String getCardName() {
        return super.getCardName();
    }

    @Override
    public void playCard(Trainer aTrainer) {

    }

    @Override
    public void receiveFightingPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void receivePsychicPokemonAttack(Attack anAttack) {
        super.receiveResistantPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receivePsychicPokemonAttack(super.getActiveAttack());
    }
}
