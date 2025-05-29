package dk.sdu.cbse.score;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class Score {

    private int score = 0;

    public static void main(String[] args) {
        SpringApplication.run(Score.class, args);
    }

    @GetMapping("/score")
    public int getScore(){
        return this.score;
    }

    @PutMapping("/score/increase")
    public int addPoints(@RequestBody Map<String, Integer> body) {
    int points = body.get("points");
    System.out.println(points);
    this.score += points;
    return score;

}
}