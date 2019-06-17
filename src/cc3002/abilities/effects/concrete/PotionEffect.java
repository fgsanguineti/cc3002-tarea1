package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;
import cc3002.pokemon.IPokemon;

/**
 * This class creates a new ElectricShockEffect.
 *
 * @author F. Giovanni Sanguineti
 */
public class PotionEffect extends AbstractEffect {
    private int maximumCountersToIncrease;

    /**
     * Constructor that creates the PotionEffect.
     *
     * @param x The counters to do the effect..
     */
    public PotionEffect(int x) {
        this.maximumCountersToIncrease = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEffect() {
        IPokemon selectedPokemon = super.getAssociatedCard().getTrainer().getSelectedPokemon();
        int totalDamageCounters = (selectedPokemon.getInitialHP() - selectedPokemon.getHP()) / 10;
        if (totalDamageCounters > maximumCountersToIncrease) selectedPokemon.modifyHP(maximumCountersToIncrease * 10);
        else selectedPokemon.modifyHP(totalDamageCounters * 10);
        super.getAssociatedCard().discard(super.getAssociatedCard().getTrainer());
    }
}
