package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class stepdefs {

    private WebDriver driver;

    @Before
    public void setup(){
        String pathToChromeDriver = "src\\test\\resource\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String arg1) throws Exception {
        driver.get(arg1);
    }

    @Given("^I enter \"([^\"]*)\" into input field having id \"([^\"]*)\"$")
    public void i_enter_into_input_field_having_id(String arg1, String arg2) throws Exception {
        driver.findElement(By.id(arg2)).sendKeys(arg1);
    }

    @Given("^I click on element having class \"([^\"]*)\"$")
    public void i_click_on_element_having_class(String arg1) throws Exception {
        driver.findElement(By.className(arg1)).click();
    }

    @Then("^I should not get logged-in$")
    public void i_should_not_get_logged_in() throws Exception {
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("Your username is invalid!", msg);
    }

    @Then("^I should get logged-in$")
    public void i_should_get_logged_in() throws Exception {
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("You logged into a secure area!", msg);
    }

    @Then("^I should get logged-out$")
    public void i_should_get_logged_out() throws Exception {
        String msg = driver.findElement(By.id("flash")).getText();
        if(!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("You logged out of the secure area!", msg);
    }

    @Given("^I scroll to the bottom of the page$")
    public void i_scroll_to_the_bottom_of_the_page() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    @Given("I wait until new text is loaded")
    public void i_wait_until_new_text_is_loaded() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("small"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.tagName("small"))));
    }

    @When("^I scroll to the top of the page$")
    public void i_scroll_back_to_the_top_of_the_page() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)", "");
    }

    @Then("^I should see text stating \"([^\"]*)\"$")
    public void i_should_see_text_stating(String arg1) throws Exception {
        String header = driver.findElement(By.tagName("h3")).getText();
        if(!header.isEmpty())
            Assert.assertEquals(arg1, header);
    }

    @When("^I input an \"([^\"]*)\" key into the input field having id \"([^\"]*)\"$")
    public void i_input_an_key_into_the_input_field_having_id(String arg1, String arg2) throws Exception {
        driver.findElement(By.id(arg2)).sendKeys(arg1);
    }

    @Then("^I see the input \"([^\"]*)\" shown on the element having id \"([^\"]*)\"$")
    public void i_see_the_input_shown_on_the_screen(String arg1, String arg2) throws Exception {
        String result = driver.findElement(By.id(arg2)).getText();
        if(!result.isEmpty())
            Assert.assertEquals(String.format("You entered: %s", arg1.toUpperCase()), result);
    }

    @After
    public void teardown(){
        driver.close();
    }
}
