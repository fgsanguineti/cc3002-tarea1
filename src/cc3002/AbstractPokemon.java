package cc3002;

import cc3002.energyTypes.*;

import java.util.ArrayList;

public abstract class AbstractPokemon implements IPokemon {

    private String cardName;
    private int id;
    private int hp;

    private ArrayList<ElectricEnergy> electric;
    private ArrayList<FightingEnergy> fighting;
    private ArrayList<FireEnergy> fire;
    private ArrayList<GrassEnergy> grass;
    private ArrayList<PsychicEnergy> psychic;
    private ArrayList<WaterEnergy> water;

    public AbstractPokemon(String cardName, int id, int hp) {
        this.cardName = cardName;
        this.id = id;
        this.hp = hp;
        electric = new ArrayList<>();
        fighting = new ArrayList<>();
        fire = new ArrayList<>();
        grass = new ArrayList<>();
        psychic = new ArrayList<>();
        water = new ArrayList<>();
    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public void playCard(Trainer aTrainer) {
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
    public void receiveElectricEnergy(ElectricEnergy energy) {
        this.electric.add(energy);
    }

    @Override
    public void receiveFightingEnergy(FightingEnergy energy) {
        this.fighting.add(energy);
    }

    @Override
    public void receiveFireEnergy(FireEnergy energy) {
        this.fire.add(energy);
    }

    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {
        this.grass.add(energy);
    }

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {
        this.psychic.add(energy);
    }

    @Override
    public void receiveWaterEnergy(WaterEnergy energy) { this.water.add(energy);

    }

    @Override
    public int getElectricEnergyQuantity() {
        return electric.size();
    }

    @Override
    public int getFightingEnergyQuantity() {
        return fighting.size();
    }

    @Override
    public int getFireEnergyQuantity() {
        return fire.size();
    }

    @Override
    public int getGrassEnergyQuantity() {
        return grass.size();
    }

    @Override
    public int getPsychicEnergyQuantity() {
        return psychic.size();
    }

    @Override
    public int getWaterEnergyQuantity() {
        return water.size();
    }
}
