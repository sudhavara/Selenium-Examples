package CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\sudha\\IdeaProjects\\SeleniumE2EProject\\src\\test\\java\\features",glue = "stepDefinitions")
public class testRunner {
}
