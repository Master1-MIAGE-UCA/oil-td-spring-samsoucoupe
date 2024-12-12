package miage.M1.dice;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDice(1).get(0);

    }

    @GetMapping("/rollDices/{X}")
    public int[] rollDices(@PathVariable int X) {
        List<Integer> results = diceService.rollDice(X);
        int[] resultsArray = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultsArray[i] = results.get(i);
        }
        return resultsArray;
    }
}
