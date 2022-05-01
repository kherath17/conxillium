package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pageObjects.loginPage;

import java.io.IOException;


public class loginSteps {
    loginPage lp = new loginPage();

    @Given("User direct to login Page")
    public void navLogin(){
        lp.navPage();
        }
    @When("User able to see page title {string}")
    public void user_able_to_see_page_title(String string) {
        Assert.assertEquals("Address Manager",lp.checkTitle());
    }

    @Then("User enter username")
    public void user_enter_username() throws IOException, ParseException {
        lp.enterUserName();
    }

    @Then("User enter password")
    public void user_enter_password() throws IOException, ParseException {
        lp.enterPassword();
    }

    @Then("User Click on login")
    public void user_click_on_login() throws IOException, ParseException {
        lp.clickLogin();
    }
    @Then("User able to see loggedIn Page")
    public void user_able_to_see_logged_in_page() throws IOException, ParseException {
        Assert.assertEquals("View Data",lp.userLoggedIn());
    }

    }

