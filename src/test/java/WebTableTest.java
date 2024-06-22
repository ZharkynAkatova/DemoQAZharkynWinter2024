import com.demoqa.entities.Employee;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;
@Listeners(com.demoqa.listener.ScreenshotListener.class)

public class WebTableTest extends BaseTest{

        @Test(description = "WebTable Test")
    public void test123() throws Exception {
        browserHelper.open("https://demoqa.com/webtables");
        List<Employee> employees = demoQAPages.getWebTablesPage().getEmployeesAndEmailFromTable();
        for (Employee employee: employees) {
            System.out.println(employee);
        }
        for (String employee: demoQAPages.getWebTablesPage().emails) {
            System.out.println(employee);
        }

    }
    @Test (description = "WebTable Testing adding and removing from a list")
    public void test1234() throws Exception {

        browserHelper.open("https://demoqa.com/webtables");

        demoQAPages.getWebTablesPage().addNewEmployee(randomUtils.createMockEmployee());

        List<Employee> employees1 = demoQAPages.getWebTablesPage().getEmployeesAndEmailFromTable();

        for (Employee employee: employees1) {
            System.out.println(employee);
        }

        System.out.println("");

        for (String email: demoQAPages.getWebTablesPage().emails) {
            System.out.println(email);
        }
        System.out.println("");
        Thread.sleep(5000);
        demoQAPages.getWebTablesPage().removeFromList();
        List<Employee> employees = demoQAPages.getWebTablesPage().getEmployeesAndEmailFromTable();
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    @Test(description = "WebTable Testing editing random fields")
    public void testEditRandomFields() throws Exception {
        browserHelper.open("https://demoqa.com/webtables");
        List<Employee> employees1 = demoQAPages.getWebTablesPage().getEmployeesAndEmailFromTable();

        for (Employee employee: employees1) {
            System.out.println(employee);
        }
        System.out.println("");
        demoQAPages.getWebTablesPage().editRandomFields();

        List<Employee> employees = demoQAPages.getWebTablesPage().getEmployeesAndEmailFromTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }






}
