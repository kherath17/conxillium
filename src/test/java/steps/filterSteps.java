package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pageObjects.filterPage;
import pageObjects.loginPage;

import java.io.IOException;

public class filterSteps {
    loginPage lp = new loginPage();
    filterPage fp = new filterPage();

    @Given("User in the loggedIn Page")
    public void user_in_the_logged_in_page() throws InterruptedException, IOException, ParseException {
        Assert.assertEquals("View Data",lp.userLoggedIn());
    }
    @Then("User filter by button with Full Name")
    public void user_filter_by_button_with_Full_Name() throws InterruptedException, IOException, ParseException {
        Assert.assertEquals("Phillips Walters",fp.filterBtn());
    }
    @Then("User filter by table header")
    public void user_filter_by_table_header() throws InterruptedException, IOException, ParseException {
        Assert.assertEquals("Norway",fp.filterHeader());
    }
}
