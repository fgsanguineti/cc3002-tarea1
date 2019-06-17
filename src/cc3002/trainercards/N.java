package cc3002.trainercards;

import cc3002.abilities.effects.concrete.NEffect;

/**
 * This class creates a new N SupportCard.
 * Shuffle your hand in your deck and draw the quantity of your prizes left
 *
 * @author F. Giovanni Sanguineti
 */
public class N extends SupportCard {
    /**
     * Constructor that creates the N.
     */
    public N() {
        super("N", "Shuffle your hand in your deck and draw the quantity of" +
                "your prizes left", new NEffect(), 0);
    }
}
