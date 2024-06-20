package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class CSS_Selector {

    @Test(description = "Find by ID")
    void findByIDTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // неявное ожидания
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

//        WebElement homeLink = driver.findElement(By.cssSelector("#userName"));
//        homeLink.sendKeys("Zharkyn");

//        WebElement nameLink = driver.findElement(By.cssSelector("input[id ='userName']"));
//        nameLink.sendKeys("Akatova");

//        WebElement nameLink1 = driver.findElement(By.cssSelector("input.mr-sm-2"));
//        nameLink1.sendKeys("Akatova");

        WebElement nameLink1 = driver.findElement(By.cssSelector(".form-control[id = userName]"));
        nameLink1.sendKeys("Akatova");
    }
}
