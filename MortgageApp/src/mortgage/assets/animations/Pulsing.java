package mortgage.assets.animations;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Pulsing {
  private FadeTransition ft;
  public Pulsing(Node node) {
      ft = new FadeTransition(Duration.millis(3000), node);
      ft.setFromValue(1.0);
      ft.setToValue(0.7);
      ft.setCycleCount(Animation.INDEFINITE);
      ft.setAutoReverse(true);

      ft.play();
  }
  public void playPulsing(){ft.playFromStart();}
}
