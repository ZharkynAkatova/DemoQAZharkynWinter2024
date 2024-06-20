package com.demoqa.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Dostavka {

    @Test
    public void findFood() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");

        // Находим раздел "Еда" и кликаем по нему
        WebElement edaElement = driver.findElement(By.xpath("//img[@alt='edaG']"));
        edaElement.click();

        // Находим названия всех заведений и ложим их в List
        List<WebElement> listOfEstablishments = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));

//          Перебор всех заведений через стрим апи и вывод на консоль
        listOfEstablishments.stream()
                .map(WebElement :: getText)
                .forEach(System.out::println);

// Вывод на консоль общего количества заведений
        System.out.println("\nОбщее количество заведений равно: " + listOfEstablishments.size());

        // Поиск ресторана Пишпек
        WebElement pishpek = listOfEstablishments.stream()
                .filter(element -> element.getText().equals("Ресторан Пишпек"))
                .findFirst()
                .orElse(null);

        // Если найден Ресторан Пишпек, то перейти к его меню
        if(pishpek != null) {
            pishpek.click();
            System.out.println("\nРесторан Пишпек найден, переходим к его меню");
        }else {
            System.out.println("\nИскомое заведение не найдено");
        }

        WebElement menuElement = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
        menuElement.click();


        // Находим названия всех блюд в меню и ложим их в List
        List<WebElement> listOfDishes = driver.findElements(By.xpath("//div[@class='art-postcontent clearfix product']//p[@class='product-name']"));
        listOfDishes.stream()
                .map(WebElement ::getText)
                .forEach(System.out::println);

// Вывод общего количества блюд на консоль
        System.out.println("\nОбщее количество блюд равно: " + listOfDishes.size());







//        driver.close();
//        driver.quit();
    }
}