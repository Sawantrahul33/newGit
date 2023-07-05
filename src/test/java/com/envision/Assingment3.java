package com.envision;
import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;


import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Assingment3{

    WebDriver driver;
   String URL1="https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst\n";


           String URL2="https://www.snapdeal.com/&quot";
@Test


public void part1() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\canada\\IdeaProjects\\Practice\\src\\test\\resources\\binaries\\chromedriver.exe");
        ChromeOptions co=new ChromeOptions();
       // driver = new ChromeDriver(co.addArguments("headless"));
        driver = new ChromeDriver();
        driver.navigate().to(URL1);
       // driver.switchTo().frame(2);
        driver.switchTo().frame("iframeResult");


        FluentWait<WebDriver> fw = new WebDriverWait(driver,500).pollingEvery(Duration.ofSeconds(5));
        WebElement Click = driver.findElement(By.xpath("//button[normalize-space()='Click me to display Date and Time.']"));
        System.out.println("Title: " + Click.getText());
        Click.click();




        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat=new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
        String actualText=dateFormat.format(date);
        System.out.println(actualText);


        String ExpectedDate=driver.findElement(By.id("demo")).getText();
        System.out.println("Website Date"+ ExpectedDate);


        Assert.assertEquals(actualText, ExpectedDate);




        driver.switchTo().defaultContent();
        WebElement fw1=new     WebDriverWait(driver,200).pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.id("runbtn")));
        System.out.println("Text:"+fw1.getText());
        fw1.click();


        driver.switchTo().frame("iframeResult");


        WebElement s= driver.findElement(By.id("demo"));
        Assert.assertFalse(s.isDisplayed(),"Test Passed Succefully");


        }



}
