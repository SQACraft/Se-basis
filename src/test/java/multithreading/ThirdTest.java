package multithreading;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThirdTest extends TestBase {

    @Test
    public void  test31()  {
        search("ПАНДА");
    }

    @Test
    public void  test32()  {
        search("ЛЕМУР");
    }

    @Test
    public void  test33()  {
        search("ШИМПАНЗЕ");
    }


}
