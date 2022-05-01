package pageObjects;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.fileReader;
import java.io.IOException;

public class addPage {
    WebDriver driver = basePage.driver;
    fileReader read = new fileReader();
    public String clickAdd() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("addBtn"))).click();
        String addPage = driver.findElement(By.xpath(read.readData("addPgTextArea"))).getText();
        return addPage;
    }
    public void userFillForm(String Fname,String age,String address,String bMonth,String bYear,String bDate,String country,String expert,String gender) throws IOException, ParseException, InterruptedException {
        driver.findElement(By.xpath(read.readData("Fname"))).sendKeys(Fname);
        driver.findElement(By.xpath(read.readData("Age"))).sendKeys(age);
        driver.findElement(By.xpath(read.readData("Address"))).sendKeys(address);
        driver.findElement(By.xpath(read.readData("datePicker"))).click();
        if(driver.findElement(By.xpath(read.readData("datePicker"))).isSelected()==true){
            driver.findElement(By.xpath(read.readData("selMonth"))).click();
            Select selMonth =new Select( driver.findElement(By.xpath(read.readData("selMonth"))));
            selMonth.selectByValue(bMonth);
            Thread.sleep(5000);

            driver.findElement(By.xpath(read.readData("selYear"))).click();
            Select selYear =new Select( driver.findElement(By.xpath(read.readData("selYear"))));
            selYear.selectByValue(bYear);
            Thread.sleep(5000);

            driver.findElement(By.xpath("(//div[@class='btn-light'])["+bDate+"]")).click();
            Thread.sleep(5000);


        }

        driver.findElement(By.xpath(read.readData("selCountry"))).click();
        Select selCountry = new Select(driver.findElement(By.xpath(read.readData("selCountry"))));
        selCountry.selectByValue(country);

        driver.findElement(By.xpath("//label[contains(text(),'"+expert+"')]/../input")).click();

        driver.findElement(By.xpath("//label[contains(text(),'"+gender+"')]/../input")).click();
    }
    public void clickSubmit() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("SubmitBtn"))).click();
    }
    public String checkUserAval(String newName) throws InterruptedException, IOException, ParseException {
        Thread.sleep(5000);
        driver.findElement(By.xpath(read.readData("FilterText"))).sendKeys(newName);
        driver.findElement(By.xpath(read.readData("FilterBtn"))).click();
        Thread.sleep(5000);
        String newUserVal = driver.findElement(By.xpath(read.readData("UserAval"))).getText();
        return newUserVal;
    }

    public String addPageText() throws IOException, ParseException {
        String addPage = driver.findElement(By.xpath(read.readData("addPageText"))).getText();
        return addPage;
    }

    public boolean clearForm() throws IOException, ParseException {
        driver.findElement(By.xpath(read.readData("resetBtn"))).click();
        boolean fieldEmpty = driver.findElement(By.xpath(read.readData("Fname"))).getText().isEmpty();
        boolean countryEmpty = driver.findElement(By.xpath(read.readData("Country"))).getText().isEmpty();
        if(fieldEmpty ==true && countryEmpty==true){
            return true;
        }else
            return false;

    }

    public void RefreshPage(){
        driver.navigate().refresh();
    }



}
