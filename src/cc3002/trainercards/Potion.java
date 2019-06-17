package cc3002.trainercards;

import cc3002.abilities.effects.concrete.PotionEffect;

/**
 * This class creates a new Potion ObjectCard.
 * Recovers up to X damage counters of the selected Pokemon.
 *
 * @author F. Giovanni Sanguineti
 */
public class Potion extends ObjectCard {
    /**
     * Constructor that creates the Potion.
     *
     * @param x The counters to do the effect..
     */
    public Potion(int x) {
        super("Potion", "Recovers up to X damage counters of the selected Pokemon",
                new PotionEffect(x), x);
    }
}
