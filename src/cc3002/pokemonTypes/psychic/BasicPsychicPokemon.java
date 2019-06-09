package cc3002.pokemonTypes.psychic;

import cc3002.pokemonTypes.AbstractPokemon;
import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.pokemonTypes.IPokemon;

public class BasicPsychicPokemon extends AbstractPokemon {
    /**
     * Creates a new psychic pokemon.
     *
     * @param cardName   The name of the card.
     * @param id         The card ID.
     * @param hp         The HP of the pokemon
     * @param attackList a list with the attacks of the Pokemon, that can be up to 4.
     */
    public BasicPsychicPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        super(cardName, id, hp, attackList);
    }

    @Override
    public String getCardName() {
        return super.getCardName();
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

    /**
     * {@inheritDoc}
     *
     * @param o The target Pokemon object
     * @return True if are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicPsychicPokemon)) return false;
        BasicPsychicPokemon that = (BasicPsychicPokemon) o;
        return this.getID() == that.getID() &&
                this.getHP() == that.getHP() &&
                getCardName().equals(that.getCardName()) &&
                this.getAttackList().equals(that.getAttackList()) &&
                getActiveAttack().equals(that.getActiveAttack()) &&
                this.getAllEnergyQuantity().equals(that.getAllEnergyQuantity());
    }
}
