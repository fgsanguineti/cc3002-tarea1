package cc3002;

import java.util.ArrayList;

public class Trainer {
    private IPokemon activePokemon;
    private ArrayList<IPokemon> bench;

    public Trainer(){}

    IPokemon getActivePokemon() {
        return activePokemon;
    }

}