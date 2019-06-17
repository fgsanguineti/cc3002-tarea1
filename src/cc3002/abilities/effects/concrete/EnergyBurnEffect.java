package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;
import cc3002.pokemon.IPokemon;
import cc3002.visitor.type.pokemon.EnergyBurnVisitor;

/**
 * This class creates a new EnergyBurnEffect.
 *
 * @author F. Giovanni Sanguineti
 */
public class EnergyBurnEffect extends AbstractEffect {
    /**
     * {@inheritDoc}
     */
    @Override
    public void doEffect() {
        IPokemon thePokemon = this.getAssociatedAbility().getAssociatedPokemon();
        EnergyBurnVisitor v = new EnergyBurnVisitor();
        thePokemon.accept(v);
    }
}
