package cc3002.pokemontypes.psychic;

import cc3002.abilities.AbilityContainer;
import cc3002.abilities.Attack;
import cc3002.pokemontypes.AbstractPokemon;
import cc3002.pokemontypes.IPokemon;

public abstract class AbstractPsychicPokemon extends AbstractPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    AbstractPsychicPokemon(String cardName, int id, int hp, AbilityContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void receiveFightingPokemonAttack(Attack anAttack) {
        super.receiveResistantPokemonTypeAttack(anAttack);
    }

    @Override
    public void receivePsychicPokemonAttack(Attack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receivePsychicPokemonAttack(super.getActiveAttack());
    }

}
