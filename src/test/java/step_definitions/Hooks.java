package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetup;

public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");

    @Before
    public void launchBrowser(){
        DriverSetup.launchBrowser(browserName);
    }

    @After
    public void quiteBrowser(Scenario scenario){
        DriverSetup.quitBrowser(scenario);
    }
}
