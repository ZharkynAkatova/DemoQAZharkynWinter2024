
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test(groups = {"Smoke", "UI", "1721"}, description = "Alert test")
    void alertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        // Клик по кнопке, которая вызывает алерт
        webElementActions.click(demoQAPages.getAlertPage().promtButton);
        Thread.sleep(3000);
        alertHelper.acceptPrompt("ads");
        Thread.sleep(3000);
     }

    @Test(groups = {"Regression", "API", "1722"}, description = "Alert test 1")
    void alertTest1() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);
    }

    @Test(groups = {"E2E", "SQL", "1723"}, description = "Alert test 2")
    void alertTest2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);
    }
}
