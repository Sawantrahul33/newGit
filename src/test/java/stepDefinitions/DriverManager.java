package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    static WebDriver driver;
    public static WebDriver browserFactory(String browserName){

        switch (browserName.intern()){
            case "Chrome" :
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\canada\\IdeaProjects\\ApIProject\\src\\test\\resources\\binaries\\chromedriver.exe");

                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\canada\\IdeaProjects\\Practice\\src\\test\\resources\\binaries\\msedgedriver.exe");

            driver=new EdgeDriver();
            break;
            default:
                driver=null;


        }
        return driver;

    }
}
