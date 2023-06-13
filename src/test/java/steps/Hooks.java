package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static base.BaseTest.*;

public class Hooks {
    @Before
    public void setup() {
        initiateDriver();
    }

    @After
    public void teardown() {
        closeDriver();
    }
}
