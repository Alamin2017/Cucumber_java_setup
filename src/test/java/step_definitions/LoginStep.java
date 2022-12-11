package step_definitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.DarazLoginPage;
import java.util.List;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static utilities.DriverSetup.getDriver;

public class LoginStep {
    DarazLoginPage loginPage = new DarazLoginPage();
    @Given("User is on Login page")
    public void user_is_on_login_page() {
        getDriver().get("https://member.daraz.com.bd/user/login?spm=a2a0e.home.header.d5.735212f7wRGGDC&redirect=https%3A%2F%2Fwww.daraz.com.bd%2F");


    }
    @When("user enter username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("user click on the login button")
    public void user_click_on_the_login_button() {
        loginPage.cliONLoginButton();
    }

    @Then("user see the user account page title {string}")
    public void user_see_the_user_account_page_title(String title) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(getDriver().getTitle(), title);
    }

    @Then("user must see the error title {string} and massage {string}")
    public void userMustSeeTheErrorTitleAndMassage(String errorTitle, String errorMessage) {
        assertEquals(loginPage.getElementText(loginPage.ERROR_TITLE), errorTitle);
        assertEquals(loginPage.getElementText(loginPage.ERROR_MESSAGE), errorMessage);
    }

    @Then("user shouldn't see the account page title {string}")
    public void userShouldnTSeeTheAccountPageTitle(String title) {
        assertNotEquals(getDriver().getTitle(), title);
    }

    @When("user enter {string} and {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        user_enter_username_and_password(username, password);
    }

    @Then("user must see the {string} and {string}")
    public void userMustSeeTheError_titleAndMassage(String error_tile, String massage) {
        userMustSeeTheErrorTitleAndMassage(error_tile, massage);

    }

    @But("user shouldn't see the account {string}")
    public void userShouldnTSeeTheAccountPage_title(String pageTitle) {
        userShouldnTSeeTheAccountPageTitle(pageTitle);
    }

    @Given("We are testing how to use data table")
    public void weAreTestingHowToUseDataTable(List<String> texts) {
        System.out.println(texts);
    }
}
