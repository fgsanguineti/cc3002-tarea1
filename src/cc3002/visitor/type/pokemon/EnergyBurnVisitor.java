package cc3002.visitor.type.pokemon;

import cc3002.energies.EnergyContainer;
import cc3002.pokemon.electric.AbstractElectricPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

public class EnergyBurnVisitor implements IPokemonTypeVisitor {
    @Override
    public void visitElectricPokemon(AbstractElectricPokemon electricPokemon) {
        int i = electricPokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(i, 0, 0, 0, 0, 0);
        electricPokemon.setEnergyContainer(newEnergyContainer);
    }

    @Override
    public void visitFightingPokemon(AbstractFightingPokemon fightingPokemon) {
        int i = fightingPokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(0, i, 0, 0, 0, 0);
        fightingPokemon.setEnergyContainer(newEnergyContainer);
    }

    @Override
    public void visitFirePokemon(AbstractFirePokemon firePokemon) {
        int i = firePokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(0, 0, i, 0, 0, 0);
        firePokemon.setEnergyContainer(newEnergyContainer);

    }

    @Override
    public void visitGrassPokemon(AbstractGrassPokemon grassPokemon) {
        int i = grassPokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(0, 0, 0, i, 0, 0);
        grassPokemon.setEnergyContainer(newEnergyContainer);

    }

    @Override
    public void visitPsychicPokemon(AbstractPsychicPokemon psychicPokemon) {
        int i = psychicPokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(0, 0, 0, i, 0, 0);
        psychicPokemon.setEnergyContainer(newEnergyContainer);
    }

    @Override
    public void visitWaterPokemon(AbstractWaterPokemon waterPokemon) {
        int i = waterPokemon.getAllEnergyQuantity().getTotalEnergyQuantity();
        EnergyContainer newEnergyContainer = new EnergyContainer(0, 0, 0, i, 0, 0);
        waterPokemon.setEnergyContainer(newEnergyContainer);
    }
}
