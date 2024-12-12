package miage.M1.dice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiceController {

    @GetMapping("/rollDice")
    public int rollDice() {
        Dice dice = new Dice();
        dice.roll();
        return dice.getValue();
    }

    @GetMapping("/rollDices/{X}")
    public int[] rollDices(@PathVariable int X) {
        int[] results = new int[X];
        for (int i = 0; i < X; i++) {
            results[i] = rollDice();
        }
        return results;
    }
}
