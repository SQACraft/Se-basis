package lifeCart.business.newUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test
    void createuser() {

        click(By.cssSelector("[name=login_form] [href$=create_account]"));   // Переход в раздел Create Account
        validateByTextContent(By.cssSelector(".content h1"),   "Create Account");  // валидация заголовка

        wd.findElement(By.cssSelector("[name=tax_id]"))
                .sendKeys("7773337" + Keys.TAB);                       // ввод текста + TAB

        wd.findElement(By.cssSelector("[name=company]"))
                .sendKeys("Kewl Features" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=firstname]"))
                .sendKeys("Peter" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=lastname]"))
                .sendKeys("Hawkins" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address1]"))
                .sendKeys("Berkeley Avenue 1" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address2]"))
                .sendKeys("Hayfield Street 2" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=postcode]"))
                .sendKeys("UZ1CWI" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=city]"))
                .sendKeys("London" + Keys.TAB);




    }

}
