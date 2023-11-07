package gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChoiceBoxExampleFXTest extends ChoiceBoxExampleFX {
    @Test
    void testButtonTest() {
        clickOn("Click Me!");
        assertTrue(true);
    }
}
