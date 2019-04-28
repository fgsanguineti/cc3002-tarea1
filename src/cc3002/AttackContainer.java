package cc3002;

import java.util.Arrays;

/**
 * This class allows to store up to four attacks.
 *
 * @author F. Giovanni Sanguineti
 */
public class AttackContainer {
    private Attack[] attackContainer;

    /**
     * Build the AttackContainer.
     * @param a Stores the first attack. If no first attack, the input must be null.
     * @param b Stores the second attack. If no first attack, the input must be null.
     * @param c Stores the third attack. If no first attack, the input must be null.
     * @param d Stores the fourth attack. If no first attack, the input must be null.
     */
    public AttackContainer(Attack a, Attack b, Attack c, Attack d) {
        attackContainer = new Attack[4];
        this.attackContainer[0] = a;
        this.attackContainer[1] = b;
        this.attackContainer[2] = c;
        this.attackContainer[3] = d;
    }

    /**
     * Returns the attack specified object.
     * @param n The number of the attack. Values must be a integer between 1 and 4.
     * @return The specified attack. If a null was returned is because there are not attack in his slot.
     */
    Attack getAttack(int n){
        return this.attackContainer[n-1];
    }

    /**
     * Compares the AttackContainer with another AttackContainer.
     * @param o  Another AttackContainer .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttackContainer)) return false;
        AttackContainer that = (AttackContainer) o;
        return Arrays.equals(attackContainer, that.attackContainer);
    }
}

