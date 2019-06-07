package cc3002.trainerCards;

import cc3002.effectVisitor.StadiumEffectVisitor;

import java.util.ArrayList;

public class StadiumCard extends AbstractTrainerCard {
    private ArrayList<StadiumEffectVisitor> effects;
    StadiumCard(String cardName, String description, ArrayList<StadiumEffectVisitor> effects) {
        super(cardName, description);
        this.effects = effects;
    }
}
