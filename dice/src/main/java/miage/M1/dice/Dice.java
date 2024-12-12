package miage.M1.dice;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    private int value;

    public Dice() {
        this.value = 1;
    }

    public int getValue() {
        return value;
    }

    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
    }

}
