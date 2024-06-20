import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(com.demoqa.listener.ScreenshotListener.class)
public class ButtonsTest extends BaseTest{

    @Test(groups = {"Smoke", "API", "1700"}, description = "Verify double click button is working propertly")
    @Step
    public void doubleClickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText().trim(), "You have done a double click");
    }

    @Test(description = "Verify right click button is working propertly")
    @Step
    public void rightClickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText().trim(), "You have done a right click");
    }
}
