package page;

import conf.TestContext;
import org.openqa.selenium.By;

import java.util.List;

public class ScoreCard extends AbstractPage {

  public ScoreCard(TestContext testContext) {
    super(testContext);
  }

  public ScoreCard saveCard() {
    click(By.id("save-card"));
    return this;
  }

  public ScoreCard scoreSequence(List<Integer> sequence) {
    sequence.forEach(number -> {
      switch (number) {
        case 1 -> click(By.id("score-button1"));
        case 2 -> click(By.id("score-button2"));
        case 3 -> click(By.id("score-button3"));
        case 4 -> click(By.id("score-button4"));
        case 5 -> click(By.id("score-button5"));
        case 6 -> click(By.id("score-button6"));
        case 7 -> click(By.id("score-button7"));
        case 8 -> click(By.id("score-button8"));
        case 9 -> click(By.id("score-button9"));
        case 10 -> click(By.id("score-button10"));
      }
    });
    return this;
  }

}
