import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

public class DemoTest123 {

    @Test
    void demoTest123(){
        ConfigReader.getValue("browser");
        System.out.println(ConfigReader.getValue("browser"));
    }
}
