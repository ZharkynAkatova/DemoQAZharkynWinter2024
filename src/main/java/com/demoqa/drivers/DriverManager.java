package com.demoqa.drivers;

import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {  // драйвер пустой
            switch ((ConfigReader.getValue("browser").toLowerCase())){
                case  "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case  "safari":
                    driver = SafariWebDriver.loadSafariDriver();
                    break;
                case  "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;
                case  "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("You provider wrong Driver name");
            }
        } return driver;
    }

    public static void closedriver(){
        try {
            if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // печать исключения
        }
    }
}
