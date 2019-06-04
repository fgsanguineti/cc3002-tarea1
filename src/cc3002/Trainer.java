package cc3002;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class creates a new Trainer object.
 *
 * @author F. Giovanni Sanguineti
 */
class Trainer {
    private IPokemon activePokemon;
    private ArrayList<IPokemon> bench;
    private ArrayList<ICard> hand;
    private ArrayList<ICard> deck;
    private ArrayList<ICard> discardHeap;
    private ICard[] prizeCards;
    private String playerName;

    /**
     * Constructor that creates the Trainer.
     * @param playerName String with the player's name.
     */
    Trainer(String playerName) {
        this.activePokemon = null;
        this.bench = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.discardHeap = new ArrayList<>();
        this.prizeCards = new ICard[6];
        this.playerName = playerName;

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
    IPokemon getActivePokemon() {
        return activePokemon;
    }

    /** Gives the trainer's hand
     * @return the trainer's hand object.
     */
    ArrayList<ICard> getHand() {
        return hand;
    }

    /**
     * Add a cadt to the trainer's hand.
     * @param aCard the card to add in the hand.
     */
    void addCardToHand(ICard aCard) {
        hand.add(aCard);
    }

    /**
     * Get the player's bench.
     * @return the player's bench object.
     */
    ArrayList<IPokemon> getBench() {
        return bench;
    }

    /**
     * Lets the trainer to play a card.
     * @param aCard the ICard that wants to play.
     */
    void Play(ICard aCard) {
        hand.remove(aCard);
        aCard.playCard(this);
    }


    /**
     * Lets the trainer plays a Pokemon.
     * @param aPokemon the Pokemon that wants to be played.
     */
    void playPokemon(IPokemon aPokemon) {
        if (activePokemon == null) activePokemon = aPokemon;
        else if (bench.size() < 5) bench.add(aPokemon);
    }

    /**
     * Lets a trainer performs an attack to the active enemy Pokemon
     * @param attackNumber number of the Pokemon attack (1-4).
     * @param other The target trainer to attack.
     */
    void makeAnAttack(int attackNumber, Trainer other) {
        this.activePokemon.setActiveAttack(attackNumber);
        other.receiveAnAttack(this);
    }

    private void receiveAnAttack(Trainer other) {
        other.getActivePokemon().attack(activePokemon);
        if (!this.activePokemon.isAlive()) {
            activePokemon = bench.get(0);
            bench.remove(0);

        }
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
                getBench().equals(trainer.getBench()) &&
                getHand().equals(trainer.getHand()) &&
                getPlayerName().equals(trainer.getPlayerName());
    }

}