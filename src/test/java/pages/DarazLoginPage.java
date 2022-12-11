package pages;

import org.openqa.selenium.By;

public class DarazLoginPage extends BasePage{
	public final By USERNAME = By.xpath("//input[@placeholder='Please enter your Phone Number or Email']");
	public final By PASSWORD = By.xpath("//input[@placeholder='Please enter your password']");
	public final By LOGINBUTTON = By.xpath("//button[normalize-space()='LOGIN']");
	public final By ERROR_TITLE = By.className("next-feedback-title");
	public final By ERROR_MESSAGE = By.className("next-feedback-content");
	
	public void enterUsername(String username) {
		writeText(USERNAME, username);
	}
	
	public void enterPassword(String password) {
		writeText(PASSWORD, password);
	}
	
	public void cliONLoginButton() {
		clickOnElement(LOGINBUTTON);
	}
	
	public void doLogIn(String username, String password) {
		writeText(USERNAME, username);
		writeText(PASSWORD, password);
		clickOnElement(LOGINBUTTON);
	}
	
	
}
