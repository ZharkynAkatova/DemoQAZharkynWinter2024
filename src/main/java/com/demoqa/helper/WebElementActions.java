package com.demoqa.helper;
import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebElementActions {

    // Отвечает для того чтобы, мы могли больше взаимодействовать с мышкой
    public Actions actions;

    public WebElementActions() {
        this.actions = new Actions(DriverManager.getDriver());
    }

    @BeforeClass (alwaysRun = true)
    public void init(){
         this.actions = new Actions(DriverManager.getDriver());
    }

    // метод кликает
    public WebElementActions click(WebElement element){
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public String getText(WebElement element){
        waitElementToBeVisible(element);
        return element.getText();

    }

    // Метод для добавления задержки
    public void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // заполняет элемент
    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        highlightElement(element);
        element.sendKeys(txt); //с element передаем в txt
        return this;
    }
    // заполняет элемент и нажимает Enter
    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.sendKeys(txt); //с element передаем в txt
        element.sendKeys(Keys.ENTER);//в sendKeys передаем клавиатуру и дальше выбираем какую кнопку хотим нажать
        return this;
    }

    // ждет пока элемент не станет кликабельным
    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    // ждет пока элемент не станет видимым
    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    // метод находит все элементы по указанному xPath, ложит их в лист
    // рандомно выбирает один из элементов
    public WebElement randomElementSelection(String xPath){
        List<WebElement> list = DriverManager.getDriver().findElements(By.xpath(xPath));
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    // метод находит все элементы по указанному xPath, ложит их в лист
    // рандомно выбирает один или несколько элементов, и кликает на них
    public void clickRandomElements(String xpath) {
        List<WebElement> list = DriverManager.getDriver().findElements(By.xpath(xpath));
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Элементы не найдены");
        }
        Random random = new Random();
        int index1 = random.nextInt(list.size()) + 1; // Добавляем 1, чтобы index1 был как минимум 1
        List<WebElement> randomElements = new ArrayList<>();
        for (int i = 0; i < index1; i++) {
            int index = random.nextInt(list.size());
            randomElements.add(list.get(index));
            list.remove(index); // Удаляем выбранный элемент из списка, чтобы не выбрать его снова
        }
        for (WebElement element : randomElements) {
            jsClick(element);
        }
    }

    // метод находит элемент по указанному xPath, кликая на него раскрывает всплывающий список
    // по указанному xPath ложит весь всплывающий список в лист
    // рандомно выбирает один из элементов
    public String randomElementSelection(String xpathDropdownControl, String xpathDropdownItems){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        // Нахождение контроллера списка и открытие списка
        WebElement dropdownControl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDropdownControl)));
        dropdownControl.click();
        // Явное ожидание появления элементов списка
        List<WebElement> dropdownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathDropdownItems)));
        // Создание списка для хранения текстов элементов
        ArrayList<String> itemList = new ArrayList<>();
        // Добавление всех текстов элементов в ArrayList
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
        Random random = new Random();
        int index = random.nextInt(itemList.size());
        return itemList.get(index);
    }


    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        return this;
    }

    public WebElementActions jsSendkeys(WebElement element, String txt) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", element, txt);
        return this;
    }

    @Step ("double click {0}")
    public WebElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }
    @Step ("right click {0}")
    public WebElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element){
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public WebElementActions clearAndSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        return this;
    }

}
