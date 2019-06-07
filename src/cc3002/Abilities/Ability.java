package cc3002.Abilities;

import cc3002.energyTypes.EnergyContainer;
import cc3002.pokemonTypes.IPokemon;

/**
 * This class contents implements the IAbility interface
 *
 * @author F. Giovanni Sanguineti
 */
public class Ability implements IAbility {
    private String name;
    private String description;
    private EnergyContainer costs;

    /**
     * Creates a new ability.
     * @param name a String with the ability name.
     * @param description a short description of the ability.
     * @param costs a EnergyContainer with the cost of the ability.
     */
    Ability(String name, String description, EnergyContainer costs) {
        this.name = name;
        this.description = description;
        this.costs = costs;
    }

    /** Returns the attack name.
     * @return A String with the attack name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /** Returns the attack description.
     * @return A String with the attack description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the attack costs.
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
    /**
     * Compares the Attack with another Attack.
     *
     * @param o Another Attack .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability ability = (Ability) o;
        return getName().equals(ability.getName()) &&
                getDescription().equals(ability.getDescription()) &&
                costs.equals(ability.costs);
    }
}
