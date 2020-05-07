package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class login {
    @Given("I open login page")
    public void iOpenLoginPage() {
        getDriver().get("http://ask-stage.portnov.com/#/login");
    }

    @When("I type email {string}")
    public void iTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
    }

    @And("I type password {string}")
    public void iTypePassword(String pass) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pass);
    }

    @And("I click Sign in button")
    public void iClickSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @Then("text {string} appears")
    public void textAppears(String text) throws InterruptedException {
        Thread.sleep(2000);
//        String actualText = getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).getText();
//        assertThat(actualText).containsIgnoringCase(text);
      assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).isDisplayed()).isTrue();

    }

    @Then("password displays in bullets")
    public void passwordDisplaysInBullets() {
//    assertThat(getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).getAttribute("type")).isEqualTo("password");

        String xpath = "//input[@placeholder='Password *']";
        String attribute = "type";
        String value = "password";

        assertThat(getDriver().findElement(By.xpath(xpath)).getAttribute(attribute)).isEqualTo(value);

    }
    @Then ("I click on {string} button")
    public void iClickOnInMainMenu(String button) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[contains(text(),'"+button+"')]")).click();
    }

    @Then("I type {string} in the Title of the Quiz field")
    public void iTypeInTheField(String title) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@id='mat-input-2']")).sendKeys(title);
    }

    @Then("I click on Add Question button")
    public void iClickOnAddQuestionButton() {
        getDriver().findElement(By.xpath("//*[@type='button']/span/mat-icon")).click();
    }

    @Then("I type {string} field")
    public void iTypeField(String question) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(question);
    }
}
