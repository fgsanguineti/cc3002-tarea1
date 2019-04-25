package cc3002;

public class Attack implements IAbility {
    private String name;
    private String description;
    private int baseDamaege;
    private EnergyContainer costs;

    protected Attack(String name, String description, int baseDamage, EnergyContainer costs){
        this.name = name;
        this.description = description;
        this.baseDamaege = baseDamage;
        this.costs = costs;
    }
    @Override
    public String getName() {
        return this.name;}
    @Override
    public String getDescription() {
        return this.description;
    }
    @Override
    public EnergyContainer getCost() {
        return this.costs;
    }
    int getBaseDamage(){
        return this.baseDamaege;
    }
}
