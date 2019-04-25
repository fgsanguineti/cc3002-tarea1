package cc3002;
import cc3002.energyTypes.*;

public interface IPokemon extends ICard{

    int getID();
    int getHP();
    void receiveElectricEnergy(ElectricEnergy energy);
    void receiveFightingEnergy(FightingEnergy energy);
    void receiveFireEnergy(FireEnergy energy);
    void receiveGrassEnergy(GrassEnergy energy);
    void receivePsychicEnergy(PsychicEnergy energy);
    void receiveWaterEnergy(WaterEnergy energy);

    int getElectricEnergyQuantity();
    int getFightingEnergyQuantity();
    int getFireEnergyQuantity();
    int getGrassEnergyQuantity();
    int getPsychicEnergyQuantity();
    int getWaterEnergyQuantity();

    void receiveElectricPokemonAttack(Attack anAttack);
    void receiveFightingPokemonAttack(Attack anAttack);
    void receiveFirePokemonAttack(Attack anAttack);
    void receiveGrassPokemonAttack(Attack anAttack);
    void receivePsychicPokemonAttack(Attack anAttack);
    void receiveWaterPokemonAttack(Attack anAttack);

}
