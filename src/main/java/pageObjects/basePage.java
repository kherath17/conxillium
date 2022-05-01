package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basePage {
    public static WebDriver driver;
    public static WebDriver setDriver(){
         System.setProperty("webdriver.chrome.driver","C:\\Users\\E-LINE\\Desktop\\GapStars\\conxillium\\src\\main\\resources\\chromeDriver\\chromedriver.exe");
         driver = new ChromeDriver();
        return driver;
    }

    public static void tearDown(){
        driver.quit();
    }

}
