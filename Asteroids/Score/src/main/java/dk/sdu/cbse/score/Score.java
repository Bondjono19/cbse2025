package dk.sdu.cbse.score;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class Score {
    private int score = 0;

    @GetMapping("/score")
    public String hello(@RequestParam(value = "amount")int points){
        score++;
        return String.format("Score is %d!", score);
    }
}
