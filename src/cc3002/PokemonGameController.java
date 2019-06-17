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
     * Constructor that creates the Game Controller.
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
     * set all the cards owners
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

    void selectPokemon(IPokemon aPokemon) {
        this.activeTurnPlayer.setSelectedPokemon(aPokemon);
    }

    public ICard getSelectedCard() {
        return this.activeTurnPlayer.getSelectedCard();
    }

    void testSetTrainersHands(ArrayList<ICard> firstHand, ArrayList<ICard> secondHand) {
        this.activeTurnPlayer.setHand(firstHand);
        this.activeTurnPlayer.getOpponent().setHand(secondHand);
    }

    ArrayList<ICard> viewActivePlayerHand() {
        return this.activeTurnPlayer.getHand();
    }

    void playActivePlayerCard(int handIndex) {
        this.activeTurnPlayer.selectCard(viewActivePlayerHand().get(handIndex));
        if (this.viewActiveStadiumCard() != null) {
            this.viewActiveStadiumCard().doSelectedEffect();
        }
        this.activeTurnPlayer.play(viewActivePlayerHand().get(handIndex));
        this.activeTurnPlayer.unSelectCard();
        this.activeTurnPlayer.unSelectPokemon();
    }

    ArrayList<IPokemon> viewActivePlayerBench() {
        return this.activeTurnPlayer.getBench();
    }

    IPokemon viewActivePlayerActivePokemon() {
        return this.activeTurnPlayer.getActivePokemon();
    }

    void useActivePlayerActivePokemonAbility(int index) {
        this.activeTurnPlayer.makeAnAbility(index);
    }

    public StadiumCard viewActiveStadiumCard() {
        return this.activeStadiumCard;
    }

    public void changeActiveStadiumCard(StadiumCard stadiumCard) {
        this.activeStadiumCard = stadiumCard;
    }

    public boolean isAnEnergyPlayedInTurn() {
        return isAnEnergyPlayedInTurn;
    }

    public void notifyEnergyPlayedInTurn() {
        this.isAnEnergyPlayedInTurn = true;
    }

    public void endTurn() {
        swapTurn();
    }

    private void swapTurn() {
        activeTurnPlayer = (this.activeTurnPlayer == firstTrainer) ? secondTrainer : firstTrainer;
        this.isAnEnergyPlayedInTurn = false;
        beginTurn();
    }

    private void beginTurn() {
        activeTurnPlayer.drawACard();
    }

}


