package cc3002;

import cc3002.visitor.card.ICardVisitor;

/**
 * Common interface for all the cards. Every card have a card name and should be able to be played by a Trainer
 * Also accepts a CardVisitor.
 * @author F. Giovanni Sanguineti Cortés
 */
public interface ICard {
    String getCardName();
    void accept(ICardVisitor v);
    Trainer getTrainer();
    void setTrainer(Trainer aTrainer);
    void discard(Trainer aTrainer);
}
