package com.demoqa.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dostavka312_HW {

    WebDriver driver;

    @BeforeClass
    void openBrowsers(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @AfterClass
    void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void openLinks() {
        WebElement allEstablishments = driver.findElement(By.xpath("//*[@id=\"tab-01\"]/div/p/a/img"));
        allEstablishments.click();

        WebElement kfcRestaurant = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja']"));
        kfcRestaurant.click();

        WebElement orderKombo = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja#menu_0']"));
        orderKombo.click();
        WebElement dobavit = driver.findElement(By.xpath("//p[normalize-space(text())='Де Люкс Комбо']/following-sibling::form/button"));
        dobavit.click();

        WebElement basket = driver.findElement(By.xpath("//div[@class = 'pulse2']"));
        basket.click();

        WebElement buttonOformit =  driver.findElement(By.xpath("//a[@href = 'https://dostavka312.kg/cart']"));
        buttonOformit.click();

        WebElement name = driver.findElement(By.xpath("//input[@name = 'name']"));
        name.sendKeys("Аалы");

        WebElement address = driver.findElement(By.xpath("//input[@name = 'address']"));
        address.sendKeys("Токтогул 45");

        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Ваш телефон']"));
        phone.sendKeys("0555000000");

        WebElement chang = driver.findElement(By.xpath("//input[@name='money']"));
        chang.sendKeys("5000");

        WebElement buttonZakazat = driver.findElement(By.xpath("//button[@class='btn btn-yellow btn-lg btn-savecart']"));
//      buttonZakazat.click();

    }

}
