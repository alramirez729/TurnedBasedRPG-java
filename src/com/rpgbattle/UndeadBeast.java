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
    public String toString() {
        return String.format("\n%s: %d/%d HP max", getName(), getCurrentHP(), getMaxHP());
    }

    @Override
    public void move(Character[] allies, Character[] enemies) {
        while (true) {
            int ally = this.random.nextInt(allies.length);
            if (allies[ally].getCurrentHP() != 0) {
                attack(allies[ally]);
                break;
            }
        }
    }
}

