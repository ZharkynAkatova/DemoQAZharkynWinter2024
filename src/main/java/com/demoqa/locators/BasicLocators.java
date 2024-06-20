package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class BasicLocators {
    @Test(description = "Find by ID")
    void findByIDTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("John Doe");

        String textBox = driver.findElement(By.tagName("h1")).getText();
        System.out.println(textBox);

        driver.get("https://demoqa.com/links");
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();

        WebElement badLink = driver.findElement(By.partialLinkText("Bad"));
        badLink.click();




//        WebElement fullNameInput = driver.findElement(By.id("userName"));
//        fullNameInput.sendKeys("John Doe");

//        WebElement fullNameInput = driver.findElement(By.className("mr-sm-2"));
//        fullNameInput.sendKeys("John Doe");

//        WebElement fullNameInput = driver.findElement(By.tagName("input"));
//        fullNameInput.sendKeys("zharkyn.akatova@gmail.com");


    }
}
