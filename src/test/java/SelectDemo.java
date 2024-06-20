import com.demoqa.helper.DropDownHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SelectDemo extends BaseTest{

    @Test
    void test123() throws InterruptedException {
     driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));

        DropDownHelper dropDownHelper = new DropDownHelper(driver);

        dropDownHelper.selectByVisibleText(selectMenu, "Green");

        Thread.sleep(4000);
    }

    @Test
    void testSelect1(){
        driver.get("https://demoqa.com/select-menu");
        // Печать списка
        dropDownHelper.printoutSelectList( demoQAPages.getSelectPage().selectValue,  demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelect2(){
        driver.get("https://demoqa.com/select-menu");
        // Печать списка
        dropDownHelper.printoutSelectList( demoQAPages.getSelectPage().selectOne,  demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelect3(){
        driver.get("https://demoqa.com/select-menu");
        // Печать списка
        dropDownHelper.printoutSelectList( demoQAPages.getSelectPage().selrctMultiselectDropDown,  demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelect4() {
        driver.get("https://demoqa.com/select-menu");
        dropDownHelper.printoutSelectList(demoQAPages.getSelectPage().oldSelectMenu);
    }

    @Test
    void testSelect5() {
        driver.get("https://demoqa.com/select-menu");
        dropDownHelper.printoutSelectList(demoQAPages.getSelectPage().StandardMultiSelect);
    }
}
