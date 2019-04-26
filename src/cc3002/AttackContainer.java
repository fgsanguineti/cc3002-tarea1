package cc3002;

import java.util.Arrays;

public class AttackContainer {
    private Attack[] attackContainer;

    public AttackContainer(Attack a, Attack b, Attack c, Attack d) {
        attackContainer = new Attack[4];
        this.attackContainer[0] = a;
        this.attackContainer[1] = b;
        this.attackContainer[2] = c;
        this.attackContainer[3] = d;
    }
    Attack getAttack(int n){
        return this.attackContainer[n-1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttackContainer)) return false;
        AttackContainer that = (AttackContainer) o;
        return Arrays.equals(attackContainer, that.attackContainer);
    }
}

