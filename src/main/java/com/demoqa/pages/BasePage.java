package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.DropDownHelper;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    // используя драйвер, инициализирует поля заданного класса
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // создаем объект класса для унаслелования
    public WebElementActions webElementActions = new WebElementActions();

    public AlertHelper alertHelper = new AlertHelper(DriverManager.getDriver());

    public DropDownHelper dropDownHelper= new DropDownHelper(DriverManager.getDriver());


}
