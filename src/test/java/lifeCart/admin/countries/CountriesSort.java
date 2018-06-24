package lifeCart.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountriesSort extends TestBase {

    @Test
    void countriesListSort() {

        click(By.cssSelector("[href$=countries]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Countries')]")));
        By locator = (By.cssSelector("td#content a:not([title=Edit])"));

        List<WebElement> countryLinks = wd.findElements(locator);  //  список всех ссылок со странами на сайте
        System.out.println("\nРазмер списка ссылок : " + countryLinks.size()); //      // вывод в консоль размера списка ссылок

        ArrayList<String> AUT = new ArrayList<>();  // пустой массив  наименований стран  на сайте
        ArrayList<String> forSort = new ArrayList<>();  // пустой массив  наименований стран   (для сортировки)

        for (WebElement i : countryLinks) {                                     // перебор списка ссылок со странами
            String country = i.getAttribute("textContent");          // считываем атрибут с названием страны
            forSort.add(country);                                              //  добавляем страну в массив forSort
            AUT.add(country);                                                 //  добавляем страну в массив AUT
        }

        System.out.println("Размер массива стран : " + AUT.size());             // вывод в консоль размера массива  стран

        Collections.sort(forSort);                             // сортируем массив

        String stringAUT = ArrayToString(AUT);
        System.out.println("\nМассив на сайте :           " + stringAUT);  // вывод в консоль строкового значения массива AUT

        String stringForSort = ArrayToString(forSort);
        System.out.println("Отсортированный массив :" + stringForSort); // вывод в консоль строкового значения массива forSort

        Assert.assertEquals(stringForSort, stringAUT);              // сравниваем строковые значения массивов. Если true, то сортировка на сайте правильная.
    }

}
