package gui;

import fx.example.ChoiceBoxExample;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit5.ApplicationTest;

public abstract class ChoiceBoxExampleFX extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        ApplicationTest.launch(ChoiceBoxExample.class);
    }


    @Override
    public void start(Stage stage) {
        stage.show();
    }

}
