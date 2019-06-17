package cc3002.trainercards;

import cc3002.abilities.effects.IEffect;

public interface ITrainerCard {
    String getDescription();
    void doSelectedEffect();

    IEffect getEffect();
}
