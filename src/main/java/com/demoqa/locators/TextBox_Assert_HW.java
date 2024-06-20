package com.demoqa.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TextBox_Assert_HW {

    WebDriver driver;

    @BeforeClass
    void textBoxText(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test (priority = 1)
    void  textBoxText2() {
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Zharkyn");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("zharkyn.akatova@gmail.com");

        WebElement currentAddressInput = driver.findElement(By.xpath("(//html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/textarea)"));
        currentAddressInput.sendKeys("Tokmok, Gorkogo 12");

        WebElement permanentAddressInput = driver.findElement(By.xpath("((//textarea[@class='form-control'])[2])"));
        permanentAddressInput.sendKeys("Tokmok, Lenina 56");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        element.click();

    }

    @Test (dataProvider = "testData", priority = 3)
    void assertTextBox(String fullName, String email, String currentAddress, String permanentAddress){
        String fullNameText = driver.findElement(By.className("mb-1")).getText();
        System.out.println(fullNameText);
        Assert.assertEquals(fullNameText,"Name:" + fullName);

        String emailText = driver.findElement(By.id("email")).getText();
        System.out.println(emailText);
        Assert.assertEquals(emailText, "Email:" + email);

        String currentAddressLink = driver.findElement(By.xpath("(/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[3])")).getText();
        System.out.println(currentAddressLink);
        Assert.assertEquals(currentAddressLink, "Current Address :" + currentAddress);

        String permanentAddressLink = driver.findElement(By.xpath("((//p[@class='mb-1'])[4])")).getText();
        System.out.println(permanentAddressLink);
        Assert.assertEquals(permanentAddressLink, "Permananet Address :" + permanentAddress);
       }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"Zharkyn", "zharkyn.akatova@gmail.com", "Tokmok, Gorkogo 12", "Tokmok, Lenina 56"}
        };
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
