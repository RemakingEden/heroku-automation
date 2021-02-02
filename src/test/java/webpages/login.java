package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class login {
    WebDriver driver;

    public login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page URL
    private static String PAGE_URL="http://the-internet.herokuapp.com/login";

    //Title
    @FindBy(tagName = "h2")
    private WebElement title;

    //Paragraph
    @FindBy(tagName = "h4")
    private WebElement paragraph;

    //Username field
    @FindBy(id = "username")
    private WebElement usernameField;

    //Password field
    @FindBy(id = "password")
    private WebElement passwordField;

    //Login button
    @FindBy(className = "radius")
    private WebElement loginSubmitButton;

    //Constructor
    public login(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise elements
        PageFactory.initElements(driver, this);
    }

     public void clickOnLoginSubmitButton(){
        loginSubmitButton.click();
     }

     public void setUsernameField(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
     }

    public void setPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}
