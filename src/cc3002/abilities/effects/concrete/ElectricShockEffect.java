package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;

public class ElectricShockEffect extends AbstractEffect {
    private int x;
    private String coinFlippingResult;
    public ElectricShockEffect(int x) {
        this.x = x;
    }

    @Override
    public void doEffect() {
        this.coinFlippingResult = this.getAssociatedAbility().getAssociatedPokemon().getTrainer().flipACoin();
        if (this.coinFlippingResult.equals("Tails")) this.getAssociatedAbility().getAssociatedPokemon().modifyHP(-x);
    }

    public String getLastCoinFlippingResult() {
        return this.coinFlippingResult;
    }
}
