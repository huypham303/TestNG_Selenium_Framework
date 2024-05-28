package test.pages.Orc_Web_Hosted.Login_Hosted;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.helpers.PropertiesHelper;
import test.pages.Orc_Web_Gem.DashboardPage;
import test.pages.Orc_Web_Gem.LoginPage;
import test.pages.Orc_Web_Hosted.File_Storage.File_Storage_Page;

import static test.keywords.WebUI.*;

public class Login_Page {
//    File_Storage_Page file_storage_page;
    SoftAssert softAssert = new SoftAssert();
    String Page_Text = "Folder";
    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng

    By inputUsername = By.xpath("//input[@name='username']");
    By inputPassword = By.xpath("//input[@name='password']");
    By buttonLogin = By.xpath("//button[@type='submit']");
    By iconViewPassword = By.xpath("//button[@type='button']//*[name()='svg']");
    By messageErrorLogin = By.xpath("//div[@class='flex flex-col']//span[@class='font-normal\ttext-sm']");
    By messageErrorInput = By.xpath("//p[@id='undefined_input_validate_text']");

    By messageErrorInputLess8CharactersPassword = By.xpath("//p[@id='undefined_input_validate_text']");
    By page_text_file_storage = By.xpath("//span[normalize-space()='Folder']");
    By messageLoginSuccess = By.xpath("//span[@class='font-normal\ttext-sm']");
    By iconLanguage = By.xpath("//div[@class='flex justify-center items-center px-2 space-x-2 cursor-pointer']");
    By iconLanguageVN = By.xpath("//div[contains(text(),'VN')]");
    By iconLanguageJP = By.xpath("//div[contains(text(),'JP')]");
    By iconLanguageEN = By.xpath("//div[contains(text(),'EN')]");

    //Viết các hàm xử lý cho trang Login
    public void enterUsername(String username) {
        setText(inputUsername, username);
    }

    public void enterPassword(String password) {
        setText(inputPassword, password);
    }


    public void clickOnLoginButton() { clickElement(buttonLogin); }
    public void clickOnIconLanguageVN() {
        clickElement(iconLanguage);
        clickElement(iconLanguageVN);
        refreshCurrentUrl();
    }
    public void clickOnIconLanguageJP() {
        clickElement(iconLanguage);
        clickElement(iconLanguageJP);
        refreshCurrentUrl();
    }

    public void clickOnIconLanguageEN() {
        clickElement(iconLanguage);
        clickElement(iconLanguageEN);
        refreshCurrentUrl();
    }

    public void clickOnViewPassword(){clickElement(iconViewPassword);}

    public void loginHostedWithEN(String email, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(email);
        enterPassword(password);
        clickOnViewPassword();
        clickOnLoginButton();

        // kiểm tra xem đã đăng nhập chưa
        verifySuccessLogin("Login successfully");

        //return new File_Storage_Page();
    }

    public void loginHostedWithVN(String email, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        clickOnIconLanguageVN();
        enterUsername(email);
        enterPassword(password);
        clickOnViewPassword();
        clickOnLoginButton();

        // kiểm tra xem đã đăng nhập chưa
        verifySuccessLogin("Đăng nhập thành công");

        //return new File_Storage_Page();
    }

    public File_Storage_Page loginHostedWithJP(String email, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        clickOnIconLanguageJP();
        enterUsername(email);
        enterPassword(password);
        clickOnViewPassword();
        clickOnLoginButton();

        // kiểm tra xem đã đăng nhập chưa
        verifySuccessLogin("ログインに成功しました");

        return new File_Storage_Page();
    }

    public File_Storage_Page inputUsernameWithOnlyValidNumber(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        verifyIsNumber();
        enterPassword(password);
        clickOnLoginButton();

        verifySuccessLogin("Login successfully");
        return new File_Storage_Page();
    }

    public File_Storage_Page inputUsernameWithOnlyValidLetters(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        verifyIsStringWithoutNumber();
        enterPassword(password);
        clickOnLoginButton();

        verifySuccessLogin("Login successfully");
        return new File_Storage_Page();
    }

    public File_Storage_Page inputUsernameWithOnlyValidSpecialCharacters(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        verifyIsSpecialCharactersOnly();
        enterPassword(password);
        clickOnLoginButton();

        verifySuccessLogin("Login successfully");
        return new File_Storage_Page();
    }

    public File_Storage_Page inputUsernameWithValidNumbersLettersSpecialCharacters(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        verifyHasNumbersLettersSpecialChars();
        enterPassword(password);
        clickOnLoginButton();

        verifySuccessLogin("Login successfully");
        return new File_Storage_Page();
    }

    //Check Validation Login
    //Check field Username Functions
    public void inputBlankUsernameWithLanguageEN(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInput, "User name is required");
    }

    public void inputBlankUsernameWithLanguageVN(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));

        clickOnIconLanguageVN();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInput, "Yêu cầu nhập tên người dùng");
    }

    public void inputBlankUsernameWithLanguageJP(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));

        clickOnIconLanguageJP();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInput, "ユーザー名が必須です");
    }


    public void inputUsernameMoreThan100(String username, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        enterPassword(password);

        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sau username
        verifyInputSize();
    }

    //Check field Password Functions
    public void inputBlankPassword(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInput,"Password is required");
    }

    public void inputPasswordLessThan8Characters(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInputLess8CharactersPassword,"The password must contain at least 8 characters");
    }

    public void inputPasswordLessThan8CharactersWithVN(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));

        clickOnIconLanguageVN();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInputLess8CharactersPassword,"Mật khẩu phải chứa ít nhất 8 ký tự");
    }

    public void inputPasswordLessThan8CharactersWithJP(String username, String password){
        openURL(PropertiesHelper.getValue("urlHosted"));

        clickOnIconLanguageJP();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        verifyErrorMessageInputBlankDisplay(messageErrorInputLess8CharactersPassword,"パスワードには、少なくとも8文字を入力する必要があります");
    }

    //Check login fail with invalid username or password
    public void loginInvalidUsernameAndPasswordWithEN(String username, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        //Kiểm tra message thông báo lỗi khi sau username
        verifyErrorMessageDisplay("Username or password is incorrect");
    }

    public void loginInvalidUsernameAndPasswordWithVN(String username, String password) {
        openURL(PropertiesHelper.getValue("urlHosted"));
        clickOnIconLanguageVN();
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();

        //Kiểm tra message thông báo lỗi khi sau username
        verifyErrorMessageDisplay("Username or password is incorrect");
    }


    // Check verify for all Functions---------------------------------------------------------------------------------------------
    //@Step ("Verify Success Login @@@@@@@@@@@@@@@@@@@@@@@")
    public void verifySuccessLogin(String expected) {
        waitForElementVisible(messageLoginSuccess);
        highLightElement(messageLoginSuccess);
        Assert.assertTrue(getWebElement(messageLoginSuccess).isDisplayed(), "Không hiển thị thông báo đăng nhập thành công.");
        Assert.assertEquals(getTextElement(messageLoginSuccess), expected, "Đăng nhập thất bại.");
    }


    public void verifyErrorMessageInputBlankDisplay(By by, String expected) {
        waitForElementVisible(by);
        highLightElement(by);
        Assert.assertTrue(getWebElement(by).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(by), expected , "FAIL. Content of the Error message not match.");
    }

    public void verifyErrorMessageDisplay(String expected) {
        waitForElementVisible(messageErrorLogin);
        highLightElement(messageErrorLogin);
        Assert.assertTrue(getWebElement(messageErrorLogin).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(getTextElement(messageErrorLogin), expected, "FAIL. Content of the Error message not match.");
    }

    public void verifyInputSize(){
        String usernameSize = getAttributeElement(inputUsername, "value");
        logConsole("Số lượng ký tự hiện tại: " + usernameSize.length());
        Assert.assertEquals(usernameSize.length(), 100, "Quá 100 ký tự cho phép");
    }

    public void verifyIsNumber(){
        String username = getAttributeElement(inputUsername, "value");
        logConsole(username);
        Assert.assertTrue(isInteger(username),"Case này chỉ chứa username là number");
    }

    public void verifyIsStringWithoutNumber(){
        String username = getAttributeElement(inputUsername, "value");
        Assert.assertTrue(isStringWithoutNumber(username),"Username chỉ chứa số letters");
    }

    public void verifyIsSpecialCharactersOnly(){
        String username = getAttributeElement(inputUsername, "value");
        Assert.assertTrue(isStringWithoutNumber(username),"Case này chỉ chứa username là các ký tự đặc biệt");
    }

    public void verifyHasNumbersLettersSpecialChars(){
        String username = getAttributeElement(inputUsername, "value");
        Assert.assertTrue(hasNumbersLettersSpecialChars(username),"Case này chỉ chứa username là các ký tự đặc biệt");
    }

}
