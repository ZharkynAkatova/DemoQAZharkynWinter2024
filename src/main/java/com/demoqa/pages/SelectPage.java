package com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectPage extends BasePage{

    @FindBy(xpath = "(//div[@class =  ' css-yk16xz-control'])[1]")
    public WebElement selectValue;

    @FindBy(xpath = "//div[contains(@class,'option')]")
    public List<WebElement> selectValueOptions;

    @FindBy(xpath = "(//div[@class =  ' css-yk16xz-control'])[2]")
    public WebElement selectOne;

    @FindBy(xpath = "(//div[@class =  ' css-yk16xz-control'])[3]")
    public WebElement selrctMultiselectDropDown;

    @FindBy (id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy (id = "cars")
    public WebElement StandardMultiSelect;

}
