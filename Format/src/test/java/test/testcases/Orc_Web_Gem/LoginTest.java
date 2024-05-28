package test.testcases.Orc_Web_Gem;


import test.common.BaseTest;
import test.dataproviders.DataLogin;
import test.helpers.ExcelHelper;
import test.pages.Orc_Web_Gem.LoginPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
//    @Test(priority = 1)
//    public void testSetDataToExcel() {
//        LoginPage loginPage = new LoginPage();
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Login");
//        loginPage.loginGEM(excelHelper.getCellData("USERNAME", 3), excelHelper.getCellData("PASSWORD", 3));
//        //Chạy tới dòng này nghĩa là Passed
//        excelHelper.setCellData("Passed", 3, "RESULT");
//    }

//    @Test(dataProvider = "dataProviderLoginCRM", dataProviderClass = DataLogin.class)
//    public void testDataProviderLoginCRM(String username, String password) {
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginGEM(username, password);
//    }
//
//    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataLogin.class)
//    public void loginTestFromDataProviderReadExcel(String username, String password, String result) {
//        LoginPage loginPage = new LoginPage();
//        loginPage.loginGEM(username, password);
//    }
//
    @Test(dataProvider = "data_provider_login_excel_custom_row", dataProviderClass = DataLogin.class)
    public void loginTestFromDataProviderReadExcelCustomRow(Hashtable<String, String> data) {

        loginPage.loginGEM(data.get("USERNAME"), data.get("PASSWORD"));
    }
//
    @Test(priority = 1)
    public void testLoginSuccess(){
    //LoginPage loginPage = new LoginPage();
    loginPage.loginGEM("admin","password");
    }

    @Test(priority = 2)
    public void testLoginInvaliUsername() {
        //LoginPage loginPage = new LoginPage();
        loginPage.loginInvalidUsername("admin1", "password");
    }

    @Test(priority = 3)
    public void checkUsernameBlank(){
        //LoginPage loginPage = new LoginPage();
        loginPage.inputBlankUsername("","password");
    }

    @Test(priority = 4)
    public void checkPasswordBlank(){
        //LoginPage loginPage = new LoginPage();
        loginPage.inputBlankPassword("admin","");
    }

    @Test(priority = 5)
    public void checkUsernameMoreThan100(){
        //LoginPage loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/CRM.xlsx", "Login");
        loginPage.loginGEM(excelHelper.getCellData("USERNAME", 3), excelHelper.getCellData("PASSWORD", 3));
        //Chạy tới dòng này nghĩa là Passed
        excelHelper.setCellData("Passed", 3, "RESULT");
    }



}
