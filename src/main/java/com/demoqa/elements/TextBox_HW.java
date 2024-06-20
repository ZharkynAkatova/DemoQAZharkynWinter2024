package com.demoqa.elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
public class TextBox_HW {

    WebDriver driver;

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        PageFactory.initElements(driver, this);
    }


    @Test
    public void testTextBoxForm2() {
        fullName.sendKeys("Zharkyn");
        email.sendKeys("zharkyn.akatova1987");
        currentAddress.sendKeys("Tokmok, Gorkogo 36");
        permanentAddress.sendKeys("Tokmok, Gorkogo 30");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm3() {
        email.sendKeys("zharkyn.akatova1987@gmail.com");
        currentAddress.sendKeys("Tokmok, Gorkogo 36");
        permanentAddress.sendKeys("Tokmok, Gorkogo 30");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm4() {
        fullName.sendKeys("Zharkyn");
        currentAddress.sendKeys("Tokmok, Gorkogo 36");
        permanentAddress.sendKeys("Tokmok, Gorkogo 30");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm5() {
        fullName.sendKeys("Zharkyn");
        email.sendKeys("zharkyn.akatova1987@gmail.com");
        permanentAddress.sendKeys("Tokmok, Gorkogo 30");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm6() {
        fullName.sendKeys("Zharkyn");
        email.sendKeys("zharkyn.akatova1987@gmail.com");
        currentAddress.sendKeys("Tokmok, Gorkogo 36");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm7(){
        fullName.sendKeys("Zharkyn");
        email.sendKeys("zharkyn.akatova1987@gmail.com");
        submitButton.click();
    }

    @Test
    public void testTextBoxForm8(){
        submitButton.click();
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
