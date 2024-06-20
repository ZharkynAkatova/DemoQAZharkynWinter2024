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

public class TextBox {

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
    void textBoxText() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.manage().window().maximize();
      driver.get("https://demoqa.com/text-box");
      PageFactory.initElements(driver, this);
   }

    @Test (dataProvider = "testData", priority = 0)
    public void testTextBoxForm1(String fullName, String email, String currentAddress, String permanentAddress) {
        this.fullName.sendKeys(fullName);
        this.email.sendKeys(email);
        this.currentAddress.sendKeys(currentAddress);
        this.permanentAddress.sendKeys(permanentAddress);
         submitButton.click();  //  пока что закомментирую, т.к. при запуске из-за рекламы не нажимается кнопка и некоторые тесты падают
    }


    @Test(dataProvider = "testFullName", priority = 1)
    void testBoxTest1(String fullName) {
        this.fullName.sendKeys(fullName);
    }

    @Test(dataProvider = "testEmail", priority = 2)
    void testBoxTest2(String email) {
        this.email.sendKeys(email);
    }

    @Test(dataProvider = "testCurrentAddress", priority = 3)
    void testBoxTest3(String currentAddress) {
        this.currentAddress.sendKeys(currentAddress);
    }

    @Test(dataProvider = "testPermanentAddress", priority = 4)
    void testBoxTest4(String permanentAddress) {
        this.permanentAddress.sendKeys(permanentAddress);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"Zharkyn", "zharkyn.akatova1987@gmail.com", "Tokmok, Gorkogo 36", "Tokmok, Gorkogo 30"},
                {"Zharkyn", "zharkyn.akatova1987", "Tokmok, Gorkogo 36", "Tokmok, Gorkogo 30"},
                {"", "zharkyn.akatova1987@gmail.com", "Tokmok, Gorkogo 36", "Tokmok, Gorkogo 30"},
                {"Zharkyn", "", "Tokmok, Gorkogo 36", "Tokmok, Gorkogo 30"},
                {"Zharkyn", "zharkyn.akatova1987@gmail.com", "", "Tokmok, Gorkogo 30"},
                {"Zharkyn", "zharkyn.akatova1987@gmail.com", "Tokmok, Gorkogo 36", ""},
                {"Zharkyn", "zharkyn.akatova1987@gmail.com", "", ""},
                {"", "", "", ""}
        };
    }

    @DataProvider(name = "testFullName")
    public Object[][] testFullName() {
        return new Object[][]{
                {"Zharkyn"},
                {"Zharkyn123"},
                {"12345"},
                {""},
                {"Zharkyn@#$^"},
                {"@#$%^&*"}
        };
    }

    @DataProvider(name = "testEmail")
    public Object[][] testEmail() {
        return new Object[][]{
                {"zharkyn.akatova1987@gmail.com"},
                {"zharkyn.akatova1987"},
                {"zharkyn.akatova1987@gmail."},
                {""}
        };
    }

    @DataProvider(name = "testCurrentAddress")
    public Object[][] testCurrentAddress() {
        return new Object[][]{
                {"Tokmok, Gorkogo 36"},
                {""},
        };
    }

    @DataProvider(name = "testPermanentAddress")
    public Object[][] testPermanentAddress() {
        return new Object[][]{
                {"Tokmok, Gorkogo 30"},
                {""},
        };
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
