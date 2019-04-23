package cc3002;

import cc3002.energyTypes.*;

import java.util.Hashtable;

public abstract class AbstractPokemon implements IPokemon {

    private String cardName;
    private int id;
    private int hp;
    private Hashtable<IEnergy,Integer> energies;

    public AbstractPokemon(String cardName, int id, int hp) {
        this.cardName = cardName;
        this.id = id;
        this.hp = hp;
        this.energies = new Hashtable<>();

    }

    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public void playCard() {

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

    }

    @Override
    public void receiveFightingEnergy(FightingEnergy energy) {

    }

    @Override
    public void receiveFireEnergy(FireEnergy energy) {

    }

    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {

    }

    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {

    }

    @Override
    public void receiveWaterEnergy(WaterEnergy energy) {

    }
    public void receiveEnergy(IEnergy anIEnergy){}


}
