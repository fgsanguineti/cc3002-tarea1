package cc3002;

public abstract class AbstractEnergy implements IEnergy{

    @Override
    public void addEnergyToPokemon() {

    }
    @Override
    public void playCard() {
        addEnergyToPokemon();
    }
}
