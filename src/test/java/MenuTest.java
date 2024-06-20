import org.testng.annotations.Test;

public class MenuTest extends BaseTest{

    @Test (description = "Verify move to element methods is working")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().MainItem2);
        Thread.sleep(5000);
    }
}
