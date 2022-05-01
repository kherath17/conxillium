package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pageObjects.addPage;
import java.io.IOException;


public class addSteps {
    addPage ap = new addPage();


    @When("User click on Add New button navigates to detail enter page")
    public void user_click_on_add_new_button_navigates_to_detail_enter_page() throws IOException, ParseException {
        Assert.assertEquals("Add Data",ap.clickAdd());
    }

    @Then("User enter {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void user_enter_and_and_and(String Fname,String age,String address,String bMonth,String bYear,String bDate,String country,String expert,String gender) throws IOException, ParseException, InterruptedException {
        ap.userFillForm(Fname,age,address,bMonth,bYear,bDate,country,expert,gender);
    }

    @Then("User click on Submit")
    public void user_click_on_submit() throws IOException, ParseException {
        ap.clickSubmit();
    }
    @Then("Check {string} added")
    public void Check_added(String newName) throws InterruptedException, IOException, ParseException {
        Assert.assertEquals(newName,ap.checkUserAval(newName));
    }
    @Then("User refresh page and Check {string} added")
    public void user_refresh_page_and_check_added(String newName) throws InterruptedException, IOException, ParseException {
        ap.RefreshPage();
        Assert.assertEquals(newName,ap.checkUserAval(newName));
    }

    @Then("User remains on the same page")
    public void User_remains_on_the_same_page() throws InterruptedException, IOException, ParseException {
        Assert.assertEquals("Add Data",ap.addPageText());
    }

    @Then("User click on Reset and check fields are cleared")
    public void User_click_on_Reset_and_check_fields_are_cleared() throws InterruptedException, IOException, ParseException {
        Assert.assertEquals(true,ap.clearForm());
    }


}
