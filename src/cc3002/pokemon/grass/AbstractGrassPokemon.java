package cc3002.pokemon.grass;

import cc3002.abilities.AbilityContainer;
import cc3002.abilities.IAttack;
import cc3002.pokemon.AbstractPokemon;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.type.pokemon.IPokemonTypeVisitor;

public abstract class AbstractGrassPokemon extends AbstractPokemon {
    /**
     * Creates a new pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    AbstractGrassPokemon(String cardName, int id, int hp, AbilityContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public void receiveFirePokemonAttack(IAttack anAttack) {
        super.receiveWeaknessPokemonTypeAttack(anAttack);
    }

    @Override
    public void receiveWaterPokemonAttack(IAttack anAttack) {
        super.receiveResistantPokemonTypeAttack(anAttack);
    }

    @Override
    public void attack(IPokemon other) {
        other.receiveGrassPokemonAttack(super.getActiveAttack());
    }

    @Override
    public void accept(IPokemonTypeVisitor v) {
        v.visitGrassPokemon(this);
    }

}
