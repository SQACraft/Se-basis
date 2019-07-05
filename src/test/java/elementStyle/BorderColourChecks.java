package elementStyle;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BorderColourChecks {
	/**
	 * Валидация текста на странице по атрибуту outerText
	 */
	public void validateByOuterText(WebElement element, String expectedText) {           // проверка текста на странице
		String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
		Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
	}

	/**
	 * Проверка, что в поле -  валидный ввод и рамка поля - оранжевая
	 */
	public void checkValidInput(WebElement element) {
		String borderColour = element.getCssValue("border-color");
		Assert.assertEquals(borderColour, "rgb(244, 149, 48)");        // оранжевый цвет рамки поля , ввод валиден
	}

	/**
	 * Проверка, что в поле - НЕвалидный ввод и рамка поля - красная
	 */
	public void checkInvalidInput(WebElement element) {
		String borderColour = element.getCssValue("border-color");
		Assert.assertEquals(borderColour, "rgb(232, 64, 64)");        // красный цвет рамки поля ( border-color: #e84040);
	}
}
