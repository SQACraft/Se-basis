package multithreading;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SecondTest extends TestBase{

    @Test
     void  test21()  {
        search("ВОЛК");
    }

    @Test
    void  test22()  {
        search("МЕДВЕДЬ");
    }

    @Test
     void  test23()  {
        search("РЫСЬ");
    }


}
