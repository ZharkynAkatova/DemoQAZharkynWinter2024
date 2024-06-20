package com.demoqa.helper;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper (WebDriver driver) {
        this.driver = driver;
    }
    // открывает страницу по указанной ссылке
    public void open(String url){
        driver.navigate().to(url);  // в отличии от метода get() -  navigate().to(url) - запоминает всю историю посещения сайтов
    }

    // переведет в предыдущую страницу
    public void goBack(){
       driver.navigate().back();
    }

    // переведет в следующую страницу
    public void goForward(){
        driver.navigate().forward();
    }

    // обновить страницу
    public void refreshThePage(){
        driver.navigate().refresh();
    }

    //сохраняет все открытые вкладки по порядку открытия
    public Set<String> getWindowHandels(){
        return  driver.getWindowHandles();
    }

    // переходит в нужную вкладку по указанному индексу
    public void switchToWindow(int index) {
        LinkedList<String> windowId = new LinkedList<>(getWindowHandels());

        if (index < 0 || index > windowId.size())
            throw new IllegalArgumentException("Invalid index : " + index);

        driver.switchTo().window(windowId.get(index));
    }

    // переходит в родительскую вкладку
    public void switchToParentWindow(){
        LinkedList<String> windowId = new LinkedList<>(getWindowHandels());
        driver.switchTo().window(windowId.get(0));
    }

    // переходит в родительскую вкладку и закроет все остальные вкладки
    public void switchToParentWithChildClose(){
        switchToParentWindow();
        LinkedList<String> windowId = new LinkedList<>(getWindowHandels());
        for(int i = 1; i < windowId.size(); i++){
            driver.switchTo().window(windowId.get(i));
            driver.close();
        }
        switchToParentWindow();
    }


}
