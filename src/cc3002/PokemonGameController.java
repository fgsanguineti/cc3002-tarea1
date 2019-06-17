package cc3002;

import cc3002.pokemontypes.IPokemon;
import cc3002.trainercards.StadiumCard;

import java.util.ArrayList;

public class PokemonGameController {
    private Trainer firstTrainer;
    private Trainer secondTrainer;
    private StadiumCard activeStadiumCard;
    private Trainer activeTurnPlayer;
    private boolean isAnEnergyPlayedInTurn;

    PokemonGameController(Trainer firstTrainer, ArrayList<ICard> firstDeck, Trainer secondTrainer, ArrayList<ICard> secondDeck) {
        this.firstTrainer = firstTrainer;
        this.secondTrainer = secondTrainer;
        firstTrainer.setOpponent(secondTrainer);
        secondTrainer.setOpponent(firstTrainer);
        this.firstTrainer.setPokemonGameController(this);
        this.secondTrainer.setPokemonGameController(this);
        if (firstDeck.size() == 60) this.firstTrainer.setDeck(firstDeck);
        if (secondDeck.size() == 60) this.secondTrainer.setDeck(secondDeck);
    }

    public void startGame() {
        initializePlayers();
        this.activeTurnPlayer = firstTrainer;
        this.isAnEnergyPlayedInTurn = false;
        this.activeStadiumCard = null;
        beginTurn();
    }

    private void initializePlayers() {
        for (int i = 0; i < 6; i++) {
            this.firstTrainer.drawACard();
            this.firstTrainer.addCardToPrizeCards();
            this.secondTrainer.drawACard();
            this.secondTrainer.addCardToPrizeCards();
        }
    }

    public void setTrainersHands(ArrayList<ICard> firstHand, ArrayList<ICard> secondHand) {
        this.firstTrainer.setHand(firstHand);
        this.secondTrainer.setHand(secondHand);
    }

    public ArrayList<ICard> viewActivePlayerHand() {
        return this.activeTurnPlayer.getHand();
    }

    public void playActivePlayerCard(int handIndex) {
        this.activeTurnPlayer.play(viewActivePlayerHand().get(handIndex));
    }

    public ArrayList<IPokemon> viewActivePlayerBench() {
        return this.activeTurnPlayer.getBench();
    }

    public IPokemon viewActivePlayerActivePokemon() {
        return this.activeTurnPlayer.getActivePokemon();
    }

    public void useActivePlayerActivePokemonAbility(int index) {
        this.activeTurnPlayer.makeAnAbility(index);
    }

    public StadiumCard viewActiveStadiumCard() {
        return this.activeStadiumCard;
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


