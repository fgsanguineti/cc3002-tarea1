package cc3002;

import cc3002.energyTypes.*;

public abstract class AbstractPokemon implements IPokemon {

    private String cardName;
    private int id;
    private int hp;
    private AttackContainer attackList;
    private Attack activeAttack;
    private EnergyContainer pokemonEnergy;

    public AbstractPokemon(String cardName, int id, int hp, AttackContainer attackList) {
        this.cardName = cardName;
        this.id = id;
        this.hp = hp;
        this.attackList = attackList;
        this.activeAttack = attackList.getAttack(1);
        this.pokemonEnergy = new EnergyContainer(0, 0, 0, 0, 0, 0);
    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public void playCard(Trainer aTrainer) {
        aTrainer.playPokemon(this);
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getHP() {
        return this.hp;
    }

    @Override
    public Attack getActiveAttack() {
        return activeAttack;
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public void setActiveAttack(int index) {
        Attack aux = this.attackList.getAttack(index);
        if (aux.isEnoughEnergyToUseTheAttack(pokemonEnergy) && isAlive()) activeAttack = aux;
    }

    @Override
    public void receiveElectricEnergy(ElectricEnergy energy) {
        this.pokemonEnergy.addEnergy("Electric");
    }

    @Override
    public void receiveFightingEnergy(FightingEnergy energy) {
        this.pokemonEnergy.addEnergy("Fighting");
    }

    @Override
    public void receiveFireEnergy(FireEnergy energy) {
        this.pokemonEnergy.addEnergy("Fire");
    }

    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {
        this.pokemonEnergy.addEnergy("Grass");
    }

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {
        this.pokemonEnergy.addEnergy("Psychic");
    }

    @Override
    public void receiveWaterEnergy(WaterEnergy energy) {
        this.pokemonEnergy.addEnergy("Water");
    }

    @Override
    public int getElectricEnergyQuantity() {
        return this.pokemonEnergy.getElectric();
    }

    @Override
    public int getFightingEnergyQuantity() {
        return this.pokemonEnergy.getFighting();
    }

    @Override
    public int getFireEnergyQuantity() {
        return this.pokemonEnergy.getFire();
    }

    @Override
    public int getGrassEnergyQuantity() {
        return this.pokemonEnergy.getGrass();
    }

    @Override
    public int getPsychicEnergyQuantity() {
        return this.pokemonEnergy.getPsychic();
    }

    @Override
    public int getWaterEnergyQuantity() {
        return this.pokemonEnergy.getWater();
    }

    @Override
    public void receiveElectricPokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receiveFightingPokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receiveFirePokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receiveGrassPokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receivePsychicPokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receiveWaterPokemonAttack(Attack anAttack) {
        receiveAttack(anAttack);
    }

    @Override
    public void receiveWeaknessPokemonTypeAttack(Attack anAttack) {
        this.hp -= 2 * anAttack.getBaseDamage();
    }

    @Override
    public void receiveResistantPokemonTypeAttack(Attack anAttack) {
        int aux = anAttack.getBaseDamage() - 30;
        if (aux > 0) this.hp -= (anAttack.getBaseDamage() - 30);
    }

    @Override
    public abstract void attack(IPokemon other);

    private void receiveAttack(Attack anAttack) {
        this.hp -= anAttack.getBaseDamage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPokemon)) return false;
        AbstractPokemon that = (AbstractPokemon) o;
        return id == that.id &&
                hp == that.hp &&
                getCardName().equals(that.getCardName()) &&
                attackList.equals(that.attackList) &&
                getActiveAttack().equals(that.getActiveAttack()) &&
                pokemonEnergy.equals(that.pokemonEnergy);
    }

}
