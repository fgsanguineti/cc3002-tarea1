package cc3002;


/**
 * Common interface for all the attacks, that also are a ability.
 * A attack has a base damage and it's used by a Pokemon.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IAttack extends IAbility {
    int getBaseDamage();
}
