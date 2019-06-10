package cc3002.cardvisitors;

import cc3002.energyTypes.IEnergy;
import cc3002.pokemontypes.IBasicPokemon;
import cc3002.pokemontypes.IPhaseOnePokemon;
import cc3002.pokemontypes.IPhaseTwoPokemon;
import cc3002.trainercards.ObjectCard;
import cc3002.trainercards.StadiumCard;
import cc3002.trainercards.SupportCard;

public interface ICardVisitor {
    void visitBasicPokemon(IBasicPokemon basicPokemon);

    void visitPhaseOnePokemon(IPhaseOnePokemon phaseOnePokemon);

    void visitPhaseTwoPokemon(IPhaseTwoPokemon phaseTwoPokemon);

    void visitEnergyCard(IEnergy aEnergy);

    void visitObjectCard(ObjectCard aObject);

    void visitStadiumCard(StadiumCard aStadium);

    void visitSupportCard(SupportCard aSupport);
}

