package cc3002.trainercards;

import cc3002.abilities.effects.concrete.FrozenCityEffect;

public class FrozenCity extends StadiumCard {
    private int x;

    public FrozenCity(int x) {
        super("Frozen City", "Whenever any player plays an Energy from his or her hand to one " +
                "of his Pokemon, put X damage counters on that Pokemon", new FrozenCityEffect(), x);
    }
}
