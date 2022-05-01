package pageObjects;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.fileReader;

import java.io.IOException;

public class filterPage {
    WebDriver driver=basePage.driver;
    fileReader read = new fileReader();
    public void userLoggedIn() throws IOException, ParseException {
        loginPage lp = new loginPage();
        lp.userLoggedIn();

    }
    public String filterBtn() throws InterruptedException, IOException, ParseException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(read.readData("FilterText"))).sendKeys("Phillips Walters");
        driver.findElement(By.xpath(read.readData("FilterBtn"))).click();
        String extractUserN = driver.findElement(By.xpath(read.readData("UserAval"))).getText();
        return extractUserN;
    }
    public String filterHeader() throws InterruptedException, IOException, ParseException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.xpath(read.readData("filterCountry"))).click();
        driver.findElement(By.xpath(read.readData("filterCountryTxt"))).sendKeys("Norway");
        Thread.sleep(5000);
        String country = driver.findElement(By.xpath(read.readData("countryAval"))).getText();
        return country;
    }
}
