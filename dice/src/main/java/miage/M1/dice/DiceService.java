package miage.M1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    @Autowired
    private DiceRepository diceRepository;
    private Dice dice;

    public DiceService() {
        this.dice = new Dice();
    }

    public List<Integer> rollDice(int numberOfDice) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            dice.roll();
            results.add(dice.getValue());
        }
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(numberOfDice);
        log.setResults(results);
        log.setTimestamp(java.time.LocalDateTime.now());
        diceRepository.save(log);
        return results;
    }
}