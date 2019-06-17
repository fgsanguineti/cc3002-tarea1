package cc3002.trainercards;

import cc3002.abilities.effects.concrete.NEffect;

class N extends SupportCard {
    N() {
        super("N", "Shuffle your hand in your deck and draw the quantity of" +
                "your prizes left", new NEffect());
    }
}
