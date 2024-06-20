package com.demoqa.pages;
import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    private int index;

    public ArrayList<String> emails = new ArrayList<>();


    // добавляем сотрудника проверяя в списке на наличие похожего email
    public WebTablesPage addNewEmployee(Employee employee) throws Exception {
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment());
        getEmployeesAndEmailFromTable();
        if (emails.contains(employee.getEmail())) {
            throw new Exception("Сотрудник с таким email уже существует!");
        } else {
           webElementActions.click(submitBtn);
        }
        return this;
    }

    // получаем список сотрудников
    public ArrayList<Employee> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

    // получаем список сотрудников и отдельный список их email
    public ArrayList<Employee> getEmployeesAndEmailFromTable() throws Exception {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            if (!emails.contains(email)) { // Проверяем на уникальность перед добавлением
                emails.add(email);
            }
            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }

        // удаление из списка. Рандомно выбирает email, по выбранному email сформирует xPath нужной кнопки удаления и нажимает
    public void removeFromList () {

            if (emails.isEmpty()) {
                System.out.println("Список email пуст.");
                return;
            }

            Random random = new Random();
            int index = random.nextInt(emails.size());
            String email = emails.get(index);

            System.out.println("Выбранный индекс: " + index + ", Email: " + email);

            for (int i = 0; i < emails.size(); i++) {
                if (emails.get(i).equals(email)) {
                    String xpath = String.format("//*[@id='delete-record-%d']", i + 1);
                    System.out.println("Сформированный XPath: " + xpath);
                    try {
                        WebElement deleteBtn = DriverManager.getDriver().findElement(By.xpath(xpath));
                        webElementActions.jsClick(deleteBtn);
                        System.out.println("Элемент удалён: " + email);
                        emails.remove(email); // Удаляем email из списка после успешного удаления элемента
                    } catch (NoSuchElementException e) {
                        System.out.println("Элемент не найден для удаления: " + email);
                    }
                    break;
                }
            }
    }

    // редактирование полей. Рандомно выбираем сотрудника и рандомно выбираем несколько полей для редактирования
    public void editRandomFields() throws Exception {
        // Получаем список сотрудников
        List<Employee> employees = getEmployeesAndEmailFromTable();
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        // Рандомно выбираем сотрудника из списка
        Random random = new Random();
        index = random.nextInt(employees.size());
        Employee randomEmployee = employees.get(index);

        System.out.println("Выбранный сотрудник для редактирования: " + randomEmployee);

        // Случайно выбираем количество полей для редактирования (от 1 до 6 полей)
        int numFieldsToEdit = random.nextInt(6) + 1;

        // Создаем новый объект Employee с новыми значениями полей
        Employee newValues = RandomUtils.createMockEmployee();

        Set<Integer> chosenIndices = new HashSet<>();

        // Открываем форму редактирования сотрудника
        String xpath = String.format("//*[@id='edit-record-%d']", index + 1);
        WebElement editButton = DriverManager.getDriver().findElement(By.xpath(xpath));
        webElementActions.jsClick(editButton);

        for (int i = 0; i < numFieldsToEdit; i++) {
            // Генерируем случайное поле для редактирования, которое еще не было выбрано
            int fieldIndex = random.nextInt(6);
            while (chosenIndices.contains(fieldIndex)) {
                fieldIndex = random.nextInt(6);
            }
            chosenIndices.add(fieldIndex);

            System.out.println("Chosen field index: " + fieldIndex); // Возможные индексы: 0 - firstName, 1 - lastName, 2 - age, 3 - email, 4 - salary, 5 - department

            String fieldName = "";

            switch (fieldIndex) {
                case 0:
                    fieldName = "firstName";
                    webElementActions.clearAndSendKeys(firstNameInput, newValues.getFirstName());
                    randomEmployee.setFirstName(newValues.getFirstName());
                    break;
                case 1:
                    fieldName = "lastName";
                    webElementActions.clearAndSendKeys(lastNameInput, newValues.getLastName());
                    randomEmployee.setLastName(newValues.getLastName());
                    break;
                case 2:
                    fieldName = "age";
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newValues.getAge()));
                    randomEmployee.setAge(newValues.getAge());
                    break;
                case 3:
                    fieldName = "email";
                    webElementActions.clearAndSendKeys(emailInput, newValues.getEmail());
                    randomEmployee.setEmail(newValues.getEmail());
                    break;
                case 4:
                    fieldName = "salary";
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newValues.getSalary()));
                    randomEmployee.setSalary(newValues.getSalary());
                    break;
                case 5:
                    fieldName = "department";
                    webElementActions.clearAndSendKeys(departmentInput, newValues.getDepartment());
                    randomEmployee.setDepartment(newValues.getDepartment());
                    break;
                default:
                    System.out.println("Неверный индекс поля.");
                    return;
            }
            System.out.println("Обновлено поле '" + fieldName + "' для сотрудника: " + randomEmployee.getFirstName() + " " + randomEmployee.getLastName());
        }
        // Сохраняем изменения
        webElementActions.jsClick(submitBtn);
    }
}
