import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.demoqa.listener.ScreenshotListener.class)
public class DemoTest123 {

    @Test
    void demoTest123(){
        ConfigReader.getValue("browser");
        System.out.println(ConfigReader.getValue("browser"));
    }
}
