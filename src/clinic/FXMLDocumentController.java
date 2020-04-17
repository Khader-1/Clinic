package clinic;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class FXMLDocumentController implements Resizable {

    final String content = "Lorem ipsum";

    final Animation animation = new Transition() {
        {
            setCycleDuration(Duration.millis(500));
        }

        @Override
        protected void interpolate(double frac) {
            pane.setPrefWidth(50 + frac * 150);
        }
    };

    final Animation inverseAnimation = new Transition() {
        {
            setCycleDuration(Duration.millis(500));
        }

        @Override
        protected void interpolate(double frac) {
            pane.setPrefWidth(200 - (frac * 150));
        }
    };

    static void onChange(Number oldValue, Number newValue) {

    }

    @FXML
    private JFXHamburger burger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            drawer.setSidePane((AnchorPane) FXMLLoader.load(getClass().getResource("Pane.fxml")));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerNextArrowBasicTransition back = new HamburgerNextArrowBasicTransition(burger);
        back.setRate(back.getRate() * -1);
        burger.setOnMouseClicked((event) -> {
            back.setRate(back.getRate() * -1);
            back.play();
            if (back.getRate() > 0) {
                drawer.open();
                animation.play();
            } else {
                inverseAnimation.play();
                drawer.close();
            }
        });
    }

    @Override
    public void resize(Number old, Number newVal) {

    }

}
