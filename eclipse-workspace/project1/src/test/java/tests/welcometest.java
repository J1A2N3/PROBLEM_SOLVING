package tests;
import classes.welcome;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class welcometest {

    @Test
    public void testFrameIsVisible() {
        welcome welcomes = new welcome();
        JFrame frame = welcomes.frame;

        assertNotNull(frame, "Frame should be initialized");
        assertTrue(frame.isVisible(), "Frame should be visible");
    }

    @Test
    public void testHRButtonExists() {
        welcome welcome = new welcome();
        JFrame frame = welcome.frame;

        JButton hrButton = findButtonByText(frame, "HR");
        assertNotNull(hrButton, "HR button should exist");
        assertEquals("HR", hrButton.getText());
    }

    @Test
    public void testEmployeeButtonExists() {
        welcome welcome = new welcome();
        JFrame frame = welcome.frame;

        JButton employeeButton = findButtonByText(frame, "EMPLOYEE");
        assertNotNull(employeeButton, "EMPLOYEE button should exist");
        assertEquals("EMPLOYEE", employeeButton.getText());
    }

    private JButton findButtonByText(JFrame frame, String text) {
        for (Component c : frame.getContentPane().getComponents()) {
            if (c instanceof JButton btn && text.equals(btn.getText())) {
                return btn;
            }
        }
        return null;
    }
} 