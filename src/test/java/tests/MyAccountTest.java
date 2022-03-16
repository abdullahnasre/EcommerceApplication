package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
    HomePage homeObject ;
    UserRegistrationPage registerObject ;
    LoginPage loginObject ;
    MyAccountPage myAccountObject ;
    String oldPassword = "1239878" ;
    String newPassword = "3217899" ;
    String firstName = "Abdullah" ;
    String lastName = "Nasr" ;
    String email = "abdotest2040@gmail.com" ;


    @Test
    public void UserRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.UserRegistration(firstName, lastName, email, oldPassword);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test
    public void RegisteredUserCanChangePassword()
    {
        myAccountObject = new MyAccountPage(driver) ;
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.ChangePassword(oldPassword, newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
    }
}
