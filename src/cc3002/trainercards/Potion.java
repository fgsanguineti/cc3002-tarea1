package cc3002.trainercards;

import cc3002.abilities.effects.concrete.PotionEffect;

public class Potion extends ObjectCard {
    public Potion(int x) {
        super("Potion", "Recovers up to X damage counters of the selected Pokemon",
                new PotionEffect(x));
    }
}
