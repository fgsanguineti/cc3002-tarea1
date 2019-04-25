package cc3002;

import java.util.ArrayList;

public class Trainer {
    private IPokemon activePokemon;
    private ArrayList<IPokemon> bench;
    private ArrayList<IPokemon> hand;
    public Trainer(){}

    IPokemon getActivePokemon() {
        return activePokemon;
    }

    void viewHand(){}
    void viewBench(){}

    void makeaPlay(ICard aCard){
        aCard.playCard(this);
    }


}