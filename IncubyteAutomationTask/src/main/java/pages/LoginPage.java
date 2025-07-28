package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    
    @FindBy(xpath = "//*[@id='dismiss-button']")
    WebElement popup;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-confirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement createAccountButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void register(String fname, String lname, String emailID, String pwd) {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        email.sendKeys(emailID);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        createAccountButton.click();
    }

}
