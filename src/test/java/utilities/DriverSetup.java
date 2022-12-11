package utilities;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class DriverSetup {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static synchronized void launchBrowser(String browser) {
		WebDriver webDriver = getBrowser(browser);
		webDriver.manage().window().maximize();
		setDriver(webDriver);
	}
	public static synchronized void quitBrowser(Scenario scenario) {
		takeScreenshot(scenario);
		getDriver().quit();
	}
	public static void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	public static WebDriver getDriver() {
		return driver.get();

	}
	public static void setDriver(WebDriver driver) {
		DriverSetup.driver.set(driver);
	}

	public static WebDriver getBrowser(String browser) {
		switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				return new FirefoxDriver();
			case "edge":
				WebDriverManager.edgedriver().setup();
				return new EdgeDriver();
			default:
				throw new RuntimeException("Browser not found!!!");
		}

	}
}
