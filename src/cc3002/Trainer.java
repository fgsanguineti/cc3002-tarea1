package cc3002;

import java.util.ArrayList;

class Trainer {
    private IPokemon activePokemon;
    private ArrayList<IPokemon> bench;
    private ArrayList<ICard> hand;
    private String playerName;

    Trainer(String playerName) {
        this.activePokemon = null;
        this.bench = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.playerName = playerName;
    }

    String getPlayerName() {
        return playerName;
    }
    IPokemon getActivePokemon() {
        return activePokemon;
    }

    ArrayList<ICard> getHand() {
        return hand;
    }

    void addCardToHand(ICard aCard) {
        hand.add(aCard);
    }

    ArrayList<IPokemon> getBench() {
        return bench;
    }

    void Play(ICard aCard) {
        hand.remove(aCard);
        aCard.playCard(this);
    }

    void playPokemon(IPokemon aPokemon) {
        if (activePokemon == null) activePokemon = aPokemon;
        else if (bench.size() < 5) bench.add(aPokemon);
    }

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
}