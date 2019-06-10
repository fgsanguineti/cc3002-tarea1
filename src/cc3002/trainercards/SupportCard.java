package cc3002.trainercards;

import cc3002.effectVisitor.SupportEffectVisitor;

import java.util.ArrayList;

public class SupportCard  extends AbstractTrainerCard{
    private ArrayList<SupportEffectVisitor> effects;

    SupportCard(String cardName, String description, ArrayList<SupportEffectVisitor> effects) {
        super(cardName, description);
        this.effects = effects;
    }
}
