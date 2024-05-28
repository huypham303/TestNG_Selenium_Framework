package test.pages.Orc_Web_Gem;

import static test.keywords.WebUI.*;

import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage {

    //Data trong nội bộ trang Dashboard
    private String PAGE_URL = "http://test-ocr-web-gem-hosted-website.s3-website-ap-northeast-1.amazonaws.com/company-list";
    private String PAGE_TEXT = "Company list";

    //Các Object
    By pageText = By.xpath("//span[normalize-space()='Company list']");



    public void verifyDashboardPage() {
        //Kiểm tra URL chứa phần thuộc trang DB
        //Kiểm tra Text hoặc Object chỉ có trang DB có
        Assert.assertEquals(getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Dashboard.");
        Assert.assertEquals(getTextElement(pageText), PAGE_TEXT, " Login Fail, không tìm thấy trang Company List");
    }

    //Hàm xử lý





}
