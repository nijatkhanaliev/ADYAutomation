package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver webDriver;

    private Driver(){

    }

    public static WebDriver getDriver(){
        if(webDriver==null){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }

    public static void quitDriver(){
        if(webDriver!=null){
            webDriver.quit();
            webDriver = null;
        }
    }

}
