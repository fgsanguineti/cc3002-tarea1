package cc3002;

import java.util.List;

public abstract class AbstractPokemon implements IPokemon {

    private String cardName;
    private int id;
    private int hp;
    private List<List<IEnergy>> availableEnergies;

    public AbstractPokemon(String cardName, int id, int hp) {
        this.cardName = cardName;
        this.id = id;
        this.hp = hp;
    }


    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public String getCardType() {
        return CARD_TYPE;
    }

    @Override
    public void playCard() {

    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getHP() {
        return this.hp;
    }

    @Override
    public List<List<IEnergy>> getEnergies() {
        return availableEnergies;
    }


}
