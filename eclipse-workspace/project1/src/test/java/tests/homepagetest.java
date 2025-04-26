package tests;

import classes.homepage;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class homepagetest {

    @Test
    public void testFrameIsVisible() {
        homepage home = new homepage("HR");
        JFrame frame = home.frame;  

        // Check that the frame is initialized and visible
        assertNotNull(frame, "Frame should be initialized");
        assertTrue(frame.isVisible(), "Frame should be visible");
    }

    @Test
    public void testloginButtonExists() {
        homepage home = new homepage("LOGIN");
        JFrame frame = home.frame;

        // Check if the login button exists
        JButton lButton = findButtonByText(frame, "LOGIN");
        assertNotNull(lButton, "LOGIN button should exist");
        assertEquals("LOGIN", lButton.getText());
    }

    @Test
    public void testEmployeeButtonExists() {
        homepage home = new homepage("SIGN-UP");
        JFrame frame = home.frame;

        // Check if the signup button exists
        JButton sButton = findButtonByText(frame, "SIGN-UP");
        assertNotNull(sButton, "SING-UP button should exist");
        assertEquals("SIGN-UP", sButton.getText());
    }

    // Helper method to find a button by text on the frame
    private JButton findButtonByText(JFrame frame, String text) {
        for (Component c : frame.getContentPane().getComponents()) {
            if (c instanceof JButton btn && text.equals(btn.getText())) {
                return btn;
            }
        }
        return null;
    }
}
