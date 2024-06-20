package com.demoqa.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class KoverSamoletList_HW {

    WebDriver driver;
    WebElement restoranPishpek;

    @BeforeClass
    void openBrowsers(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @AfterClass
    void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }

        @Test
        public void openLinks() throws Exception {
            WebElement mainmenu = driver.findElement(By.xpath("//*[@id='tab-01']/div/p/a/img"));
            mainmenu.click();

            List <WebElement> listOfRest = driver.findElements(By.xpath("//div[(@class ='col-sm-6')]/div/div/p[1]"));

            for (WebElement rest : listOfRest) {
                 if(rest.getText().equals("Ресторан Пишпек")){
                    restoranPishpek = driver.findElement(By.xpath("//*[text()='Ресторан Пишпек']/parent::div/following-sibling::div[1]/div[2]/a"));
                    restoranPishpek.click();

                     // Завтраки
                     WebElement breakfast = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']"));
                     breakfast.click();
                     WebElement breakfastHeader = driver.findElement(By.xpath("//h2[a[@name='menu_0']]"));
                     System.out.println(breakfastHeader.getText());
                     WebElement productBreakfast = breakfastHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuBreakfast = productBreakfast.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuBreakfast.stream().forEach(s -> System.out.println(s.getText()));

                     // Холодные закуски
                     WebElement coldSnacks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']"));
                     coldSnacks.click();
                     WebElement coldSnacksHeader = driver.findElement(By.xpath("//h2[a[@name='menu_1']]"));
                     System.out.println("\n"+ coldSnacksHeader.getText());
                     WebElement productColdSnacks = coldSnacksHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuColdSnacks = productColdSnacks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuColdSnacks.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);
                     // Салаты
                     WebElement salads = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']"));
                     salads.click();
                     WebElement saladsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_2']]"));
                     System.out.println("\n"+ saladsHeader.getText());
                     WebElement productSalads = saladsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuSalads = productSalads.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuSalads.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Супы
                     WebElement Soups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']"));
                     Soups.click();
                     WebElement textSoups = driver.findElement(By.xpath("//h2[a[@name='menu_3']]"));
                     System.out.println(" " + " " + textSoups.getText());
                     WebElement listSoups = textSoups.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuSoups = listSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuSoups.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Горячие блюда восточной кухни
                     WebElement orientalDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']"));
                     orientalDishes.click();
                     WebElement orientalDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_4']]"));
                     System.out.println("\n"+ orientalDishesHeader.getText());
                     WebElement productOrientalDishes = orientalDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuOrientalDishes = productOrientalDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuOrientalDishes.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);


                     // Крем супы
                     WebElement creamSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']"));
                     creamSoups.click();
                     WebElement creamSoupsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_5']]"));
                     System.out.println("\n"+ creamSoupsHeader.getText());
                     WebElement productCreamSoups = creamSoupsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuCreamSoups = productCreamSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuCreamSoups.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Восточные супы
                     WebElement orientalSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']"));
                     orientalSoups.click();
                     WebElement orientalSoupsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_6']]"));
                     System.out.println("\n"+ orientalSoupsHeader.getText());
                     WebElement productOrientalSoups = orientalSoupsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuOrientalSoups = productOrientalSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuOrientalSoups.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Горячие закуски
                     WebElement HotAppetizers = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']"));
                     HotAppetizers.click();
                     WebElement HotAppetizersHeader = driver.findElement(By.xpath("//h2[a[@name='menu_7']]"));
                     System.out.println("\n"+ HotAppetizersHeader.getText());
                     WebElement productHotAppetizers = HotAppetizersHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuHotAppetizers = productHotAppetizers.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuHotAppetizers.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Выпечка
                     WebElement bakery = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']"));
                     bakery.click();
                     WebElement bakeryHeader = driver.findElement(By.xpath("//h2[a[@name='menu_8']]"));
                     System.out.println("\n"+ bakeryHeader.getText());
                     WebElement productBakery = bakeryHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuBakery = productBakery.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuBakery.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Паста
                     WebElement paste = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']"));
                     paste.click();
                     WebElement pasteHeader = driver.findElement(By.xpath("//h2[a[@name='menu_9']]"));
                     System.out.println("\n"+ pasteHeader.getText());
                     WebElement productPaste = pasteHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuPaste = productPaste.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuPaste.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Стейки
                     WebElement steaks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']"));
                     steaks.click();
                     WebElement steaksHeader = driver.findElement(By.xpath("//h2[a[@name='menu_10']]"));
                     System.out.println("\n"+ steaksHeader.getText());
                     WebElement productSteaks = steaksHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuSteaks = productSteaks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuSteaks.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Горячие блюда европейской кухни
                     WebElement hotEuropeanDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']"));
                     hotEuropeanDishes.click();
                     WebElement HotEuropeanDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_11']]"));
                     System.out.println("\n" + HotEuropeanDishesHeader.getText());
                     WebElement productHotEuropeanDishes = HotEuropeanDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuHotEuropeanDishes = productHotEuropeanDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuHotEuropeanDishes.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Блюда из рыбы
                     WebElement fishDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']"));
                     fishDishes.click();
                     WebElement fishDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_12']]"));
                     System.out.println("\n"+ fishDishesHeader.getText());
                     WebElement productFishDishes = fishDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuFishDishes = productFishDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuFishDishes.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Шашлыки
                     WebElement kebabs = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']"));
                     kebabs.click();
                     WebElement kebabsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_13']]"));
                     System.out.println("\n"+ kebabsHeader.getText());
                     WebElement productKebabs = kebabsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuKebabs = productKebabs.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuKebabs.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Блюда на компанию
                     WebElement dishesForACompany = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']"));
                     dishesForACompany.click();
                     WebElement dishesForACompanyHeader = driver.findElement(By.xpath("//h2[a[@name='menu_14']]"));
                     System.out.println("\n"+ dishesForACompanyHeader.getText());
                     WebElement productdishesForACompany = dishesForACompanyHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuDishesForACompany = productdishesForACompany.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuDishesForACompany.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Гарниры
                     WebElement sideDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']"));
                     sideDishes.click();
                     WebElement sideDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_15']]"));
                     System.out.println("\n"+ sideDishesHeader.getText());
                     WebElement productSideDishes = sideDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuSideDishes = productSideDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuSideDishes.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Соусы
                     WebElement Sauces = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']"));
                     Sauces.click();
                     WebElement textSauces = driver.findElement(By.xpath("//h2[a[@name='menu_16']]"));
                     System.out.println(" " + " " + textSauces.getText());
                     WebElement listSauces = textSauces.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuSauces = listSauces.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuSauces.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // пицца
                     WebElement pizza = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']"));
                     pizza.click();
                     WebElement pizzaHeader = driver.findElement(By.xpath("//h2[a[@name='menu_17']]"));
                     System.out.println("\n" + pizzaHeader.getText());
                     WebElement productPizza = pizzaHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuPizza = productPizza.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuPizza.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);


                     //Десерты
                     WebElement dessert = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']"));
                     dessert.click();
                     WebElement dessertHeader = driver.findElement(By.xpath("//h2[a[@name='menu_18']]"));
                     System.out.println("\n"+ dessertHeader.getText());
                     WebElement productDessert = dessertHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuDessert = productDessert.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuDessert.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     // Роллы
                     WebElement Rolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']"));
                     Rolls.click();
                     WebElement textRolls = driver.findElement(By.xpath("//h2[a[@name='menu_19']]"));
                     System.out.println(" " + " " + textRolls.getText());
                     WebElement listRolls = textRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuRolls = listRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuRolls.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);


                     //Горячие роллы
                     WebElement hotRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']"));
                     hotRolls.click();
                     WebElement hotRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_20']]"));
                     System.out.println("\n"+ hotRollsHeader.getText());
                     WebElement productHotRolls = hotRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuHotRolls = productHotRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuHotRolls.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Классические роллы
                     WebElement classicRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']"));
                     classicRolls.click();
                     WebElement classicRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_21']]"));
                     System.out.println("\n"+ classicRollsHeader.getText());
                     WebElement productClassicRolls = classicRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuClassicRolls = productClassicRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuClassicRolls.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Ассорти из ролл
                     WebElement assortedRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']"));
                     assortedRolls.click();
                     WebElement assortedRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_22']]"));
                     System.out.println("\n"+ assortedRollsHeader.getText());
                     WebElement productAssortedRolls = assortedRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuAssortedRolls = productAssortedRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuAssortedRolls.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Лимонады
                     WebElement lemonades = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']"));
                     lemonades.click();
                     WebElement lemonadesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_23']]"));
                     System.out.println("\n" + lemonadesHeader.getText());
                     WebElement productLemonades = lemonadesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuLemonades = productLemonades.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuLemonades.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);

                     //Холодные напитки
                     WebElement ColdВrinks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']"));
                     ColdВrinks.click();
                     WebElement textColdВrinks = driver.findElement(By.xpath("//h2[a[@name='menu_24']]"));
                     System.out.println(" " + " " + textColdВrinks.getText());
                     WebElement listColdВrinks = textColdВrinks.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
                     List<WebElement> menuColdВrinks = listColdВrinks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
                     menuColdВrinks.stream()
                             .map(WebElement::getText)
                             .forEach(System.out::println);
                     break;
                 } else
                     throw new Exception("Ресторан закрыт");
            }
        }
}
