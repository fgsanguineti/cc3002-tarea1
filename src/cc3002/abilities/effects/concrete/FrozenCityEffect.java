package cc3002.abilities.effects.concrete;

import cc3002.abilities.effects.AbstractEffect;
import cc3002.visitor.card.FrozenCityCardVisitor;
import cc3002.visitor.card.ICardVisitor;

public class FrozenCityEffect extends AbstractEffect {
    @Override
    public void doEffect() {
        ICardVisitor v = new FrozenCityCardVisitor();
        this.getAssociatedCard().getTrainer().getPokemonGameController().getSelectedCard().accept(v);
    }
}