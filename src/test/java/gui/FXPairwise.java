package gui;

import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;

class FXPairwise extends ApplicationTest {
    //    @Override
//    public void start(Stage stage) throws Exception {
//        Application.launch(com.ankrpt.pairwise.MainRunner.class);
//
//    }
    @Override
    public void start(Stage stage) {
        // Launch the JavaFX application by reflection
        try {
            Class<?> appClass = Class.forName("com.ankrpt.pairwise.MainRunner");
            Method mainMethod = appClass.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[]{}); // Pass an empty string array for the main method arguments
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
        // Initializes JavaFX environment.
        JFXPanel panel = new JFXPanel();
    }

    @Test
    void testButton() throws Exception {
        // Find a button by its text and click on it
        clickOn("Start");

        // Verify the expected behavior, e.g., a label text change
        verifyThat("#statusLabel", hasText("Running..."));
    }
}
