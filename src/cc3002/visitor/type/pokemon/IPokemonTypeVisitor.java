package cc3002.visitor.type.pokemon;


import cc3002.pokemon.electric.AbstractElectricPokemon;
import cc3002.pokemon.fighting.AbstractFightingPokemon;
import cc3002.pokemon.fire.AbstractFirePokemon;
import cc3002.pokemon.grass.AbstractGrassPokemon;
import cc3002.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.pokemon.water.AbstractWaterPokemon;

public interface IPokemonTypeVisitor {
    void visitElectricPokemon(AbstractElectricPokemon electricPokemon);

    void visitFightingPokemon(AbstractFightingPokemon fightingPokemon);

    void visitFirePokemon(AbstractFirePokemon firePokemon);

    void visitGrassPokemon(AbstractGrassPokemon grassPokemon);

    void visitPsychicPokemon(AbstractPsychicPokemon psychicPokemon);

    void visitWaterPokemon(AbstractWaterPokemon waterPokemon);
}
