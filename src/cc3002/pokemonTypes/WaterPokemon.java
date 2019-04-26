package cc3002.pokemonTypes;

import cc3002.*;

public class WaterPokemon extends AbstractPokemon {

    WaterPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public String getCardName() {
        return super.getCardName();
    }

    @Override
    public void receiveElectricPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void receiveFightingPokemonAttack(Attack anAttack) {
        super.receiveResistantPokemonTypeAttack(anAttack);
    }

    @Override
    public void receiveGrassPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveWaterPokemonAttack(super.getActiveAttack());
    }

    @Override
    public void playCard(Trainer aTrainer) {

    }
}
