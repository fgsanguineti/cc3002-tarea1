package cc3002.abilities.effects.concrete;

import cc3002.ICard;
import cc3002.Trainer;
import cc3002.abilities.effects.AbstractEffect;

import java.util.Collections;
import java.util.Iterator;

public class NEffect extends AbstractEffect {
    @Override
    public void doEffect() {
        Trainer theTrainer = getAssociatedCard().getTrainer();
        Trainer opponentTrainer = theTrainer.getOpponent();
        int prizeCardsQuantity = theTrainer.getPrizeCards().size();
        int opponentPrizeCardsQuantity = opponentTrainer.getPrizeCards().size();

        Iterator<ICard> iter = theTrainer.getHand().iterator();
        while (iter.hasNext()) {
            theTrainer.getDeck().add(iter.next());
            iter.remove();
        }
        Collections.shuffle(theTrainer.getDeck());

        iter = opponentTrainer.getHand().iterator();
        while (iter.hasNext()) {
            opponentTrainer.getDeck().add(iter.next());
            iter.remove();
        }
        Collections.shuffle(opponentTrainer.getDeck());
        for (int i = 0; i < prizeCardsQuantity; i++) {
            theTrainer.drawACard();
        }
        for (int i = 0; i < opponentPrizeCardsQuantity; i++) {
            opponentTrainer.drawACard();
        }

    }
}
