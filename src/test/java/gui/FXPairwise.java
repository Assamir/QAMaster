package gui;

import javafx.stage.Stage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.api.FxRobotException;

class FXPairwise extends ChoiceBoxExampleFX {
    //    private final Pairwise pairwise = new Pairwise();
    //    @Override
//    public void start(Stage stage) throws Exception {
//        Application.launch(com.ankrpt.pairwise.MainRunner.class);
//
//    }
    @Override
    public void start(Stage stage) {
        // Launch the JavaFX application by reflection
        try {
//            var s=new Scene(pairwise);
//            stage.setScene(pairwise.getScene());
//            stage.show();
//            stage.toFront();

//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/your/fxmlfile.fxml"));
//            Scene scene = new Scene(loader.load());
//            stage.setScene(scene);
//            stage.show();
//            stage.toFront();

//            System.out.println("notification start");
//            Parent root1 = FXMLLoader.load(getClass().getResource("com.ankrpt.pairwise.MainRunner"));
//            Scene scene1 = new Scene(root1);
//            stage.setScene(scene1);
//            stage.show();


//            ApplicationTest.launch(com.ankrpt.pairwise.MainRunner.class, new String[]{});
//            ApplicationTest.launch(ChoiceBoxExampleFX.class, new String[]{});
//            ChoiceBoxExampleFX.setUpClass();

//            Class<?> appClass = Class.forName("com.ankrpt.pairwise.MainRunner");
//            Method mainMethod = appClass.getDeclaredMethod("main", String[].class);
//            mainMethod.invoke(null, (Object) new String[]{}); // Pass an empty string array for the main method arguments
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
        // Initializes JavaFX environment.
//        JFXPanel panel = new JFXPanel();
    }

//    @Test(expected = FxRobotException.class)
    @Test
    void testButtonTest() throws Exception {

        // Find a button by its text and click on it
        clickOn("Start");

        // Verify the expected behavior, e.g., a label text change
//        verifyThat("#statusLabel", hasText("Running..."));
    }
}
