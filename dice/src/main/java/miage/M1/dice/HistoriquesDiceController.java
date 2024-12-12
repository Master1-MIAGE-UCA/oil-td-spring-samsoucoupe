package miage.M1.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/diceLogs")
public class HistoriquesDiceController {

    @Autowired
    private DiceRepository diceRepository;

    @GetMapping
    public String getAllDiceLogs() {
        System.out.println("GET /diceLogs");
        return diceRepository.findAll().toString();
    }

}
