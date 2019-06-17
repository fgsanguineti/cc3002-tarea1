package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;

/**
 * This class creates a new ElectricShockEffect.
 *
 * @author F. Giovanni Sanguineti
 */
public class ElectricShockEffect extends AbstractEffect {
    private int x;
    private String coinFlippingResult;

    /**
     * Constructor that creates the ElectricShockEffect.
     *
     * @param x The counters to do the effect..
     */
    public ElectricShockEffect(int x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEffect() {
        this.coinFlippingResult = this.getAssociatedAbility().getAssociatedPokemon().getTrainer().flipACoin();
        if (this.coinFlippingResult.equals("Tails")) this.getAssociatedAbility().getAssociatedPokemon().modifyHP(-x);
    }

    /**
     * Returns the result of the las coin flipping.
     *
     * @return a String with the last flipping result.
     */
    public String getLastCoinFlippingResult() {
        return this.coinFlippingResult;
    }
}
