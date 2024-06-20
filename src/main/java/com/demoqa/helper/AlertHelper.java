package com.demoqa.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    // объявляем driver
    private WebDriver driver;

    // конструктор класса
    public AlertHelper(WebDriver driver){
        this.driver = driver;
    }

    // переключается на Alert (в переводе предупреждение)
    public Alert getAlert(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    // принимаем согласие - Ok
    public void  acceptAlert(){
        getAlert().accept();
    }

    // Не принимаем согласие - Cancel
    public void  dismissAlert(){
        getAlert().dismiss();
    }

    // извлекает текст от алерта
    public String getAlertText(){
        return getAlert().getText();
    }

    // проверяет есть ли алерт
    public boolean isAlertPresented(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // сначала проверяет, есть ли алерт, если есть соглашается
    public void acceptAlertIfPresented(){
        if (!isAlertPresented())
            return;
        acceptAlert();
    }

    // сначала проверяет, есть ли алерт, если есть отклоняет
    public void dissmissAlertIfPresented(){
        if (!isAlertPresented())
            return;
        dismissAlert();
    }

    // alert с вводом строки и принимаем согласие - Ok
    public void acceptPrompt(String txt){
        if (!isAlertPresented())
            return;
        Alert alert = getAlert();
        alert.sendKeys(txt);
        alert.accept();
    }

    // alert с вводом строки и не принимаем согласие - Cancel
    public void dissmisPrompt(String txt){
        if (!isAlertPresented())
            return;
        Alert alert = getAlert();
        alert.sendKeys(txt);
        alert.dismiss();
    }
}
