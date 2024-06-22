import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.demoqa.listener.ScreenshotListener.class)
public class MenuTest extends BaseTest{

    @Test (description = "Verify move to element methods is working")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().MainItem2);
        Thread.sleep(5000);
    }
}
