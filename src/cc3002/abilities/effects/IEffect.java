package cc3002.abilities.effects;

import cc3002.abilities.IAbility;

public interface IEffect {
    IAbility getAssociatedAbility();

    void setAssociatedAbility(IAbility anAbility);

    void doEffect();
}

