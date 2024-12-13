package miage.M1.dice;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiceController {

    @Autowired
    private DiceService diceService;

    @Operation(summary = "Roll a dice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dice rolled successfully", content = @io.swagger.v3.oas.annotations.media.Content),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.rollDice(1).get(0);
    }

    @Operation(summary = "Roll X dices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dices rolled successfully", content = @Content(examples = @ExampleObject(value = "[3, 6, 2]"))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
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
