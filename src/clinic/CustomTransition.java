package clinic;

import javafx.animation.Transition;
import javafx.util.Duration;

public abstract class CustomTransition extends Transition {

    public static void play(Event e) {
        play(1000, e);
    }

    public static void play(double duration, Event e) {
        CustomTransition t = new CustomTransition() {
            @Override
            protected void interpolate(double frac) {
                e.deal(frac);
            }
        };
        t.setCycleDuration(Duration.millis(duration));
        t.play();
    }

    public static CustomTransition getTransition(Event e) {
        return new CustomTransition() {
            @Override
            protected void interpolate(double frac) {
                e.deal(frac);
            }
        };
    }

    public void setCycleDuration(double millis) {
        this.setCycleDuration(Duration.millis(millis));
    }

}
