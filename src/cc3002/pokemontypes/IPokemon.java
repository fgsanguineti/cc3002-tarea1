package cc3002.pokemontypes;

import cc3002.ICard;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.IAbility;
import cc3002.abilities.IAttack;
import cc3002.energytypes.*;
import cc3002.visitor.type.pokemon.IPokemonTypeVisitor;

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

    IAbility getActiveAbility();

    void setActiveAbility(int index);

    void unSelectActiveAbility();

    IAttack getActiveAttack();

    void setActiveAttack(IAttack activeAttack);

    int getInitialHP();

    void modifyHP(int x);

    AbilityContainer getAbilityList();

    EnergyContainer getAllEnergyQuantity();

    void setEnergyContainer(EnergyContainer aEnergyContainer);

    int getElectricEnergyQuantity();

    int getFightingEnergyQuantity();

    int getFireEnergyQuantity();

    int getGrassEnergyQuantity();

    int getPsychicEnergyQuantity();

    int getWaterEnergyQuantity();



    void receiveElectricEnergy(ElectricEnergy energy);

    void receiveFightingEnergy(FightingEnergy energy);

    void receiveFireEnergy(FireEnergy energy);

    void receiveGrassEnergy(GrassEnergy energy);

    void receivePsychicEnergy(PsychicEnergy energy);

    void receiveWaterEnergy(WaterEnergy energy);

    void receiveAttack(IAttack anAttack);

    void receiveElectricPokemonAttack(IAttack anAttack);

    void receiveFightingPokemonAttack(IAttack anAttack);

    void receiveFirePokemonAttack(IAttack anAttack);

    void receiveGrassPokemonAttack(IAttack anAttack);

    void receivePsychicPokemonAttack(IAttack anAttack);

    void receiveWaterPokemonAttack(IAttack anAttack);

    void receiveWeaknessPokemonTypeAttack(IAttack anAttack);

    void receiveResistantPokemonTypeAttack(IAttack anAttack);

    void attack(IPokemon other);

    void accept(IPokemonTypeVisitor v);

}
