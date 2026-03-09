package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testApp() {
        App myApp = new App();
        assertEquals("Hello World", myApp.getGreeting());
    }
}
