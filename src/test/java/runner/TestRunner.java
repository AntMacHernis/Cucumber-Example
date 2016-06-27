package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.java.lt.Bet;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue={"stepDefinition"}, plugin={"html:target/cucumber-html-report"})
public class TestRunner {

}
