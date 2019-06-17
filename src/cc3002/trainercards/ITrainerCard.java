package cc3002.trainercards;

import cc3002.abilities.effects.IEffect;

interface ITrainerCard {
    String getDescription();
    void doSelectedEffect();

    IEffect getEffect();
}
