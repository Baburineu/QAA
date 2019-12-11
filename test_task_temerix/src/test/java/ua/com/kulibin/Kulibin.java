package ua.com.kulibin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Kulibin extends WebDriverSettings  {

//    @DataProvider(name = )
//
//    public Object[][] dataProviderMethod() {
//
//        return new Object[][] { { "data one" }, { "data two" } };
//
//    }

    /*
    Test_1. в разделе "Электроинструменты" / "Дрели" на  трех товарах с акционным тикетом  проверить есть ли в карточке товара акционная цена
    Для этого, из раздела "Электроинструменты"  перейти в раздел "Дрели"  используя меню.
    Рандомно, на первой страничке выбрать товар, провалиться в карточку товара и проверить наличие акционной и старой цены
    Так для 3-х товаров (выбор количества проверяемых товаров сделать гибким)
    */
    @Test()
    public void test_1() {

//     for (int i = 0; i < 3; i++) {      // WHY? ¯\_(ツ)_/¯


        driver.get("https://kulibin.com.ua/");
        WebElement electroTool = driver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(electroTool).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/catalog/dreli/\"]")));
        driver.findElement(By.cssSelector("[href=\"/catalog/dreli/\"]")).click();

        List<WebElement> listProduct = driver.findElements(By.xpath("//ul[@class='catalog catalog-full js-catalog']/li"));

        Random random = new Random();
        int n = random.nextInt(14);

        listProduct.get(n).click();

        boolean checkPrise = driver.findElement(By.xpath("//div[@class=\"price-row\"]/span[@class='price']")).isDisplayed();
        if (checkPrise) System.out.println("The product has a price");
        else System.out.println("The product does't have a price");

        boolean checkOldPrise = driver.findElement(By.xpath("//div[@class=\"price-row\"]/span[@class='item_old_price old-price']")).isDisplayed();
        if (checkOldPrise) System.out.println("The product has an OLD price");
        else System.out.println("The product does't have an OLD price");

//        System.out.println("Iteration " + i);
//        driver.quit();
//     }
    }


    @Test
    public void simpleTest() {

        driver.get("https://kulibin.com.ua/");

        String title = driver.getTitle();

        //Проверка тайтла
        Assert.assertEquals(title, "Интернет-магазин Кулибин. Профессиональные инструменты, садовая техника, сварочное оборудование.");

        //Verify Color is Yellow
        WebElement verifyColor = driver.findElement(By.id("catalog-menu"));
        Assert.assertEquals("rgb(72, 75, 84)",
        verifyColor.getCssValue("color"),toString());

    }

    @Test
    public void search() {

        driver.get("https://kulibin.com.ua/");
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"top-title-search-input\"]"));
        searchField.clear();
        searchField.sendKeys("Перфоратор");

        WebElement searchButton = driver.findElement(By.cssSelector("#top-title-search > form > button"));
        searchButton.click();

        //Ожидание
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


 /*
    Test_2. Перейти в раздел "Электроинструменты" / "Перфораторы"
    Проверить, что у всех товаров этого раздела есть цена на первых двух страницах.
*/

/*
        // Проверка количества элементов
        if (driver.findElements(By.xpath("//div [@class=\"price-row\"]/span[@class='price']")).size() > 0) System.out.println("The product has a price");
            else System.out.println("The product does't have a price");

        if (driver.findElements(By.xpath("//span[@class='item_old_price old-price']")).size() > 0) System.out.println("The product has an old price");
            else System.out.println("The product does't have an OLD price");

*/


/*
    Test_3. Перейти в раздел "Электроинструменты" / "Шуруповерты"
    Вывести "Наименование" всех товаров у которых есть иконка с американским флагом на первых 3х страницах
*/


/*
    Test_4. В разделе "Электроинструменты" / "Болгарки"
    Для 10 рандомных товаров с пометкой "Акция" провести расчет акционной цены относительно старой.
    В assert упавшего теста вывести наименование товара его ожидаемую и фактическую цену.
*/

}
