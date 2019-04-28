package cc3002.pokemonTypes;

import cc3002.AbstractPokemon;
import cc3002.Attack;
import cc3002.AttackContainer;
import cc3002.IPokemon;

public class WaterPokemon extends AbstractPokemon {
    /**
     * Creates a new water pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public WaterPokemon(String cardName, int id, int hp, AttackContainer attackList) {
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

}
