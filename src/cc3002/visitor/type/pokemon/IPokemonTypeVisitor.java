package cc3002.visitor.type.pokemon;


import cc3002.pokemontypes.electric.AbstractElectricPokemon;
import cc3002.pokemontypes.fighting.AbstractFightingPokemon;
import cc3002.pokemontypes.fire.AbstractFirePokemon;
import cc3002.pokemontypes.grass.AbstractGrassPokemon;
import cc3002.pokemontypes.psychic.AbstractPsychicPokemon;
import cc3002.pokemontypes.water.AbstractWaterPokemon;

public interface IPokemonTypeVisitor {
    void visitElectricPokemon(AbstractElectricPokemon electricPokemon);

    void visitFightingPokemon(AbstractFightingPokemon fightingPokemon);

    void visitFirePokemon(AbstractFirePokemon firePokemon);

    void visitGrassPokemon(AbstractGrassPokemon grassPokemon);

    void visitPsychicPokemon(AbstractPsychicPokemon psychicPokemon);

    void visitWaterPokemon(AbstractWaterPokemon waterPokemon);
}
