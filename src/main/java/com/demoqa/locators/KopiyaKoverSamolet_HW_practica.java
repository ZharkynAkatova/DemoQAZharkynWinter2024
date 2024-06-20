package com.demoqa.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class KopiyaKoverSamolet_HW_practica {

    WebDriver driver;

    @BeforeClass
    void openBrowser() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @AfterClass
    void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void onlineFoodOrderWeb() {

        WebElement linkOnPageOfRestaurants = driver.findElement(By.xpath("//span[normalize-space(text())='Eды']"));
        linkOnPageOfRestaurants.click();

        List<WebElement> listOfRestaurants = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));

        listOfRestaurants.forEach(s -> System.out.println(s.getText()));
        System.out.println("Total Number of Restaurants: " + listOfRestaurants.size());

        WebElement restaurantPishpek = listOfRestaurants.stream()
                .filter(element -> element.getText().equals("Ресторан Пишпек"))
                .findFirst()
                .orElse(null);

        if (restaurantPishpek != null) {
            WebElement pishpek = driver.findElement(By.xpath("//a[@href=\"https://dostavka312.kg/garnirygpt/restoran-pishpek\"]"));
            pishpek.click();
            System.out.println("\nМеню Ресторан Пишпек");
        } else {
            System.out.println("\nРесторан Пишпек закрыт");
        }
    }

    @Test(dataProvider = "menu")
    void printMenu(String menuXPath, String headerXPath) {
        WebElement menuLink = driver.findElement(By.xpath(menuXPath));
        menuLink.click();
        WebElement menuHeader = driver.findElement(By.xpath(headerXPath));
        System.out.println("\n" + menuHeader.getText());
        WebElement productSection = menuHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
        List<WebElement> menuItems = productSection.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuItems.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }

    @DataProvider(name = "menu")
    public String[][] menu() {
        return new String[][]{
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']", "//h2[a[@name='menu_0']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']", "//h2[a[@name='menu_1']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']", "//h2[a[@name='menu_2']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']", "//h2[a[@name='menu_3']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']", "//h2[a[@name='menu_4']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']", "//h2[a[@name='menu_5']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']", "//h2[a[@name='menu_6']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']", "//h2[a[@name='menu_7']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']", "//h2[a[@name='menu_8']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']", "//h2[a[@name='menu_9']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']", "//h2[a[@name='menu_10']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']", "//h2[a[@name='menu_11']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']", "//h2[a[@name='menu_12']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']", "//h2[a[@name='menu_13']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']", "//h2[a[@name='menu_14']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']", "//h2[a[@name='menu_15']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']", "//h2[a[@name='menu_16']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']", "//h2[a[@name='menu_17']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']", "//h2[a[@name='menu_18']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']", "//h2[a[@name='menu_19']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']", "//h2[a[@name='menu_20']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']", "//h2[a[@name='menu_21']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']", "//h2[a[@name='menu_22']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']", "//h2[a[@name='menu_23']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']", "//h2[a[@name='menu_24']]"}
        };
    }
}
