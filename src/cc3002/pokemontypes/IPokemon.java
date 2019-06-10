package cc3002.pokemontypes;

import cc3002.Abilities.Attack;
import cc3002.Abilities.AttackContainer;
import cc3002.ICard;
import cc3002.energyTypes.*;

/**
 * Common interface for all the Pokemon, that also is a card. Besides the cards attributes, a Pokemon also has a ID,
 * an HP value, an alive status, an attack list, an active attack and a energy number for each type. A Pokemon should be able to
 * receive a Energy Card of every class, receive an attack of every Pokemon kind and should be able to attack a
 * another Pokemon.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IPokemon extends ICard {

    int getID();

    int getHP();

    boolean isAlive();

    Attack getActiveAttack();

    AttackContainer getAttackList();

    EnergyContainer getAllEnergyQuantity();

    void setEnergyContainer(EnergyContainer aEnergyContainer);

    int getElectricEnergyQuantity();

    int getFightingEnergyQuantity();

    int getFireEnergyQuantity();

    int getGrassEnergyQuantity();

    int getPsychicEnergyQuantity();

    int getWaterEnergyQuantity();

    void setActiveAttack(int index);

    void receiveElectricEnergy(ElectricEnergy energy);

    void receiveFightingEnergy(FightingEnergy energy);

    void receiveFireEnergy(FireEnergy energy);

    void receiveGrassEnergy(GrassEnergy energy);

    void receivePsychicEnergy(PsychicEnergy energy);

    void receiveWaterEnergy(WaterEnergy energy);

    void receiveAttack(Attack anAttack);

    void receiveElectricPokemonAttack(Attack anAttack);

    void receiveFightingPokemonAttack(Attack anAttack);

    void receiveFirePokemonAttack(Attack anAttack);

    void receiveGrassPokemonAttack(Attack anAttack);

    void receivePsychicPokemonAttack(Attack anAttack);

    void receiveWaterPokemonAttack(Attack anAttack);

    void receiveWeaknessPokemonTypeAttack(Attack anAttack);

    void receiveResistantPokemonTypeAttack(Attack anAttack);

    void attack(IPokemon other);

}
