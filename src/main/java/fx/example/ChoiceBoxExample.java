package fx.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a simple JavaFX Button - and prints a text when the button is clicked.
 */
public class ChoiceBoxExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button myButton = new Button();
        myButton.setText("Click Me!");

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setId("choiceBox");
        choiceBox.getItems().add("Choice 0");
        choiceBox.getItems().add("Choice 1");
        choiceBox.getItems().add("Choice 2");

        choiceBox.setOnAction((event) -> {
            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + choiceBox.getValue());
        });



        VBox vbox = new VBox(choiceBox, myButton);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("ChoiceBox Example");
        primaryStage.show();
    }

}