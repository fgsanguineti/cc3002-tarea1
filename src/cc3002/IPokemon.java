package cc3002;
import cc3002.energyTypes.*;

public interface IPokemon extends ICard{
    String CARD_TYPE = "Pokemon";
    int getID();
    int getHP();
    void receiveElectricEnergy(ElectricEnergy energy);
    void receiveFightingEnergy(FightigEnergy energy);
    void receiveFireEnergy(FireEnergy energy);
    void receiveGrassEnergy(GrassEnergy energy);
    void receivePsychicEnergy(PsychicEnergy energy);
    void receiveWaterEnergy(WaterEnergy energy);
}
