package tests;

import org.junit.jupiter.api.Test;

import classes.credentials;

import static org.junit.jupiter.api.Assertions.*;

public class credentialstest {

    @Test
    public void testConstructorValues() {
        credentials cred = new credentials("hr", "signup");

        // Using reflection to access private fields
        try {
            java.lang.reflect.Field posField = credentials.class.getDeclaredField("pos");
            java.lang.reflect.Field entryField = credentials.class.getDeclaredField("entry");

            posField.setAccessible(true);
            entryField.setAccessible(true);

            assertEquals("hr", posField.get(cred));
            assertEquals("signup", entryField.get(cred));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection error: " + e.getMessage());
        }
    }
}