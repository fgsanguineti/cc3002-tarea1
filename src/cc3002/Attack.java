package cc3002;


/**
 * This class implements the IAttack interface.
 *
 * @author F. Giovanni Sanguineti
 */
public class Attack implements IAttack {
    private String name;
    private String description;
    private int baseDamage;
    private EnergyContainer costs;

    /**
     * Creates a new attack.
     * @param name a String with the attack name.
     * @param description a short description of the attack.
     * @param baseDamage a int value that represent the damage that the attack performs.
     * @param costs a EnergyContainer with the cost of the attack.
     */
    public Attack(String name, String description, int baseDamage, EnergyContainer costs) {
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
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
     * Returns the base damage of the attack.
     *
     * @return A int with the base damage of the attack.
     */
    public int getBaseDamage() {
        return this.baseDamage;
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
        if (!(o instanceof Attack)) return false;
        Attack attack = (Attack) o;
        return baseDamage == attack.baseDamage &&
                name.equals(attack.name) &&
                description.equals(attack.description) &&
                costs.equals(attack.costs);
    }

}
