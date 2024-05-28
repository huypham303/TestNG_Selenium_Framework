package test.pages.Orc_Web_Hosted.User_Account_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import test.pages.Orc_Web_Hosted.Login_Hosted.Login_Page;
import static test.keywords.WebUI.*;

public class User_Account_Page {
    Login_Page login_Page;


    // Xpath
    By addAccount = By.xpath("//button[@type='PRIMARY']");
    By inputSearch = By.xpath("//input[@class='w-full h-8 p-2 rounded focus:outline-none appearance-none focus:ring-0']");


    // Function
    public void clickAddAccountButton(){clickElement(addAccount);}
    public void inputSearch(String text){
        setText(inputSearch,text);
        getWebElement(inputSearch).sendKeys(Keys.ENTER);
    }



    //Verify

}
