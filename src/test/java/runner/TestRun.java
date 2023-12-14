package runner;

//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features={"src//test//java//features"},glue={"stepdefinations"}
,plugin={"pretty","html:target/cucumber"})

@Test
public class TestRun extends AbstractTestNGCucumberTests{

}
