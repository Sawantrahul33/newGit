package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static stepDefinitions.DriverManager.driver;

public class LoginStepsDefinition {
    String Url2="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Given("the website is open")
    public void theWebsiteIsOpen()  {
        WebDriver driver=DriverManager.browserFactory("Chrome");
        driver.manage().window().maximize();
        driver.navigate().to(Url2);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String UserName, String Password) throws InterruptedException {
        Thread.sleep(2000);
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(UserName);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
        Thread.sleep(2000);

    }


    @And("Hit the submit button")
    public void hitTheSubmitButton() {
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }

    @Then("Homepage should be loaded")
    public void homepageShouldBeLoaded() throws InterruptedException {
        WebElement dashBoard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashBoard.isDisplayed(),"Test Case Failed");
        Assert.assertEquals(dashBoard.getText(),"Dashboard");
        Thread.sleep(2000);
        driver.close();
    }


}
