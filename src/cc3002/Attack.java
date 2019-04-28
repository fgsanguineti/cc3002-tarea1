package cc3002;

public class Attack implements IAbility {
    private String name;
    private String description;
    private int baseDamage;
    private EnergyContainer costs;

    public Attack(String name, String description, int baseDamage, EnergyContainer costs) {
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.costs = costs;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public EnergyContainer getCost() {
        return this.costs;
    }

    int getBaseDamage() {
        return this.baseDamage;
    }

    boolean isEnoughEnergyToUseTheAttack(EnergyContainer pokemonEnergies) {
        EnergyContainer aux = this.getCost();
        return aux.getFighting() <= pokemonEnergies.getFighting() && aux.getElectric() <= pokemonEnergies.getElectric()
                && aux.getFire() <= pokemonEnergies.getFire() && aux.getGrass() <= pokemonEnergies.getGrass() &&
                aux.getPsychic() <= pokemonEnergies.getPsychic() && aux.getWater() <= pokemonEnergies.getWater();
    }
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
