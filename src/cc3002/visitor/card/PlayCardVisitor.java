package cc3002.visitor.card;

import cc3002.Trainer;
import cc3002.energytypes.AbstractEnergy;
import cc3002.pokemontypes.IBasicPokemon;
import cc3002.pokemontypes.IPhaseOnePokemon;
import cc3002.pokemontypes.IPhaseTwoPokemon;
import cc3002.pokemontypes.IPokemon;
import cc3002.trainercards.AbstractTrainerCard;
import cc3002.trainercards.ObjectCard;
import cc3002.trainercards.StadiumCard;
import cc3002.trainercards.SupportCard;

public class PlayCardVisitor extends CardVisitor {
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        basicPokemon.getTrainer().getHand().remove(basicPokemon);
        Trainer theTrainer = basicPokemon.getTrainer();
        if ((theTrainer.getActivePokemon() == null)) theTrainer.setActivePokemon(basicPokemon);
        else if (theTrainer.getBench().size() < 5) theTrainer.getBench().add(basicPokemon);
    }

    @Override
    public void visitPhaseOnePokemon(IPhaseOnePokemon phaseOnePokemon) {
        int lookedID = phaseOnePokemon.getBasicPokemonToEvolveID();
        changePreEvolution(phaseOnePokemon, lookedID);
    }

    @Override
    public void visitPhaseTwoPokemon(IPhaseTwoPokemon phaseTwoPokemon) {
        int lookedID = phaseTwoPokemon.getPhaseOnePokemonToEvolveID();
        changePreEvolution(phaseTwoPokemon, lookedID);
    }

    @Override
    public void visitEnergyCard(AbstractEnergy aEnergy) {
        if (aEnergy.getTrainer().getPokemonGameController() != null) {
            if (aEnergy.getTrainer().getPokemonGameController().isAnEnergyPlayedInTurn()) return;
            aEnergy.getTrainer().getPokemonGameController().notifyEnergyPlayedInTurn();
        }
        aEnergy.addEnergyToPokemon(aEnergy.getTrainer().getSelectedPokemon());
        aEnergy.getTrainer().getHand().remove(aEnergy);
    }

    @Override
    public void visitObjectCard(ObjectCard aObject) {
        removeTrainerCard(aObject);
        aObject.getEffect().setAssociatedCard(aObject);
        aObject.doSelectedEffect();
    }

    @Override
    public void visitStadiumCard(StadiumCard aStadium) {
        aStadium.getTrainer().getPokemonGameController().changeActiveStadiumCard(aStadium);
        aStadium.getEffect().setAssociatedCard(aStadium);
        removeTrainerCard(aStadium);
    }

    @Override
    public void visitSupportCard(SupportCard aSupport) {
        removeTrainerCard(aSupport);
        aSupport.getEffect().setAssociatedCard(aSupport);
        aSupport.doSelectedEffect();
        aSupport.discard(aSupport.getTrainer());
    }

    private void changePokemon(IPokemon oldPokemon, IPokemon newPokemon, boolean active) {
        newPokemon.setEnergyContainer(oldPokemon.getTrainer().getActivePokemon().getAllEnergyQuantity()); // change energies
        oldPokemon.discard(oldPokemon.getTrainer());
        if (active) {
            oldPokemon.getTrainer().setActivePokemon(newPokemon);
        } else {
            oldPokemon.getTrainer().getBench().add(newPokemon);
            oldPokemon.getTrainer().getBench().remove(oldPokemon);
        }
    }

    private void removeTrainerCard(AbstractTrainerCard aTrainerCard) {
        aTrainerCard.getTrainer().getHand().remove(aTrainerCard);
    }

    private void changePreEvolution(IPokemon newPokemon, int lookedID) {
        newPokemon.getTrainer().getHand().remove(newPokemon);
        Trainer theTrainer = newPokemon.getTrainer();
        IPokemon selected = theTrainer.getSelectedPokemon();
        if (lookedID == theTrainer.getActivePokemon().getID() && selected.equals(theTrainer.getActivePokemon()))
            this.changePokemon(theTrainer.getActivePokemon(), newPokemon, true);
        else {
            for (IPokemon p : theTrainer.getBench()) {
                if (p.getID() == lookedID && selected.equals(p)) this.changePokemon(p, newPokemon, false);
            }
        }
    }
}