package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;
import cc3002.pokemontypes.IPokemon;

public class PotionEffect extends AbstractEffect {
    private int maximumCountersToIncrease;

    public PotionEffect(int x) {
        this.maximumCountersToIncrease = x;
    }

    @Override
    public void doEffect() {
        IPokemon selectedPokemon = super.getAssociatedCard().getTrainer().getActivePokemon();
        int totalDamageCounters = (selectedPokemon.getInitialHP() - selectedPokemon.getHP()) / 10;
        if (totalDamageCounters > maximumCountersToIncrease) selectedPokemon.modifyHP(maximumCountersToIncrease * 10);
        else selectedPokemon.modifyHP(totalDamageCounters * 10);
        super.getAssociatedCard().discard(super.getAssociatedCard().getTrainer());
    }
}
