package stepDefinition;

import cucumber.api.java.en.And;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class GoogleTest {

        WebDriver driver;


        @Given("Start firefox  and open google.com home page.")
        public void startFirefoxAndOpenGoogleHomePage() {
            System.setProperty("webdriver.chrome.driver","D:\\работа\\chromedriver_win32\\chromedriver.exe" );
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://google.com");

        }

        @When("In search Field enter Selenium Value.")
        public void inSearchFieldEnterSeleniumValue() {
            WebElement searchField = driver.findElement(By.name("q"));
            searchField.sendKeys("Selenium");
            searchField.submit();
        }

        @Then("Result Page is open")
        public void resultPageIsOpen() {
            (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".r > a")));
        }

        @And("First link go to Selenium hq official site")
        public void firstLinkGoToSeleniumhqOfficialSite() {
            try {
                List<WebElement> resultLinksList = driver.findElements(By.cssSelector(".r > a"));
                WebElement firstLink = resultLinksList.get(0);
                firstLink.click();
                (new WebDriverWait(driver, 30)).until(ExpectedConditions.urlContains("seleniumhq"));
                driver.close();
            }
            finally {
                driver.close();
            }

    }



}
