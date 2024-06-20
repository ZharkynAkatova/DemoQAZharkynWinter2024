package com.demoqa.drivers;


import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.demoqa.utils.ConfigReader.getValue;

    public class ChromeWebDriver {
    /**
     * Загружает и настраивает экземпляр ChromeDriver.
     *
     * Настройка включает следующие параметры:
     * - "--remote-allow-origins=*" для разрешения удаленных источников.
     * - "--disable-extensions" для отключения расширений.
     * - "--window-size=1920,1080" для установки размера окна.
     * - "--no-sandbox" для запуска без песочницы.
     * - "--headless" для безголового режима (если параметр "headless" установлен в true).
     *
     * Возвращает настроенный экземпляр WebDriver.
     *
     * @return Экземпляр WebDriver с настроенным ChromeDriver.
     */
    public static WebDriver loadChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:chromeOptions", ImmutableMap.of("verboseLogging", true));
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }
}
