package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue={"stepDefinitions" ,"pages" , "utils" },
        tags = ("@test"),
        plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" })

public class RunCucumberTests extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
