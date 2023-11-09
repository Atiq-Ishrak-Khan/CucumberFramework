package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("User is on the OpenCart login page")
    public void user_is_on_the_open_cart_login_page() {
        driver.get("https://shorturl.at/QUV58");
        loginPage = new LoginPage(driver);

    }

    @Given("User entered a valid username and password")
    public void user_entered_a_valid_username_and_password() {
        loginPage.enterEmail("atiq9023@gmail.com");
        loginPage.enterPassword("Atiq123");
    }

    @Given("User entered invalid {string} and {string}")
    public void user_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in Successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }



    @Then("User should see an error message saying {string}")
    public void user_should_see_an_error_message_saying(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }

    @When("User click on the \"Forgotten Password\" link")
    public void user_click_on_the_forgotten_password_link() {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("User should be redirected to the password reset page")
    public void user_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }

}
