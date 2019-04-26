package cc3002.pokemonTypes;

import cc3002.*;

public class GrassPokemon extends AbstractPokemon {
    GrassPokemon(String cardName, int id, int hp, AttackContainer attackList) {
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
    public void receiveFirePokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void receiveWaterPokemonAttack(Attack anAttack) {
        super.receiveResistantPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveGrassPokemonAttack(super.getActiveAttack());
    }
}
