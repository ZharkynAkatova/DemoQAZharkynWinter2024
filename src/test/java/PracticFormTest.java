import com.demoqa.entities.PracticFormEntity;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
//@Listeners(com.demoqa.listener.ScreenshotListener.class)

public class  PracticFormTest extends BaseTest {

    @Test
    public void textBoxText(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        PracticFormEntity practicFormEntity = randomUtils.generateRandomPracticFormEntity();
        demoQAPages.getPracticFormPage().fillPracticForm(practicFormEntity);
    }

    @Test
    public void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/automation-practice-form");

        demoQAPages.getPracticFormPage().selectDateMonthYear("30 September 2020");
        Thread.sleep(7000);
    }
}
