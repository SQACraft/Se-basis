package multithreading;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{

    @Test
    public void  test11()  {
       search("КОШКА");
    }

    @Test
    public void  test12()  {
        search("СОБАКА");
    }

    @Test
    public void test13()  {
        search("ЛИСА");
    }


}
