package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText="Change password")
    WebElement changePasswordLink ;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;

    @FindBy(css = "body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > form > div.buttons > button")
    WebElement ChangePasswordBtn;

    @FindBy(css = "div.bar-notification success")
    public WebElement resultLbl;

    public void openChangePasswordPage()
    {
        clickButton(changePasswordLink);
    }

    public void ChangePassword(String oldPassword, String newPassword) {
        setTextElementText(oldPasswordTxt, oldPassword);
        setTextElementText(newPasswordTxt, newPassword);
        setTextElementText(confirmPasswordTxt, newPassword);
        clickButton(ChangePasswordBtn);
    }
}
