package cc3002.pokemonTypes.electric;
import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.pokemonTypes.AbstractPokemon;
import cc3002.pokemonTypes.IPokemon;

public abstract class AbstractElectricPokemon extends AbstractPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    AbstractElectricPokemon(String cardName, int id, int hp, AttackContainer attackList) {
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
