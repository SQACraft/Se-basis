package lifeCart.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeoZonesSort extends TestBase {

    @Test
    void countriesListSort() {

        click(By.cssSelector("[href$=geo_zones]"));
        click(By.cssSelector("[name=geo_zones_form] [href$='id=1']"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Edit Geo Zone')]")));
        By locator = (By.cssSelector("table#table-zones [name*=zone_code] [selected=selected]"));

        List<WebElement> geozoneLinks = wd.findElements(locator);  //  список всех ссылок со странами на сайте
        System.out.println("\nРазмер списка геозон : " + geozoneLinks.size()); //      // вывод в консоль размера списка ссылок

        ArrayList<String> AUT = new ArrayList<>();  // пустой массив  наименований стран  на сайте
        ArrayList<String> forSort = new ArrayList<>();  // пустой массив  наименований стран   (для сортировки)

        for (WebElement i : geozoneLinks) {                                     // перебор списка ссылок со странами
            String country = i.getAttribute("textContent");          // считываем атрибут с названием страны
            forSort.add(country);                                              //  добавляем страну в массив forSort
            AUT.add(country);                                                 //  добавляем страну в массив AUT
        }

        System.out.println("Размер массива стран : " + AUT.size());             // вывод в консоль размера массива  стран

        Collections.sort(forSort);                                                             // сортируем массив

        String stringAUT = ArrayToString(AUT);
        System.out.println("\nМассив на сайте :           " + stringAUT);  // вывод в консоль строкового значения массива AUT

        String stringForSort = ArrayToString(forSort);
        System.out.println("Отсортированный массив :" + stringForSort); // вывод в консоль строкового значения массива forSort

        Assert.assertEquals(stringAUT, stringForSort);              // сравниваем строковые значения массивов. Если true, то сортировка на сайте правильная.
    }

}

