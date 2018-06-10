package multithreading;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SecondTest extends TestBase{

    @Test
    public void  test21()  {
        search("ВОЛК");
    }

    @Test
    public void  test22()  {
        search("МЕДВЕДЬ");
    }

    @Test
    public void  test23()  {
        search("РЫСЬ");
    }


}
