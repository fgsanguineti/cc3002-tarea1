package cc3002;

import cc3002.pokemon.IPokemon;
import cc3002.trainercards.ObjectCard;
import cc3002.visitor.ability.PlayAbilityVisitor;
import cc3002.visitor.card.PlayCardVisitor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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
    private ArrayList<ICard> prizeCards;
    private String playerName;
    private IPokemon selectedPokemon;
    private Trainer opponent;
    private ObjectCard associatedObject;
    private PokemonGameController pokemonGameController;
    private ICard selectedCard;

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
        this.prizeCards = new ArrayList<>();
        this.playerName = playerName;
        this.opponent = null;
        this.pokemonGameController = null;
        this.selectedCard = null;
    }

    /**
     * Returns the player's name.
     * @return String with the player's name.
     */
    String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the Controller object of the Game. Return null otherwise.
     *
     * @return PokemonGameController object with the current game.
     */
    public PokemonGameController getPokemonGameController() {
        return this.pokemonGameController;
    }

    /**
     * Tells the Trainer who control the game behavior.
     * @param pokemonGameController object with the current game.
     */
    void setPokemonGameController(PokemonGameController pokemonGameController) {
        this.pokemonGameController = pokemonGameController;
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
     * Set the trainer's hand
     * @param hand trainer's ArrayList with cards object.
     */
    void setHand(ArrayList<ICard> hand) {
        this.hand = hand;
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

    /**
     * Let the player interact with his opponent and his cards.
     * @return the player's opponent.
     */
    public Trainer getOpponent() {
        return opponent;
    }

    /**
     * Set the Trainer's opponent.
     * @param opponent the player's opponent.
     */
    public void setOpponent(Trainer opponent) {
        this.opponent = opponent;
    }

    /**
     * Select a card to performs in-game actions
     * @param aCard the card that wants to select.
     */
    void selectCard(ICard aCard) {
        this.selectedCard = aCard;
    }

    /**
     * Set the selected car as null.
     */
    void unSelectCard() {
        this.selectedCard = null;
    }

    /**
     * Let the Trainer and the proper game objects knows the selected card for performing an action.
     * @return the selected card.
     */
    ICard getSelectedCard() {
        return this.selectedCard;
    }

    /**
     * Lets the trainer to play any card in his hand.
     * @param aCard the ICard that wants to play.
     */
    public void play(ICard aCard) {
        this.selectCard(aCard);
        if (aCard.getTrainer() == null) aCard.setTrainer(this);
        PlayCardVisitor v = new PlayCardVisitor();
        aCard.accept(v);
    }

    /**
     * Lets a trainer performs an ability to the active enemy Pokemon.
     * Also attacks a pokemon, if the ability is an attack.
     * @param abilityNumber number of the Ability to use (1-4).
     */
    public void makeAnAbility(int abilityNumber) {
        this.activePokemon.setActiveAbility(abilityNumber);
        PlayAbilityVisitor v = new PlayAbilityVisitor();
        activePokemon.getActiveAbility().accept(v);
        this.activePokemon.unSelectActiveAbility();
        this.unSelectPokemon();
    }

    /**
     * Lets a trainer receive an attack from his opponent.
     * @param other Trainer that performs the attack.
     */
    public void receiveAnAttack(Trainer other) {
        other.getActivePokemon().attack(activePokemon);
        this.checkAndReplaceActiveDeadPokemon();
    }

    /**
     * This method checks if the active pokemon is alive. If not, replace for the first Pokemon in the bench.
     */
    public void checkAndReplaceActiveDeadPokemon() {
        if (!this.activePokemon.isAlive()) {
            activePokemon.discard(this);
            activePokemon = bench.get(0);
            bench.remove(0);
        }
    }

    /**
     * Gets the discard heap.
     * @return the trainer's discard heap.
     */
    public ArrayList<ICard> getDiscardHeap() {
        return this.discardHeap;
    }

    /**
     * This method gets the trainer's selected Pokemon to perform an action.
     * @return the selected Pokemon.
     */
    public IPokemon getSelectedPokemon() {
        return selectedPokemon;
    }

    /**
     * This method set the selected Pokemon to perform an action.
     * @param selectedPokemon for select.
     */
    public void setSelectedPokemon(IPokemon selectedPokemon) {
        this.selectedPokemon = selectedPokemon;
    }

    /**
     * This method null select the selected Pokemon.
     */
    public void unSelectPokemon() {
        this.selectedPokemon = null;
    }

    /**
     * This method returns the trainer's deck.
     * @return the trainer's deck.
     */
    public ArrayList<ICard> getDeck() {
        return this.deck;
    }

    /**
     * This method sets the Trainer's deck.
     */
    void setDeck(ArrayList<ICard> deck) {
        this.deck = deck;
    }

    /**
     * This method draw a card from the trainer's deck to the trainer's hand.
     */
    public void drawACard() {
        this.getHand().add(this.deck.get(0));
        this.deck.remove(0);
    }

    /**
     * This method flips a coin to performs effects.
     * @return a String with the result of the coin flipping.
     */
    public String flipACoin() {
        Random coin = new Random();
        int result = coin.nextInt(2);
        if (result == 0) return "Head";
        return "Tails";
    }

    /**
     * This method returns the prizes.
     * @return an ArrayList with the trainer's prize cards.
     */
    public ArrayList<ICard> getPrizeCards() {
        return this.prizeCards;
    }

    /**
     * This method add one card from the deck to the prizes.
     */
    public void addCardToPrizeCards() {
        if (this.prizeCards.size() < 6) {
            this.prizeCards.add(this.deck.get(0));
            this.deck.remove(0);
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
                Objects.equals(getBench(), trainer.getBench()) &&
                Objects.equals(getHand(), trainer.getHand()) &&
                Objects.equals(deck, trainer.deck) &&
                Objects.equals(discardHeap, trainer.discardHeap) &&
                Objects.equals(prizeCards, trainer.prizeCards) &&
                Objects.equals(getPlayerName(), trainer.getPlayerName());
    }
}