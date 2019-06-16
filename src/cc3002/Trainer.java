package cc3002;

import cc3002.pokemontypes.IPokemon;
import cc3002.visitor.ability.PlayAbilityVisitor;
import cc3002.visitor.card.PlayCardVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class creates a new Trainer object.
 *
 * @author F. Giovanni Sanguineti
 */
public class Trainer {
    private IPokemon activePokemon;
    private ArrayList<IPokemon> bench;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> discardHeap;
    private ICard[] prizeCards;
    private String playerName;
    private IPokemon selectedPokemon;
    private Trainer opponent;

    /**
     * Constructor that creates the Trainer.
     * @param playerName String with the player's name.
     */
    public Trainer(String playerName) {
        this.activePokemon = null;
        this.bench = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.discardHeap = new ArrayList<>();
        this.prizeCards = new ICard[6];
        this.playerName = playerName;
        this.opponent = null;
    }

    /**
     * Returns the player's name.
     * @return String with the player's name.
     */
    String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the trainer's active Pokemon.
     * @return the active Pokemon object.
     */
    public IPokemon getActivePokemon() {
        return activePokemon;
    }
    /**
     * Set the trainer's active Pokemon.
     *
     * @param aPokemon that wants to activate.
     */
    public void setActivePokemon(IPokemon aPokemon) {
        this.activePokemon = aPokemon;
    }

    /** Gives the trainer's hand
     * @return the trainer's hand object.
     */
    public ArrayList<ICard> getHand() {
        return hand;
    }

    /**
     * Add a card to the trainer's hand.
     * @param aCard the card to add in the hand.
     */
    public void addCardToHand(ICard aCard) {
        hand.add(aCard);
    }

    /**
     * Get the player's bench.
     * @return the player's bench object.
     */
    public ArrayList<IPokemon> getBench() {
        return bench;
    }


    public Trainer getOpponent() {
        return opponent;
    }

    public void setOpponent(Trainer opponent) {
        this.opponent = opponent;
    }

    /**
     * Lets the trainer to play a card.
     * @param aCard the ICard that wants to play.
     */
    public void play(ICard aCard) {
        hand.remove(aCard);
        aCard.setTrainer(this);
        PlayCardVisitor v = new PlayCardVisitor();
        aCard.accept(v);
    }
    /**
     * Lets a trainer performs an attack to the active enemy Pokemon
     * @param abilityNumber number of the Pokemon attack (1-4).
     */

    public void makeAnAbility(int abilityNumber) {
        this.activePokemon.setActiveAbility(abilityNumber);
        PlayAbilityVisitor v = new PlayAbilityVisitor();
        activePokemon.getActiveAbility().accept(v);
        this.activePokemon.unSelectActiveAbility();
    }

    public void receiveAnAttack(Trainer other) {
        other.getActivePokemon().attack(activePokemon);
        if (!this.activePokemon.isAlive()) {
            activePokemon.discard(this);
            activePokemon = bench.get(0);
            bench.remove(0);

        }
    }

    public ArrayList<ICard> getDiscardHeap() {
        return this.discardHeap;
    }

    public IPokemon getSelectedPokemon() {
        return selectedPokemon;
    }

    public void setSelectedPokemon(IPokemon selectedPokemon) {
        this.selectedPokemon = selectedPokemon;
    }

    public void unselectPokemon() {
        this.selectedPokemon = null;
    }
    /**
     * Compares the Trainer with another Trainer.
     *
     * @param o Another Trainer .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(getActivePokemon(), trainer.getActivePokemon()) &&
                Objects.equals(getBench(), trainer.getBench()) &&
                Objects.equals(getHand(), trainer.getHand()) &&
                Objects.equals(deck, trainer.deck) &&
                Objects.equals(discardHeap, trainer.discardHeap) &&
                Arrays.equals(prizeCards, trainer.prizeCards) &&
                Objects.equals(getPlayerName(), trainer.getPlayerName());
    }

}