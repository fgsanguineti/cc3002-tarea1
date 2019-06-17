package cc3002.pokemontypes;

import cc3002.AbstractCard;
import cc3002.abilities.AbilityContainer;
import cc3002.abilities.IAbility;
import cc3002.abilities.IAttack;
import cc3002.abilities.NullAbility;
import cc3002.energytypes.*;
import cc3002.visitor.card.ICardVisitor;
import cc3002.visitor.type.pokemon.IPokemonTypeVisitor;

/**
 * This class implements the IPokemon interface
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon {
    private int id;
    private int hp;
    private AbilityContainer abilityList;
    private IAbility activeAbility;
    private IAttack activeAttack;
    private EnergyContainer pokemonEnergy;
    /**
     * Creates a new pokemon.
     * @param cardName The name of the card.
     * @param id The card ID.
     * @param hp The HP of the pokemon
     * @param abilityList a list with the abilities of the Pokemon, that can be up to 4.
     */
    public AbstractPokemon(String cardName, int id, int hp, AbilityContainer abilityList) {
        super(cardName);
        this.id = id;
        this.hp = hp;
        this.abilityList = abilityList;
        this.activeAbility = new NullAbility();
        this.activeAttack = new NullAbility();
        this.pokemonEnergy = new EnergyContainer(0, 0, 0, 0, 0, 0);
        this.abilityList.setAssociatedPokemonToAllAbilities(this);
    }


    @Override
    public abstract void accept(ICardVisitor v);

    /**
     * Returns the ID of the Pokemon.
     * @return a Integer with the Pokemon ID.
     */
    @Override
    public int getID() {
        return this.id;
    }

    /**
     * Returns the HP of the Pokemon.
     * @return a Integer with the Pokemon HP.
     */
    @Override
    public int getHP() {
        return this.hp;
    }

    @Override
    public void modifyHP(int x) {
        this.hp += x;
        this.getTrainer().checkAndReplaceActiveDeadPokemon();
    }
    /**
     * Returns the list of the Pokemon abilities.
     *
     * @return a AbilityContainer with the Pokemon abilities.
     */
    @Override
    public AbilityContainer getAbilityList() {
        return this.abilityList;
    }
    /**
     * Returns the Pokemon active ability
     * @return the active ability.
     */
    @Override
    public IAbility getActiveAbility() {
        return this.activeAbility;
    }

    @Override
    public void unSelectActiveAbility() {
        this.activeAbility = new NullAbility();
    }
    /**
     * Select an active ability from a list of abilities.
     * @param index the number of the ability that wants to select, from 1 to 4.
     */
    @Override
    public void setActiveAbility(int index) {
        IAbility aux = this.abilityList.getAbility(index);
        boolean condition = aux.isEnoughEnergyToUseTheAbility(this);
        if (condition && isAlive()) {
            this.activeAbility = aux;
        }
    }

    /**
     * Shows if the Pokemon is Alive. If the HP is higher than 0, returns true, else returns false.
     *
     * @return a boolean with the alive status.
     */
    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    /**
     * Give an electric energy to the target Pokemon.
     * @param energy a electric energy.
     */
    @Override
    public void receiveElectricEnergy(ElectricEnergy energy) {
        this.pokemonEnergy.addEnergy("Electric");
    }

    /**
     * Give an fighting energy to the target Pokemon.
     * @param energy a fighting energy.
     */
    @Override
    public void receiveFightingEnergy(FightingEnergy energy) {
        this.pokemonEnergy.addEnergy("Fighting");
    }

    /**
     * Give an fire energy to the target Pokemon.
     * @param energy a fire energy.
     */
    @Override
    public void receiveFireEnergy(FireEnergy energy) {
        this.pokemonEnergy.addEnergy("Fire");
    }

    /**
     * Give an grass energy to the target Pokemon.
     * @param energy a grass energy.
     */
    @Override
    public void receiveGrassEnergy(GrassEnergy energy) {
        this.pokemonEnergy.addEnergy("Grass");
    }

    /**
     * Give an psychic energy to the target Pokemon.
     * @param energy a psychic energy.
     */
    @Override
    public void receivePsychicEnergy(PsychicEnergy energy) {
        this.pokemonEnergy.addEnergy("Psychic");
    }

    /**
     * Give an water energy to the target Pokemon.
     * @param energy a water energy.
     */
    @Override
    public void receiveWaterEnergy(WaterEnergy energy) {
        this.pokemonEnergy.addEnergy("Water");
    }

    /**
     * Return the EnergyContainer that store all the energies of the Pokemon.
     *
     * @return a EnergyCContainer with all the Pokemon energies.
     */
    @Override
    public EnergyContainer getAllEnergyQuantity() {
        return this.pokemonEnergy;
    }

    @Override
    public void setEnergyContainer(EnergyContainer aEnergyContainer) {
        this.pokemonEnergy = aEnergyContainer;
    }

    /**
     * Return the number of electric energies that has the Pokemon.
     * @return a int with the number of electric energies of the Pokemon.
     */
    @Override
    public int getElectricEnergyQuantity() {
        return this.pokemonEnergy.getElectric();
    }

    /**
     * Return the number of fighting energies that has the Pokemon.
     * @return a int with the number of fighting energies of the Pokemon.
     */
    @Override
    public int getFightingEnergyQuantity() {
        return this.pokemonEnergy.getFighting();
    }

    /**
     * Return the number of fire energies that has the Pokemon.
     * @return a int with the number of fire energies of the Pokemon.
     */
    @Override
    public int getFireEnergyQuantity() {
        return this.pokemonEnergy.getFire();
    }

    /**
     * Return the number of grass energies that has the Pokemon.
     * @return a int with the number of grass energies of the Pokemon.
     */
    @Override
    public int getGrassEnergyQuantity() {
        return this.pokemonEnergy.getGrass();
    }

    /**
     * Return the number of grass energies that has the Pokemon.
     * @return a int with the number of grass energies of the Pokemon.
     */
    @Override
    public int getPsychicEnergyQuantity() {
        return this.pokemonEnergy.getPsychic();
    }

    /**
     * Return the number of water energies that has the Pokemon.
     * @return a int with the water of fighting energies of the Pokemon.
     */
    @Override
    public int getWaterEnergyQuantity() {
        return this.pokemonEnergy.getWater();
    }

    /**
     * Lets the Pokemon be attacked by an electric Pokemon
     * @param anAttack the attack that the electric Pokemon performs to this Pokemon
     */
    @Override
    public void receiveElectricPokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon be attacked by an fighting Pokemon
     * @param anAttack the attack that the fighting Pokemon performs to this Pokemon
     */
    @Override
    public void receiveFightingPokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon be attacked by an fire Pokemon
     * @param anAttack the attack that the fire Pokemon performs to this Pokemon
     */
    @Override
    public void receiveFirePokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon be attacked by an grass Pokemon
     * @param anAttack the attack that the grass Pokemon performs to this Pokemon
     */
    @Override
    public void receiveGrassPokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon be attacked by an psychic Pokemon
     * @param anAttack the attack that the psychic Pokemon performs to this Pokemon
     */
    @Override
    public void receivePsychicPokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon be attacked by an water Pokemon
     * @param anAttack the attack that the water Pokemon performs to this Pokemon
     */
    @Override
    public void receiveWaterPokemonAttack(IAttack anAttack) {
        receiveAttack(anAttack);
    }

    /**
     * Lets the Pokemon receive an type-weakness attack that hits the double of his base damage.
     * @param anAttack the type-weakness attack that the Pokemon receives
     */
    @Override
    public void receiveWeaknessPokemonTypeAttack(IAttack anAttack) {
        this.hp -= 2 * anAttack.getBaseDamage();
    }

    /**
     * Lets the Pokemon receive an type-resistant attack that hits his base damage minus 30. If the attack has a
     * base damage lower than 30, the Pokemon HP is not changed.
     * @param anAttack the type-resistant attack that the Pokemon receives.
     */
    @Override
    public void receiveResistantPokemonTypeAttack(IAttack anAttack) {
        int aux = anAttack.getBaseDamage() - 30;
        if (aux > 0) this.hp -= (anAttack.getBaseDamage() - 30);
    }

    /**
     * Lets the Pokemon receive a normal attack that doesn't has type-weakness or type-resistant to the Pokemon that
     * performs it.
     * @param anAttack the attack that the Pokemon receives.
     */
    @Override
    public void receiveAttack(IAttack anAttack) {
        this.hp -= anAttack.getBaseDamage();
    }

    /**
     * Performs the correct attack to the target Pokemon.
     *
     * @param other the target Pokemon.
     */
    @Override
    public abstract void attack(IPokemon other);


    public IAttack getActiveAttack() {
        return activeAttack;
    }

    public void setActiveAttack(IAttack activeAttack) {
        this.activeAttack = activeAttack;
    }

    @Override
    public abstract void accept(IPokemonTypeVisitor v);

    /**
     * {@inheritDoc}
     *
     * @param o The target Pokemon object
     * @return True if are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPokemon)) return false;
        AbstractPokemon that = (AbstractPokemon) o;
        return this.getID() == that.getID() &&
                this.getTrainer() == that.getTrainer() &&
                this.getHP() == that.getHP() &&
                getCardName().equals(that.getCardName()) &&
                this.getAbilityList().equals(that.getAbilityList()) &&
                getActiveAbility().equals(that.getActiveAbility()) &&
                this.getAllEnergyQuantity().equals(that.getAllEnergyQuantity());
    }
}
