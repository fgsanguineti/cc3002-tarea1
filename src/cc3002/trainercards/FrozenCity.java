package cc3002.trainercards;

import cc3002.abilities.effects.concrete.FrozenCityEffect;

/**
 * This class creates a new FrozenCity StadiumCard.
 * Whenever any player plays an Energy from his or her hand to one
 * of his Pokemon, put X damage counters on that Pokemon.
 *
 * @author F. Giovanni Sanguineti
 */
public class FrozenCity extends StadiumCard {
    private int x;

    /**
     * Constructor that creates the ElectricShockEffect.
     *
     * @param x The counters to do the effect..
     */
    public FrozenCity(int x) {
        super("Frozen City", "Whenever any player plays an Energy from his or her hand to one " +
                "of his Pokemon, put X damage counters on that Pokemon", new FrozenCityEffect(), x);
    }
}
