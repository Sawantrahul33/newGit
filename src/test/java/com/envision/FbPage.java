package com.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FbPage {

    static String link = "https://www.facebook.com/";

    @Test
    public static void FbCreateNewAc() throws InterruptedException {
        WebDriver driver = DriverManager.browserFactory("Chrome");
        driver.manage().window().maximize();
        driver.navigate().to(link);

        Thread.sleep(2000);

        WebElement createAc = driver.findElement(By.xpath("//a[normalize-space()='Create new account']"));
        createAc.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        driver.findElement(By.name("firstname")).sendKeys("JOY");
        driver.findElement(By.name("lastname")).sendKeys("JOY");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sawantrahul@33gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sawantrahul@33gmail.com");
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("R@123");

        FluentWait<WebDriver>fw=new FluentWait<>(driver);
        fw.withTimeout(Duration.ofSeconds(200));
        fw.pollingEvery(Duration.ofSeconds(5));

        WebElement monthElement = driver.findElement(By.id("month"));
        Select mm = new Select(monthElement);
        mm.selectByValue("6");

        WebElement dayElement = driver.findElement(By.id("day"));
        Select dd = new Select(dayElement);
        mm.selectByIndex(6);

        WebElement yearElement = driver.findElement(By.id("year"));
        Select yy = new Select(yearElement);
        yy.selectByVisibleText("2005");

        driver.findElement(By.xpath("//input[@value='2']")).click();


        driver.findElement(By.xpath("//button[normalize-space()='Sign Up'and @name='websubmit']")).click();


        Thread.sleep(2000);

        driver.close();

    }

    @Test
    public static void withOutSelect() throws InterruptedException {
        WebDriver driver = DriverManager.browserFactory("Chrome");
        driver.manage().window().maximize();
        driver.navigate().to(link);

        Thread.sleep(2000);

        WebElement createAc = driver.findElement(By.xpath("//a[normalize-space()='Create new account']"));
        createAc.click();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        driver.findElement(By.name("firstname")).sendKeys("JOY");
        driver.findElement(By.name("lastname")).sendKeys("JOY");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sawantrahul@33gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sawantrahul@33gmail.com");
        driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("R@123");

        List<WebElement> monthElement = driver.findElements(By.xpath("//select[@id='month']/option"));
        for (WebElement mm : monthElement)
            if (mm.getAttribute("value").equalsIgnoreCase("Apr")) {
                mm.click();
                break;
            }

        List<WebElement> dayElement = driver.findElements(By.xpath("//select[@id='day']/option"));
        dayElement.get(10).click();

        List<WebElement> yyElement = driver.findElements(By.xpath("//select[@id='year']/option"));
        for (WebElement Year : yyElement)
            if (Year.getText().equalsIgnoreCase("2010")) {
                Year.click();
                break;
            }


        driver.findElement(By.xpath("//input[@value='2']")).click();


        driver.findElement(By.xpath("//button[normalize-space()='Sign Up'and @name='websubmit']")).click();


        Thread.sleep(2000);

        driver.close();


    }
}

