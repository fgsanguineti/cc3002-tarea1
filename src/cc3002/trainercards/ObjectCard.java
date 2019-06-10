package cc3002.trainercards;

import cc3002.effectVisitor.ObjectEffectVisitor;

import java.util.ArrayList;

public class ObjectCard extends AbstractTrainerCard {

    private ArrayList<ObjectEffectVisitor> effects;
    ObjectCard(String cardName, String description, ArrayList<ObjectEffectVisitor> effects) {
        super(cardName, description);
        this.effects = effects;
    }
}
