package test.testcases.Orc_Web_Gem;

import test.common.BaseTest;

import test.pages.Orc_Web_Gem.DashboardPage;
import test.pages.Orc_Web_Gem.LoginPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testOpenMenuOnDashboard() {
        loginPage = new LoginPage();

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Dashboard
        dashboardPage = loginPage.loginGEM("admin", "password");

        //Kiểm tra trang Dashboard là đúng
        dashboardPage.verifyDashboardPage();

    }

}
