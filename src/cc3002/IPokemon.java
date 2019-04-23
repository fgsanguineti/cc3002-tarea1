package cc3002;

import java.util.List;

public interface IPokemon extends ICard{
    String CARD_TYPE = "Pokemon";
    int getID();
    int getHP();
    List<List<IEnergy>> getEnergies();
}
