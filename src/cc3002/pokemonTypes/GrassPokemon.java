package cc3002.pokemonTypes;

import cc3002.AbstractPokemon;
import cc3002.Attack;
import cc3002.AttackContainer;
import cc3002.IPokemon;

public class GrassPokemon extends AbstractPokemon {
    /**
     * Creates a new grass pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public GrassPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public String getCardName() {
        return super.getCardName();
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
