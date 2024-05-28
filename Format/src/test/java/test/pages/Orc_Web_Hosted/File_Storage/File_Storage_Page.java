package test.pages.Orc_Web_Hosted.File_Storage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.helpers.PropertiesHelper;
import test.pages.Orc_Web_Gem.DashboardPage;
import test.pages.Orc_Web_Hosted.Login_Hosted.Login_Page;

import static test.keywords.WebUI.*;

public class File_Storage_Page {

    Login_Page login_Page;
    File_Storage_Page file_storage_page;
    String Page_Text = "Folder";
    String PAGE_URL = "http://test-ocr-web-hosted-website.s3-website-ap-northeast-1.amazonaws.com/file-storage";

    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By page_text = By.xpath("//span[normalize-space()='Folder']");
    By iconLanguage = By.xpath("//div[@class='flex justify-center items-center px-2 space-x-2 cursor-pointer']");

    By iconLanguageVN = By.xpath("//div[contains(text(),'VN')]");
    By iconLanguageJP = By.xpath("//div[contains(text(),'JP')]");
    By iconLanguageEN = By.xpath("//div[contains(text(),'EN')]");


    //div.truncate>svg
    ////*[local-name()='svg' and @width='24' and @height='24' and @class='w-6 cursor-pointer']
    //By logOutButton = By.xpath("div.truncate>svg");
    By logOutButton = By.cssSelector("div.truncate>svg");
    By logOutConfirm = By.xpath("//button[contains(text(),'Đăng xuất')]");
    //Viết các hàm xử lý cho trang

    public void changeLanguageToVN(){
        login_Page = new Login_Page();
        login_Page.loginHostedWithEN("admin","password");
        clickElement(iconLanguage);
        //hoverOnElement(iconLanguage);
        clickElement(iconLanguageVN);

        verifyIconLanguage(iconLanguageVN, "VN");

        highLightElement(logOutButton);
        clickElement(logOutButton);
        clickElement(logOutConfirm);
        //return new Login_Page();
    }


    // Các hàm verify
    public void verifyFileStoragePage(){
        waitForElementVisible(page_text);
        highLightElement(page_text);
        Assert.assertEquals(getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Dashboard.");
        Assert.assertEquals(getTextElement(page_text), "Page_Text");
    }

    public void verifyIconLanguage(By by, String expected) {
        waitForElementVisible(by);
        highLightElement(by);
        Assert.assertTrue(getWebElement(by).isDisplayed(), "Đổi ngôn ngữ không hiên thị.");
        Assert.assertEquals(getTextElement(by), expected , "Nội dung không đúng.");
    }

}
