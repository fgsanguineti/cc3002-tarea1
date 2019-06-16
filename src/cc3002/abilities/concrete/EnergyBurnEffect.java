package cc3002.abilities.concrete;

import cc3002.abilities.effects.AbstractEffect;
import cc3002.pokemontypes.IPokemon;
import cc3002.visitor.type.pokemon.EnergyBurnVisitor;

public class EnergyBurnEffect extends AbstractEffect {
    @Override
    public void doEffect() {
        IPokemon thePokemon = this.getAssociatedAbility().getAssociatedPokemon();
        EnergyBurnVisitor v = new EnergyBurnVisitor();
        thePokemon.accept(v);
    }
}
