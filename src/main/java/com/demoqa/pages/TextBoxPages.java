package com.demoqa.pages;

import com.demoqa.entities.TextBoxEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPages extends BasePage {

    // без PageFactory аннотация FindBy не работает
    @FindBy(id = "userName") // найти с помощью
    public WebElement fullNameInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPages fillUpTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress) {
        webElementActions.sendKeys(fullNameInput, fullName)
                .sendKeys(emailInput, email)
                .sendKeys(currentAddressInput, currentAddress)
                .sendKeys(permanentAddressInput, permanentAddress)
                .click(submitBtn);
        return this;
    }

    public TextBoxPages fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.sendKeys(fullNameInput, textBoxEntity.getFullName())
                .sendKeys(emailInput, textBoxEntity.getEmail())
                .sendKeys(currentAddressInput,textBoxEntity.getCurrentAddress())
                .sendKeys(permanentAddressInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
    }
}
