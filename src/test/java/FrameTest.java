import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.demoqa.listener.ScreenshotListener.class)
public class FrameTest extends BaseTest{

    @Test (description = "Verify that driver can switch to another frame")
    public void test123(){
        browserHelper.open("https://demoqa.com/frames");
        iframeHelper.switchToFrame("frame1");
        iframeHelper.switchToParentFrame();
    }

}
