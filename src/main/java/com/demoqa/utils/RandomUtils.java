package com.demoqa.utils;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity(){
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticFormEntity generateRandomPracticFormEntity(){
        PracticFormEntity practicFormEntity = new PracticFormEntity();
        practicFormEntity.setFirstNameInput(faker.name().firstName());
        practicFormEntity.setLastNameInput(faker.name().lastName());
        practicFormEntity.setEmailInput(faker.internet().emailAddress());
        practicFormEntity.setMobileNumberInput(faker.phoneNumber().subscriberNumber(10));
        practicFormEntity.setSubjectsContainerInput("Math");
        practicFormEntity.setCurrentAddressInput(faker.address().fullAddress());
        practicFormEntity.setPicturePath ("C:\\Users\\user\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\pictures\\Кот_с_наушниками.jpg");
        return practicFormEntity;
    }

    public static Employee createMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
//      employee.setEmail("kierra@example.com");
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setSalary(faker.number().numberBetween(1000000l,20000000l));
        employee.setDepartment(faker.job().position());
        return employee;
    }
}

