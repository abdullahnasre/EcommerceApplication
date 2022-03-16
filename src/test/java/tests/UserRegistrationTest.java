package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void UserRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.UserRegistration("Abdullah","Nasr","abdotest136@gmail.com","1234abcd");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        System.out.println("Passed: UserRegisterSuccessfully");
    }

    @Test(dependsOnMethods = {"UserRegisterSuccessfully"})
    public void RegisteredUserCanLogout(){
        registerObject.userLogout();
    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("abdotest135@gmail.com","1234abcd");
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

}
