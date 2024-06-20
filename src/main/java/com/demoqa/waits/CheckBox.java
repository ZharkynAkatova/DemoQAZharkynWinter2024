package com.demoqa.waits;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class CheckBox {

    WebDriver driver;

    public void checBoxNotes1 () {
        WebElement element = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
        element.click();
        driver.findElement(By.xpath("//*[@id='item-4']/span")).click();
        driver.findElement(By.xpath("//*[@id='item-1']/span")).click();
        element.click();
    }

    @Test
    void checBoxNotesTest1 () throws InterruptedException {
        checBoxNotes1();
    }

    public void checBoxNotes3() {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                WebElement element = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
                element.click();
                driver.findElement(By.xpath("//*[@id='item-4']/span")).click();
                driver.findElement(By.xpath("//*[@id='item-1']/span")).click();
                element.click();
                break; // Выходим из цикла, если все действия выполнены успешно
            } catch (StaleElementReferenceException e) {
                attempts++;
                // Повторно ищем элемент на каждой итерации цикла
                System.out.println("Возникло исключение StaleElementReferenceException, повторная попытка... Попытка: " + attempts);
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Не удалось выполнить действия после " + maxAttempts + " попыток");
        }
    }

    @Test
    void checBoxNotesTest3() {
        checBoxNotes3();
    }

    public void checBoxNotes4() {
        WebElement element;
            try {
                element = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
                element.click();
                driver.findElement(By.xpath("//*[@id='item-4']/span")).click();
                driver.findElement(By.xpath("//*[@id='item-1']/span")).click();
                element.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Возникло исключение StaleElementReferenceException, повторная попытка");
                element = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
                element.click();
        }
    }

    @Test
    void checBoxNotesTest4() {
        checBoxNotes4();
    }

    public void checBoxNotes2() {
        WebElement element = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
        element.click();
        driver.findElement(By.cssSelector("label[for = 'tree-node-react']")).click();
        driver.findElement(By.xpath("//*[@id='item-4']/span")).click();
        driver.findElement(By.xpath("//*[@id='item-1']/span")).click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/label/span[1]"));
        element1.click();
    }

    @Test
    void checBoxNotesTest2 ()  {
        checBoxNotes2();
    }

    @BeforeMethod
    void checkBox(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/IdeaProjects/DemoQAWinter24/src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        // кнопка "+"
        driver.findElement(By.cssSelector(".rct-option")).click();
    }

    public String resultWords() {
        return driver.findElement(By.cssSelector("#result")).getText();
    }

    @Test
    void checkBoxHome () {
        driver.findElement(By.cssSelector("label[for = 'tree-node-home']")).click();
        List<WebElement> labelElements = driver.findElements(By.cssSelector("span.text-success"));
        StringBuilder allText = new StringBuilder();
        for (WebElement element : labelElements) {
            allText.append(element.getText()).append(" ");
        }
        Assert.assertEquals(allText.toString(), "home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile ");
    }

    @Test
    void checkBoxDocuments () {
        driver.findElement(By.cssSelector("label[for = 'tree-node-documents']")).click();
        Assert.assertEquals(resultWords(), "You have selected :\n" + "documents\n" + "workspace\n" + "react\n" +
               "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general");
    }

    @Test
    void checBoxDownloads () {
        driver.findElement(By.cssSelector("label[for = 'tree-node-downloads']")).click();;
        Assert.assertEquals(resultWords(), "You have selected :\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }

    @Test
    void checBoxCommands () {
        driver.findElement(By.cssSelector("label[for = 'tree-node-commands']")).click();
        driver.findElement(By.cssSelector("label[for = 'tree-node-angular']")).click();
        driver.findElement(By.cssSelector("label[for = 'tree-node-veu']")).click();
        driver.findElement(By.cssSelector("label[for = 'tree-node-wordFile']")).click();
        Assert.assertEquals(resultWords(), "You have selected :\n" + "commands\n" + "angular\n" + "veu\n" + "wordFile");
    }

    @AfterMethod
    void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

}
