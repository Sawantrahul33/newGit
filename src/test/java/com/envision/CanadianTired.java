package com.envision;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.envision.DriverManager.driver;

public class CanadianTired {

    String url="https://www.canadiantire.ca/en/flyer.html";

    @Test
    public void flyerPage(){

        DriverManager.browserFactory("Chrome");
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[contains(@src,'https://ctcdigital.blob.core.windows.net/d0319/thumbnails/DE0319_01_0_Ott_Wpg_Cal_Ed.jpg')]/parent::div")).click();



    }
}

