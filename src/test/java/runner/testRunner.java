package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.basePage;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:test-output.html",
                "json:target/cucumber-report.json"
        },
        features = {"src/main/resources/"},
        glue = {
                "steps"
        },
        tags ="@master"
)

public class testRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setBrowser(){
        basePage.setDriver();
    }
    @AfterClass
    public void tearDown(){
        basePage.tearDown();
    }

}
