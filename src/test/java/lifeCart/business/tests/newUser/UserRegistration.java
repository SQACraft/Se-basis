package lifeCart.business.tests.newUser;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UserRegistration extends ToolBox {

    private String eMail;  //  для сгенерированного E-Mail
    private String password = getUniqueNumber("", "");  // генерация пароля
    private String name = "Peter";
    private String lastname = "Hawkins";

    @Test ( groups = "UserRegistration", priority = 1, description = "Регистрация нового пользователя")

    void createUser() {

        goToSquareOne();

        click(By.cssSelector("[name=login_form] [href$=create_account]"));   // Переход в раздел Create Account
        validateByTextContent(By.cssSelector(".content h1"), "Create Account");  // валидация заголовка

        wd.findElement(By.cssSelector("[name=tax_id]"))
                .sendKeys(getUniqueNumber("", "") + Keys.TAB);                       // генерация номера  + TAB

        wd.findElement(By.cssSelector("[name=company]"))
                .sendKeys("Kewl Features" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=firstname]"))
                .sendKeys(name + Keys.TAB);

        wd.findElement(By.cssSelector("[name=lastname]"))
                .sendKeys(lastname + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address1]"))
                .sendKeys("Berkeley Avenue 1" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address2]"))
                .sendKeys("Hayfield Street 2" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=postcode]"))
                .sendKeys("K0C 0A4" + Keys.TAB);     // валидный индекс для Канады

        wd.findElement(By.cssSelector("[name=city]"))
                .sendKeys("Monterrey" + Keys.TAB);

        WebElement selectElement = wd.findElement(By.cssSelector("select[name=country_code]"));    // cписок выбора страны
        Select select = new Select(selectElement);
//        select.selectByValue("DZ")  ;                      // выбираем Algeria по атрибуту
        select.selectByVisibleText("Canada");        // выбираем Canada по тексту в списке
//        select.selectByIndex(3);                        // выбираем Algeria по индексу в списке

        selectElement.sendKeys(Keys.TAB);

        eMail = getUniqueNumber("", "@1.1");              // уникальный E-mail формата nnnnnnnnnn@1.1
        wd.findElement(By.cssSelector("[name=email]"))
                .sendKeys(eMail + Keys.TAB);

        wd.findElement(By.cssSelector("[name=phone]"))
                .sendKeys(getUniqueNumber("", "") + Keys.TAB);     // генерация номера

        setCheckboxState(By.cssSelector("[name=newsletter]"), "toClear");  // cнимаем чекбокс для рассылки
        wd.findElement(By.cssSelector("[name=newsletter]")).sendKeys(Keys.TAB);

        wd.findElement(By.cssSelector("[name=password]"))
                .sendKeys(password + Keys.TAB);

        wd.findElement(By.cssSelector("[name=confirmed_password]"))
                .sendKeys(password + Keys.TAB);

        wd.findElement(By.cssSelector(" button[name=create_account]")).click();   // сабмит

        // далее обходим баг:  список зон не появился, он появляется только после сабмита.
        // выбираем код зоны и повторно вводим пароль с подтверждением.

        selectElement = wd.findElement(By.cssSelector("select[name=zone_code]"));
        select = new Select(selectElement);
        select.selectByVisibleText("British Columbia");        // выбираем British Columbia по тексту в списке

        wd.findElement(By.cssSelector("[name=password]"))
                .sendKeys(password + Keys.TAB);

        wd.findElement(By.cssSelector("[name=confirmed_password]"))
                .sendKeys(password + Keys.TAB);

        wd.findElement(By.cssSelector(" button[name=create_account]")).click();   // сабмит

        validateByTextContent(By.cssSelector(".notice.success"), " Your customer account has been created."); //валидация сообщения

        wd.findElement(By.cssSelector(".content [href$=logout]")).click(); //  logout

        validateByTextContent(By.cssSelector(".notice.success"), " You are now logged out."); //валидация сообщения
    }

    @Test ( groups = "UserRegistration", priority = 2,
            description = "Вход в систему пользователем, созданным в предыдущем тесте  ")

    void login() {

        goToSquareOne();

        wd.findElement(By.cssSelector("[name=email]"))
                .sendKeys(eMail + Keys.TAB);

        wd.findElement(By.cssSelector("[name=password]"))
                .sendKeys(password + Keys.TAB);

        setCheckboxState(By.cssSelector("[name=remember_me]"), "toSelect");  // выбираем чекбокс "Remember Me"

        wd.findElement(By.cssSelector("button[name=login]")).click(); //  login

        validateByTextContent(By.cssSelector(".notice.success"),
                " You are now logged in as " + name + " " + lastname + ".");       //валидация сообщения


    }

}
