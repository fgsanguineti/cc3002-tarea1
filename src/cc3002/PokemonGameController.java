package cc3002;

import cc3002.pokemon.IPokemon;
import cc3002.trainercards.StadiumCard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class controls the behavior and rules of the game and adds the logic of a turn.
 *
 * @author F. Giovanni Sanguineti
 */
public class PokemonGameController {
    private Trainer firstTrainer;
    private Trainer secondTrainer;
    private StadiumCard activeStadiumCard;
    private Trainer activeTurnPlayer;
    private boolean isAnEnergyPlayedInTurn;


    /**
     * Constructor that creates the Game Controller. Set the Trainers, his opponents, the GameController and the Decks.
     * Also, shuffle the decks.
     *
     * @param firstTrainer  The first trainer.
     * @param firstDeck     The first trainer's deck.
     * @param secondTrainer The another trainer.
     * @param secondDeck    The another trainer.
     */
    PokemonGameController(Trainer firstTrainer, ArrayList<ICard> firstDeck,
                          Trainer secondTrainer, ArrayList<ICard> secondDeck) {
        this.firstTrainer = firstTrainer;
        this.secondTrainer = secondTrainer;
        firstTrainer.setOpponent(secondTrainer);
        secondTrainer.setOpponent(firstTrainer);
        this.firstTrainer.setPokemonGameController(this);
        this.secondTrainer.setPokemonGameController(this);
        if (firstDeck.size() == 60) this.firstTrainer.setDeck(firstDeck);
        if (secondDeck.size() == 60) this.secondTrainer.setDeck(secondDeck);
        Collections.shuffle(this.firstTrainer.getDeck());
        Collections.shuffle(this.secondTrainer.getDeck());
    }

    /**
     * starts the game
     */
    void startGame() {
        initializePlayers();
        this.activeTurnPlayer = firstTrainer;
        this.isAnEnergyPlayedInTurn = false;
        this.activeStadiumCard = null;
        beginTurn();
    }

    /**
     * set all the cards owners. Then, draw cards for the hand and set the prizes.
     */
    private void initializePlayers() {
        for (ICard c : firstTrainer.getDeck()) {
            c.setTrainer(firstTrainer);
        }
        for (ICard c : secondTrainer.getDeck()) {
            c.setTrainer(secondTrainer);
        }


        for (int i = 0; i < 6; i++) {
            this.firstTrainer.drawACard();
            this.firstTrainer.addCardToPrizeCards();
            this.secondTrainer.drawACard();
            this.secondTrainer.addCardToPrizeCards();

        }
    }

    /**
     * select a Pokemon in active trainer to perform an action.
     *
     * @param aPokemon that wants to activate.
     */
    void selectPokemon(IPokemon aPokemon) {
        this.activeTurnPlayer.setSelectedPokemon(aPokemon);
    }

    /**
     * get the active trainer's selected card to perform an action.
     * @return the selected card.
     * */
    public ICard getSelectedCard() {
        return this.activeTurnPlayer.getSelectedCard();
    }

    /**
     * This is a testing method that allows to modify the trainer's hands to get always the same
     * result in the tests.
     *
     * @param firstHand for the first trainer.
     * @param secondHand for the second trainer.    *
     * */
    void testSetTrainersHands(ArrayList<ICard> firstHand, ArrayList<ICard> secondHand) {
        this.activeTurnPlayer.setHand(firstHand);
        this.activeTurnPlayer.getOpponent().setHand(secondHand);
    }

    /**
     * Lets the active trainer to see his active hand.
     * @return the active player hand's.
     * */
    ArrayList<ICard> viewActivePlayerHand() {
        return this.activeTurnPlayer.getHand();
    }

    /**
     * Lets the active trainer to play a card from his hand.
     * @param handIndex, the index of the hand's ArrayList of the target card to play.
     * */
    void playActivePlayerCard(int handIndex) {
        this.activeTurnPlayer.selectCard(viewActivePlayerHand().get(handIndex));
        if (this.viewActiveStadiumCard() != null) {
            this.viewActiveStadiumCard().doSelectedEffect();
        }
        this.activeTurnPlayer.play(viewActivePlayerHand().get(handIndex));
        this.activeTurnPlayer.unSelectCard();
        this.activeTurnPlayer.unSelectPokemon();
    }

    /**
     * Lets the active trainer to see his bench.
     * @return the active player bench's.
     * */
    ArrayList<IPokemon> viewActivePlayerBench() {
        return this.activeTurnPlayer.getBench();
    }

    /**
     * Lets the active trainer to see his active Pokemon.
     * @return the active player Pokemon's.
     * */
    IPokemon viewActivePlayerActivePokemon() {
        return this.activeTurnPlayer.getActivePokemon();
    }

    /**
     * Lets the active trainer to use an ability from his active Pokemon.
     * @param index the index in the AbilityContainer object of the Ability that wants to use.
     * */
    void useActivePlayerActivePokemonAbility(int index) {
        this.activeTurnPlayer.makeAnAbility(index);
    }

    /**
     * Lets the active trainer to know the active stadium card. If not exists, returns null.
     * @return the active stadium card.
     * */
    public StadiumCard viewActiveStadiumCard() {
        return this.activeStadiumCard;
    }

    /**
     * Changes the active stadium card. This method is called only by the Visitor that plays the card.
     * @param stadiumCard the new stadiumCard to set.
     * */
    public void changeActiveStadiumCard(StadiumCard stadiumCard) {
        this.activeStadiumCard = stadiumCard;
    }

    /**
     * Tells if an Energy was played by the active Trainer.
     * @return boolean with true if an energy was played in the turn, false otherwise.
     * */
    public boolean isAnEnergyPlayedInTurn() {
        return isAnEnergyPlayedInTurn;
    }

    /**
     * Changes the parameter that tells if an energy was played in the turn to true.
     * */
    public void notifyEnergyPlayedInTurn() {
        this.isAnEnergyPlayedInTurn = true;
    }

    /**
     * Finishes the active trainer turn.
     * */
    public void endTurn() {
        swapTurn();
    }

    /**
     * Swap the active trainer with the other and reset the turn parameters before a new turn begins.
     * */
    private void swapTurn() {
        activeTurnPlayer = (this.activeTurnPlayer == firstTrainer) ? secondTrainer : firstTrainer;
        this.isAnEnergyPlayedInTurn = false;
        beginTurn();
    }

    /**
     * Start a new turn.
     * */
    private void beginTurn() {
        activeTurnPlayer.drawACard();
    }

}


