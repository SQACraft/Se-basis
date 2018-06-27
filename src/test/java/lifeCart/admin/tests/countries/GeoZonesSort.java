package lifeCart.admin.tests.countries;

import lifeCart.admin.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeoZonesSort extends ToolBox {

    @Test
    void sortGZInGeozonesSection() {

        click(By.cssSelector("[href$=geo_zones]"));
        click(By.cssSelector("[name=geo_zones_form] [href$='id=1']"));                                         // Страница геозон Канады
        validateByOuterText(By.cssSelector("#content h1")," Edit Geo Zone");              // Валидация заголовка

        By locator = (By.cssSelector("table#table-zones [name*=zone_code]  [selected=selected]"));

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

        String stringAUT = arrayListToString(AUT);
        System.out.println("\nМассив на сайте :           " + stringAUT);  // вывод в консоль строкового значения массива AUT

        String stringForSort = arrayListToString(forSort);
        System.out.println("Отсортированный массив :" + stringForSort); // вывод в консоль строкового значения массива forSort

        Assert.assertEquals(stringAUT, stringForSort);              // сравниваем строковые значения массивов. Если true, то сортировка на сайте правильная.
    }

    @Test
    void sortGZInCountrySection() {

        click(By.cssSelector("[href$=countries]"));
        click(By.cssSelector("[name=countries_form] [href$='code=CA']"));                                         // Список стран
        validateByOuterText(By.cssSelector("#content h1")," Edit Country");         // Валидация заголовка

        By locator = (By.cssSelector("table#table-zones input:not([type=text])[name*=name]")); // локатор ищет все зоны, кроме шаблона для добавления

        List<WebElement> geozoneLinks = wd.findElements(locator);  //  список всех ссылок со странами на сайте
        System.out.println("\nРазмер списка геозон : " + geozoneLinks.size()); //      // вывод в консоль размера списка ссылок

        ArrayList<String> AUT = new ArrayList<>();  // пустой массив  наименований геозон  на сайте
        ArrayList<String> forSort = new ArrayList<>();  // пустой массив  наименований геозон   (для сортировки)

        for (WebElement i : geozoneLinks) {                                     // перебор списка ссылок со странами
            String gzone = i.getAttribute("value");          // считываем атрибут с названием страны
            forSort.add(gzone);                                              //  добавляем геозону в массив forSort
            AUT.add(gzone);                                                 //  добавляем геозону в массив AUT
        }

        System.out.println("Размер массива геозон : " + AUT.size());             // вывод в консоль размера массива  стран

        Collections.sort(forSort);                                                             // сортируем массив

        String stringAUT = arrayListToString(AUT);
        System.out.println("\nМассив на сайте :           " + stringAUT);  // вывод в консоль строкового значения массива AUT

        String stringForSort = arrayListToString(forSort);
        System.out.println("Отсортированный массив :" + stringForSort); // вывод в консоль строкового значения массива forSort

        Assert.assertEquals(stringAUT, stringForSort);              // сравниваем строковые значения массивов. Если true, то сортировка на сайте правильная.
    }

}

