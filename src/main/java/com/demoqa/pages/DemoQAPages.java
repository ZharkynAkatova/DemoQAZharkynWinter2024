package com.demoqa.pages;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder

public class DemoQAPages {
    protected TextBoxPages textBoxPages;
    protected PracticFormPage practicFormPage;
    protected AlertPage alertPage;
    protected ProgressBarPage progressBarPage;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage;
    protected SelectPage selectPage;
    protected WebTablesPage webTablesPage;

    public void setUp(){
        textBoxPages = new TextBoxPages();
        alertPage = new AlertPage();
        practicFormPage = new PracticFormPage();
        progressBarPage = new ProgressBarPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        selectPage = new SelectPage();
        webTablesPage = new WebTablesPage();
    }

}
