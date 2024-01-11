package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int min = 1;
    int max = 6;

    public int RollDice() {
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}
