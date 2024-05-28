package test.pages.Orc_Web_Gem;

import org.testng.asserts.SoftAssert;
import test.helpers.PropertiesHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

import static test.keywords.WebUI.*;

public class LoginPage {
    SoftAssert softassert = new SoftAssert();



    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By inputUsername = By.xpath("//input[@placeholder='User name']");
    By inputPassword = By.xpath("//input[@placeholder='Password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By iconViewPassword = By.xpath("//button[@type='button']//*[name()='svg']");
    By messageErrorLogin = By.xpath("//div[@class='flex flex-col']//span[2]");
    By messageErrorInputUsername = By.xpath("//p[contains(text(), 'User name is required')]");
    By messageErrorInputPassword = By.xpath("//p[contains(text(), 'Password is required')]");


    //Viết các hàm xử lý cho trang Login

    public void enterUsername(String username) {
        setText(inputUsername, username);
    }

    public void enterPassword(String password) {
        setText(inputPassword, password);
    }

    public void clickOnLoginButton() {
        clickElement(buttonLogin);
    }

    public void clickOnViewPassword(){clickElement(iconViewPassword);}

    public DashboardPage loginGEM(String email, String password) {
        openURL(PropertiesHelper.getValue("urlGem"));
        enterUsername(email);
        enterPassword(password);
        clickOnLoginButton();
        Assert.assertFalse(checkElementExist(messageErrorLogin), "Login không thành công.");
        return new DashboardPage();
    }

    public void inputBlankUsername(String username, String password){
        openURL(PropertiesHelper.getValue("urlGem"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageinputBlankDisplay(messageErrorInputUsername, "User name is required");
    }

    public void inputBlankPassword(String username, String password){
        openURL(PropertiesHelper.getValue("urlGem"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageinputBlankDisplay(messageErrorInputPassword,"Password is required");
    }


    public void loginInvalidUsername(String username, String password) {
        openURL(PropertiesHelper.getValue("urlGem"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sau username
        verifyErrorMessageDisplay();
    }

    public void UsernameMoreThan100(String username, String password) {
        openURL(PropertiesHelper.getValue("urlGem"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sau username
        verifyErrorMessageDisplay();
    }



    //Verify
    public void verifyErrorMessageinputBlankDisplay(By by, String expected) {
        waitForElementVisible(by);
        highLightElement(by);
        Assert.assertTrue(getWebElement(by).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(by), expected , "FAIL. Content of the Error message not match.");
    }

    public void verifyErrorMessageDisplay() {
        waitForElementVisible(messageErrorLogin);
        highLightElement(messageErrorLogin);
        Assert.assertTrue(getWebElement(messageErrorLogin).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(messageErrorLogin), "Username or password is incorrect", "FAIL. Content of the Error message not match.");
    }
}
