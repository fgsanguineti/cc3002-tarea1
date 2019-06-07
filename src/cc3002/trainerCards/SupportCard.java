package cc3002.trainerCards;
import cc3002.effectVisitor.SupportEffectVisitor;
import java.util.ArrayList;

public class SupportCard  extends AbstractTrainerCard{
    private ArrayList<SupportEffectVisitor> effects;
    SupportCard(String cardName, String description) {
        super(cardName, description);
    }
}
