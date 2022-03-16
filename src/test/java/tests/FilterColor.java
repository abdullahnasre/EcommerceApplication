package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class FilterColor extends TestBase{
    HomePage homeObject ;

    @Test
    public void UserCanFilter() throws InterruptedException {
        homeObject = new HomePage(driver);
        Thread.sleep(1000);
        homeObject.selectShoes();
}
}
