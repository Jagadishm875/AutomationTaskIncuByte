package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import utils.Hooks;

public class LoginSteps {

    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I navigate to the Magento homepage")
    public void navigateToHomepage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("I click on the {string} link")
    public void clickLink(String linkText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)))
            .click();
        	driver.navigate().refresh();
        	new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)))
            .click();
    }

    @When("I fill the registration form with valid details")
    public void fillForm() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));

        String email = "test" + System.currentTimeMillis() + "@mail.com";
        loginPage.register("John", "Doe", email, "Password@123");
    }

    @Then("I should see the success message after account creation")
    public void verifySuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean successVisible = wait.until(ExpectedConditions
            .textToBePresentInElementLocated(By.cssSelector(".message-success.success.message"), "Thank you for registering"));

        if (!successVisible) {
            throw new AssertionError("Success message not displayed. Account might not be created!");
        }
    }

    @Then("I close the browser")
    public void closeBrowser() {
    
        System.out.println("Browser will be closed in Hooks @After");
    }
}
