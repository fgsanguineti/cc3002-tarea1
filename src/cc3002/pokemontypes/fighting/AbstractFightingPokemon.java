package cc3002.pokemontypes.fighting;

import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.pokemontypes.AbstractPokemon;
import cc3002.pokemontypes.IPokemon;

public abstract class AbstractFightingPokemon extends AbstractPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    AbstractFightingPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
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
