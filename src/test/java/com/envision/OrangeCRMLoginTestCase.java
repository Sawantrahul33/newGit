package com.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OrangeCRMLoginTestCase {


    String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Test (priority = 1)
    public void positiveLoginCase() throws InterruptedException, IOException {

        WebDriver driver = DriverManager.browserFactory("Chrome");
        driver.manage().window().maximize();
        driver.navigate().to(Url);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);


        Thread.sleep(2000);
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement dashBoard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertTrue(dashBoard.isDisplayed(),"Test Case Failed");
        Assert.assertEquals(dashBoard.getText(),"Dashboard");
        Thread.sleep(2000);
        ScreenShot.takeSS(driver);


    }
}

