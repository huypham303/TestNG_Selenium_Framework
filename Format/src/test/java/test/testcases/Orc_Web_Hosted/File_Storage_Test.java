package test.testcases.Orc_Web_Hosted;

import org.testng.annotations.Test;
import test.common.BaseTest;
import test.pages.Orc_Web_Hosted.File_Storage.File_Storage_Page;
import test.pages.Orc_Web_Hosted.Login_Hosted.Login_Page;

public class File_Storage_Test extends BaseTest {
    Login_Page login_Page;
    File_Storage_Page file_storage_page;


    @Test
    public void openOnFileStoragePage() {
        login_Page = new Login_Page();

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Dashboard
        login_Page.loginHostedWithEN("adminHuypd", "12345678");

        //Kiểm tra trang FileStorage là đúng
        file_storage_page.verifyFileStoragePage();
    }

    @Test
    public void logout(){
        file_storage_page = new File_Storage_Page();
        file_storage_page.changeLanguageToVN();
    }
}
