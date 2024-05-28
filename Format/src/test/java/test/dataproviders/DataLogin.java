package test.dataproviders;

import test.helpers.ExcelHelper;
import test.helpers.SystemsHelper;
import org.testng.annotations.DataProvider;

public class DataLogin {
    @DataProvider(name = "dataProviderLoginCRM", parallel = true)
    public Object[][] dataLoginCRM() {
        return new Object[][]{{"admin", "password"}, {"huypd", "Huypham@123"}};
    }

    @DataProvider(name = "dataProviderLoginCMS", parallel = true)
    public Object[][] dataLoginCMS() {
        return new Object[][]{{"admin", "password", 123}, {"huypd", "Huypham@123", 1234}};
    }

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginCRMFromExcel() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getExcelData(SystemsHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_custom_row")
    public Object[][] dataLoginCRMFromExcelCustomRow() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getDataHashTable(SystemsHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login", 1, 2);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

}
