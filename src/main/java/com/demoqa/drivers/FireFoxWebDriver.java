package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static com.demoqa.utils.ConfigReader.getValue;

public class FireFoxWebDriver {

    /**
     * Загружает и настраивает экземпляр FirefoxDriver.
     *
     * Настройка включает следующие параметры:
     * - "--disable-extensions" для отключения расширений.
     * - "--window-size=1920,1080" для установки размера окна.
     * - "--headless" для безголового режима (если параметр "headless" установлен в true).
     *
     * Возвращает настроенный экземпляр WebDriver.
     *
     * @return Экземпляр WebDriver с настроенным FirefoxDriver.
     */
    public static WebDriver loadFireFoxDriver (){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        if(Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
}
