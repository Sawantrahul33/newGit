package com.envision;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    static String screenShotPath="C:\\Users\\canada\\IdeaProjects\\Practice\\src\\test\\resources\\takeScreenShot";
    public static void takeSS(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File image=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image,new File(screenShotPath+"Image-"
                +new SimpleDateFormat("MM_dd_YY_hh_mm_ss").
                format(new Date())+".png"));
    }
}
