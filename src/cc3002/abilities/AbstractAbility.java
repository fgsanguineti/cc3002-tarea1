package cc3002.abilities;

import cc3002.abilityvisitors.IAbilityVisitor;
import cc3002.energytypes.EnergyContainer;
import cc3002.pokemontypes.IPokemon;

import java.util.Objects;

public abstract class AbstractAbility implements IAbility {
    private String name;
    private String description;
    private EnergyContainer costs;
    private IPokemon associatedPokemon;

    /**
     * Creates a new ability.
     *
     * @param name        a String with the ability name.
     * @param description a short description of the ability.
     * @param costs       a EnergyContainer with the cost of the ability.
     */

    AbstractAbility(String name, String description, EnergyContainer costs) {
        this.name = name;
        this.description = description;
        this.costs = costs;
    }

    /**
     * Returns the attack name.
     *
     * @return A String with the attack name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the attack description.
     *
     * @return A String with the attack description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the attack costs.
     *
     * @return a EnergyContainer with the attack costs.
     */
    @Override
    public EnergyContainer getCost() {
        return this.costs;
    }


    /**
     * Tells if a Pokemon has enough energy to performs an attack.
     *
     * @param aPokemon the target Pokemon.
     * @return true if the Pokemon has enough energy to perform the attack, false otherwise.
     */
    @Override
    public boolean isEnoughEnergyToUseTheAbility(IPokemon aPokemon) {
        EnergyContainer aux = this.getCost();
        EnergyContainer pokemonEnergies = aPokemon.getAllEnergyQuantity();
        return aux.getFighting() <= pokemonEnergies.getFighting() && aux.getElectric() <= pokemonEnergies.getElectric()
                && aux.getFire() <= pokemonEnergies.getFire() && aux.getGrass() <= pokemonEnergies.getGrass() &&
                aux.getPsychic() <= pokemonEnergies.getPsychic() && aux.getWater() <= pokemonEnergies.getWater();
    }

    public abstract void accept(IAbilityVisitor v);

    @Override
    public IPokemon getAssociatedPokemon() {
        return this.associatedPokemon;
    }

    @Override
    public void setAssociatedPokemon(IPokemon aPokemon) {
        this.associatedPokemon = aPokemon;
    }

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
