package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefs"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
        publish = true

)





public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)  //to run scenarios parallel
    public Object[][] scenarios(){
        return super.scenarios();

    }
}
