package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DropDownHelper {

    public WebDriver driver;
    WebElementActions webElementActions = new WebElementActions();

    public DropDownHelper(WebDriver driver){
        this.driver = driver;
    }

    public DropDownHelper selectByVisibleText(WebElement selectElement, String value){
        Select select = new Select(selectElement);
        List<WebElement> optionsList = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        // Проходим по всем опциям и добавляем их текст в список
        for (WebElement option : optionsList) {
            optionTexts.add(option.getText());
        }
        // Выводим все тексты опций
        for (String text : optionTexts) {
            System.out.println("Option: " + text);
        }
        select.selectByVisibleText(value);
        return this;
    }


    public void printoutSelectList(WebElement element, List<WebElement> dropdownItems) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        webElementActions.waitElementToBeClickAble(element).click(element);
        ArrayList<String> itemList = new ArrayList<>();
        // Добавление всех текстов элементов в ArrayList
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
           // Выводим все тексты опций
        for (String text : itemList) {
        System.out.println("Option: " + text);
        }
    }

    public void printoutSelectList(WebElement element) {
        Select select = new Select(element);
        // Получение списка опций
        List<WebElement> options = select.getOptions();
        // Вывод всех опций
        for (WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }
    }
}
