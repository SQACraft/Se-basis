package pageScrollingWithAWT;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ScrollingWithAWT {

	public void scroll() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		await(300);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		await(300);
	}

	public static void await(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
		}
	}
}

