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
        By locator = (By.cssSelector("td#content [href*='country_code'"));

        List<WebElement> countryLinks = wd.findElements(locator);  //  список всех ссылок со странами на сайте
        System.out.println(countryLinks.size()); // 476 стран в списке

        ArrayList<String> countryNames = new ArrayList<>();  // пустой массив  countryNames с наименованиями стран
        ArrayList<String> beforeSort = new ArrayList<>();  // пустой массив  beforeSort с наименованиями стран

        String countryName;

        for (WebElement i : countryLinks) {                           // перебор списка ссылок со странами
            countryName = i.getAttribute("textContent");          // считываем атрибут с названием страны
            countryNames.add(countryName);                          //  добавляем страну в массив countryNames
            beforeSort.add(countryName);                          //  добавляем страну в массив countryNames
            //     System.out.println(countryNames );
        }

        System.out.println(countryNames.size());  // 476 стран в массиве


        Collections.reverse(countryNames);                             // сортируем массив

        System.out.println(countryNames);

        Assert.assertSame(beforeSort, countryNames);  // сравнение

    }
    //    TODO: Нужно исключать ссылки с  аттрибутом EDIT

}
