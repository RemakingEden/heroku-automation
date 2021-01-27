package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class scenario1 {

    private WebDriver driver;

    @Before
    public void setup(){
        String pathToChromeDriver = "C:\\Users\\joss.sparkes\\Documents\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        driver = new ChromeDriver();

    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String arg1) throws Exception {
        driver.get(arg1);
    }

    @Given("^I enter \"([^\"]*)\" into input field having id \"([^\"]*)\"$")
    public void i_enter_into_input_field_having_id(String arg1, String arg2) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(arg2)));
        driver.findElement(By.id(arg2)).sendKeys(arg1);
        TimeUnit.SECONDS.sleep(2);
    }

    @Given("^I click on element having class \"([^\"]*)\"$")
    public void i_click_on_element_having_class(String arg1) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(arg1)));
        driver.findElement(By.className(arg1)).click();
        TimeUnit.SECONDS.sleep(2);

    }

    @Then("^I should not get logged-in$")
    public void i_should_not_get_logged_in() throws Exception {

        By selection = By.id("flash");
        (new WebDriverWait(driver, 30)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("Your username is invalid!", msg);
    }

    @Then("^I should get logged-in$")
    public void i_should_get_logged_in() throws Exception {

        By selection = By.id("flash");
        (new WebDriverWait(driver, 30)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("You logged into a secure area!", msg);
    }



    @Then("^I should get logged-out$")
    public void i_should_get_logged_out() throws Exception {

        By selection = By.id("flash");
        (new WebDriverWait(driver, 30)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("You logged out of the secure area!", msg);
    }

    @After
    public void teardown(){
        driver.close();
    }
}
