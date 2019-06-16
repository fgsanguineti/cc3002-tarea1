package cc3002.abilities.effects;

import cc3002.abilities.IAbility;

public abstract class AbstractEffect implements IEffect {
    private IAbility associatedAbility;

    @Override
    public IAbility getAssociatedAbility() {
        return this.associatedAbility;
    }

    @Override
    public void setAssociatedAbility(IAbility anAbility) {
        this.associatedAbility = anAbility;
    }

    @Override
    public abstract void doEffect();
}
