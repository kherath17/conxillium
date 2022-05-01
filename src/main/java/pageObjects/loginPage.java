package pageObjects;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.fileReader;

import java.io.IOException;

public class loginPage extends basePage{
    WebDriver driver=basePage.driver;
    fileReader read = new fileReader();

    public void navPage(){
        driver.get("https://conxillium.github.io/AddressManager/login");
        driver.manage().window().maximize();
    }

    public String checkTitle(){
        String pageTitile = driver.getTitle();
        return pageTitile;
    }

    public void enterUserName() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("userName"))).sendKeys("admin");

    }

    public void enterPassword() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("password"))).sendKeys("admin@123");
    }
    public void clickLogin() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("clkLogin"))).click();
    }
    public String userLoggedIn() throws IOException, ParseException {
        String loggedIn = driver.findElement(By.xpath(read.readData("addPageText"))).getText();
        return loggedIn;
    }
}
