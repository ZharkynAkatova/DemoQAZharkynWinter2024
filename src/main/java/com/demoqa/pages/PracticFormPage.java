package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticFormEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class PracticFormPage extends BasePage {

    @FindBy (id = "firstName")
    public WebElement firstNameInput;

    @FindBy (id = "lastName")
    public  WebElement lastNameInput;

    @FindBy (id = "userEmail")
    public WebElement emailInput;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[1]")
    public WebElement radio1;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[2]")
    public WebElement radio2;

    @FindBy (xpath = "(//div[@class = 'custom-control custom-radio custom-control-inline'])[3]")
    public WebElement radio3;

    @FindBy (id = "userNumber")
    public  WebElement mobileNumberInput;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;

    @FindBy (id = "dateOfBirthInput")
    public  WebElement dateOfBirthInput;

    @FindBy (id = "//*[@class=\"react-datepicker__month-select\"]")
    public WebElement monthOfBirthInput;

    @FindBy (id = "//*[@class=\"react-datepicker__year-select\"]")
    public WebElement yearOfBirthInput;

    @FindBy (id = "subjectsInput")
    public WebElement subjectsContainerInput;

    @FindBy (id = "uploadPicture")
    public  WebElement uploadPicture;

    @FindBy (id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy (id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy (id = "react-select-4-input")
    public  WebElement cityInput;

    @FindBy (id = "submit")
    public WebElement submitBtn;


    public PracticFormPage fillPracticForm(PracticFormEntity practicFormEntity) {
        webElementActions.sendKeys(firstNameInput, practicFormEntity.getFirstNameInput())
                .sendKeys(lastNameInput, practicFormEntity.getLastNameInput())
                .sendKeys(emailInput, practicFormEntity.getEmailInput())
                .jsClick(webElementActions.randomElementSelection("//input[@name ='gender']"))
                .sendKeys(mobileNumberInput, practicFormEntity.getMobileNumberInput())
                .sendKeysWithEnter(subjectsContainerInput, practicFormEntity.getSubjectsContainerInput())
                .clickRandomElements("//input[@type='checkbox']");
        webElementActions.sendKeys(uploadPicture, practicFormEntity.getPicturePath())
                .sendKeys(currentAddressInput, practicFormEntity.getCurrentAddressInput())
                .sendKeysWithEnter(stateInput, webElementActions.randomElementSelection("(//div[@class=' css-1hwfws3'])[1]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .sendKeysWithEnter(cityInput, webElementActions.randomElementSelection("(//div[@class=' css-1hwfws3'])[2]", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .click(submitBtn);
        return this;
    }

    public PracticFormPage selectDateMonthYear(String dateMonthYear){  // 04 Jun 2024
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5000));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        wait.until(ExpectedConditions.elementToBeClickable(monthDropDown));
        wait.until(ExpectedConditions.elementToBeClickable(yearDropDown));

        dropDownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);

        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(              // //div[contains(@class, 'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text() = '25']
                        "//div[contains(@class, 'react-datepicker__day') and not (contains(@class, 'day--outside-month')) and text() = '" + date + "']"
                )
        ));
        webElementActions.click(day);
        return this;
    }

}
