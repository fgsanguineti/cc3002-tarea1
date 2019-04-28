package cc3002.pokemonTypes;

import cc3002.AbstractPokemon;
import cc3002.Attack;
import cc3002.AttackContainer;
import cc3002.IPokemon;

public class ElectricPokemon extends AbstractPokemon {

    /**
     * Creates a new electric pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public ElectricPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void receiveFightingPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override

    public void attack(IPokemon other) {
        other.receiveElectricPokemonAttack(super.getActiveAttack());
    }
}