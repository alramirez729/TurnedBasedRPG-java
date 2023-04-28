package com.rpgbattle;

import com.rpgbattle.Character;

public class UndeadBeast extends Character {

    public UndeadBeast() {
        super(500, 500, 21, "Undead Beast");
    }

    public UndeadBeast(int maxHp, int currentHp, int strength, String name) {
        super(maxHp, currentHp, strength, name);
    }

    @Override
    public void attack(Character d) {
        int hit = (10 - (this.random.nextInt(4))) * getStrength();
        d.setCurrentHP(d.getCurrentHP() - hit);
        System.out.printf("\n%s attacks %s for %d damage! %s", getName(), getName(), hit, d);
    }

    @Override
    public String toString() {
        return String.format("\n%s: %d/%d HP max", getName(), getCurrentHP(), getMaxHP());
    }

    @Override
    public void move(Character[] allies, Character[] enemies) {
        attack(allies[this.random.nextInt(4)]);
    }
}

