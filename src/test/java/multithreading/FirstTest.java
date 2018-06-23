package multithreading;

import org.testng.annotations.Test;

public class FirstTest extends TestBase{

    @Test
   void  test11()  {
       search("КОШКА");
    }

    @Test
    void  test12()  {
        search("СОБАКА");
    }

    @Test
   void test13()  {
        search("ЛИСА");
    }


}
