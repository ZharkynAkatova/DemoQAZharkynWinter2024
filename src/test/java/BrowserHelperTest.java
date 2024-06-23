import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.demoqa.listener.ScreenshotListener.class)
public class BrowserHelperTest  extends  BaseTest{

    @Test (groups = {"Smoke", "UI", "1724"}, description = "test123")
    void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
        driver.findElement(By.xpath("//span[text() = 'Alerts']")).click();
        Thread.sleep(2000);
        browserHelper.goBack();
        Thread.sleep(2000);
        browserHelper.goForward();
        Thread.sleep(2000);
        browserHelper.refreshThePage();
    }

    @Test (groups = {"Smoke", "UI", "1725"}, description = "test12")
    void test12() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        browserHelper.switchToWindow(0);
        Thread.sleep(3000);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        browserHelper.switchToWindow(0);
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        browserHelper.switchToWindow(2);
        Thread.sleep(3000);

        browserHelper.switchToParentWithChildClose();
        Thread.sleep(63000);
    }

}
