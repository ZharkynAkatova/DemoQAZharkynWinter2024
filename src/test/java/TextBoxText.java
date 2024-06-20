
import com.demoqa.entities.TextBoxEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxText  extends BaseTest {

    @Test
    public void textBoxText() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        demoQAPages.getTextBoxPages().fillUpTextBoxForm(textBoxEntity);
        Thread.sleep(3000);
        Assert.assertTrue(true);
    }
}
