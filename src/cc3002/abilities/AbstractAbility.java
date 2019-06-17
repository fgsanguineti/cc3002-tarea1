package cc3002.abilities;

import cc3002.abilities.effects.IEffect;
import cc3002.energies.EnergyContainer;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.ability.IAbilityVisitor;

import java.util.Objects;

/**
 * This class implements the IAbility interface.
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractAbility implements IAbility {
    private String name;
    private String description;
    private EnergyContainer costs;
    private IPokemon associatedPokemon;
    private IEffect effect;

    /**
     * Defines the basic behavior of a new ability.
     *
     * @param name        a String with the ability name.
     * @param description a short description of the ability.
     * @param costs       a EnergyContainer with the cost of the ability.
     * @param effect      the Effect of the card.
     */

    AbstractAbility(String name, String description, EnergyContainer costs, IEffect effect) {
        this.name = name;
        this.description = description;
        this.costs = costs;
        this.effect = effect;

    }

    /**
     * Returns the ability name.
     *
     * @return A String with the ability name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the ability description.
     *
     * @return A String with the ability description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the ability costs.
     *
     * @return a EnergyContainer with the ability costs.
     */
    @Override
    public EnergyContainer getCost() {
        return this.costs;
    }

    /**
     * Tells if a Pokemon has enough energy to performs an ability.
     *
     * @param aPokemon the target Pokemon.
     * @return true if the Pokemon has enough energy to perform the ability, false otherwise.
     */
    @Override
    public boolean isEnoughEnergyToUseTheAbility(IPokemon aPokemon) {
        EnergyContainer aux = this.getCost();
        EnergyContainer pokemonEnergies = aPokemon.getAllEnergyQuantity();
        return aux.getFighting() <= pokemonEnergies.getFighting() && aux.getElectric() <= pokemonEnergies.getElectric()
                && aux.getFire() <= pokemonEnergies.getFire() && aux.getGrass() <= pokemonEnergies.getGrass() &&
                aux.getPsychic() <= pokemonEnergies.getPsychic() && aux.getWater() <= pokemonEnergies.getWater();
    }

    /**
     * Accept a IAbilityVisitor to perform an operation with the Ability.
     *
     * @param v the Visitor that performs the operation.
     */
    @Override
    public abstract void accept(IAbilityVisitor v);

    /**
     * Returns the pokemon associated to an Ability instance.
     *
     * @return the associated Pokemon.
     */
    @Override
    public IPokemon getAssociatedPokemon() {
        return this.associatedPokemon;
    }

    /**
     * Set the pokemon associated to an Ability instance.
     *
     * @param aPokemon to associate with the ability.
     */
    @Override
    public void setAssociatedPokemon(IPokemon aPokemon) {
        this.associatedPokemon = aPokemon;
    }

    /**
     * Return the Effect of the Ability.
     * @return the Effect..
     */
    @Override
    public IEffect getEffect() {
        return this.effect;
    }

    /**
     * {@inheritDoc}
     * @param o the object to compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAbility)) return false;
        AbstractAbility that = (AbstractAbility) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(costs, that.costs);
    }

}
