package test.testcases.Orc_Web_Hosted;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.BaseTest;
import test.drivers.DriverManager;
import test.helpers.ExcelHelper;
import test.keywords.WebUI;
import test.pages.Orc_Web_Hosted.File_Storage.File_Storage_Page;
import test.pages.Orc_Web_Hosted.Login_Hosted.Login_Page;

import java.util.ArrayList;
import java.util.List;

public class Login_Test extends BaseTest {
    Login_Page login_Page = new Login_Page();
    File_Storage_Page file_storage_page;


    @Test(description = "đăng nhập thành công")
    public void testLoginSuccess(){
        login_Page.loginHostedWithEN("admin","password");
    }

    @Test(description = "đăng nhập sai username")
    public void testLoginInvaliUsername() {
        login_Page.loginInvalidUsernameAndPasswordWithEN("admin1", "password");
    }

    @Test(description = "đăng nhập sai password")
    public void testLoginInvaliPassword() {
        login_Page.loginInvalidUsernameAndPasswordWithEN("admin", "password1");
    }


    @Test(description = "để trống username")
    public void checkUsernameBlank(){
        login_Page.inputBlankUsernameWithLanguageEN("","password");
    }

    @Test(description = "nhập username quá 100 ký tự")
    public void checkUsernameMoreThan100(){
        //ExcelHelper excelHelper = new ExcelHelper();
        //excelHelper.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Login");

        //login_Page.UsernameMoreThan100(excelHelper.getCellData("USERNAME", 3), excelHelper.getCellData("PASSWORD", 3));
        //Chạy tới dòng này nghĩa là Passed
        //excelHelper.setCellData("Passed", 3, "RESULT");
        login_Page.inputUsernameMoreThan100("B2v6LYlxrO4ULMRHlpJ53JfGdqDy0v2KdUULZ1zxjgi8CRkybTB2v6LYlxrO4ULMRHlpJ5" +
                "3JfGdqDy0v2KdUULZ1zxjgi8CRkybT12345", "password");
        login_Page.verifyInputSize();
    }


    @Test(description = "để trống password")
    public void checkPasswordBlank(){
        login_Page.inputBlankPassword("admin","");
    }

    @Test(description = "để password ít hơn 8 ký tự")
    public void inputPasswordLessThan8Characters(){
        login_Page.inputPasswordLessThan8Characters("admin","123");
    }

    @Test(description = "check đăng nhập chỉ có số")
    public void loginWithOnlyNumbers(){
        login_Page.inputUsernameWithOnlyValidNumber("1111","12345678");
    }

    @Test(description = "check đăng nhập chỉ có chữ")
    public void loginWithOnlyValidLetters(){
        login_Page.inputUsernameWithOnlyValidLetters("adminHuypd","12345678");
    }

    @Test(description = "")
    public void loginWithOnlyValidSpecialCharacters(){
        login_Page.inputUsernameWithOnlyValidSpecialCharacters("-_-","12345678");
    }

    @Test(description = "")
    public void loginWithValidNumbersLettersSpecialCharacters(){
        login_Page.inputUsernameWithValidNumbersLettersSpecialCharacters("huypd-_-123","12345678"); // ユーザー名が必須です
    }

    @Test(description = "input Blank Username With Language VN")
    public void checkUsernameBlankWithVN(){
        login_Page.inputBlankUsernameWithLanguageVN("","password");
    }

    @Test(description = "input Blank Username With Language JP")
    public void checkUsernameBlankWithJP(){
        login_Page.inputBlankUsernameWithLanguageJP("","password");
    }

    @Test(description = "login Hosted With VN")
    public void loginHostedWithVN(){
        login_Page.loginHostedWithVN("1111","12345678");
    }

    @Test(description = "login Hosted With JP")
    public void loginHostedWithJP(){
        login_Page.loginHostedWithJP("1111","12345678");
    }



}
