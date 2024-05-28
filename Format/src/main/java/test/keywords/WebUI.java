package test.keywords;

import test.reports.ExtentTestManager;
import test.utils.LogUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.drivers.DriverManager;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class WebUI {

    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LEADED_TIMEOUT = 30;

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }
    public static void logConsole(String message) {
        System.out.println(message);
    }

    public static void hoverOnElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by));
        LogUtils.info("Hover on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Hover on element " + by);
    }

    public static WebElement highLightElement(By by) {
        waitForElementVisible(by);
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='5px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }



    @Step("Right click on element {0}")
    public static void rightClickElement(By by) {
        waitForElementVisible(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(getWebElement(by));
        LogUtils.info("Right click on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Right click on element " + by);
    }

    @Step("Open URL: {0}")
    public static void openURL(String URL) {
        DriverManager.getDriver().get(URL);
        waitForPageLoaded();
        LogUtils.info("Open URL: " + URL);
        ExtentTestManager.logMessage(Status.PASS, "Open URL: " + URL);
    }

    @Step("Get current URL")
    public static String getCurrentUrl() {
        waitForPageLoaded();
        LogUtils.info("Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
        ExtentTestManager.logMessage(Status.PASS, "Get Current URL: " + DriverManager.getDriver().getCurrentUrl());
        return DriverManager.getDriver().getCurrentUrl();
    }

    @Step("Get page title")
    public static String getPageTitle() {
        waitForPageLoaded();
        LogUtils.info("Get Page Title: " + DriverManager.getDriver().getTitle());
        ExtentTestManager.logMessage(Status.PASS, "Get Page Title: " + DriverManager.getDriver().getTitle());
        return DriverManager.getDriver().getTitle();
    }

    @Step("Get page source")
    public static String getPageSource() {
        waitForPageLoaded();
        LogUtils.info("Get Page Source: " + DriverManager.getDriver().getPageSource());
        ExtentTestManager.logMessage(Status.PASS, "Get Page Source: " + DriverManager.getDriver().getPageSource());
        return DriverManager.getDriver().getPageSource();
    }

    @Step("Refresh current URL")
    public static void refreshCurrentUrl() {
        waitForPageLoaded();
        DriverManager.refreshCurrentPage();
        LogUtils.info("Current URL After Refresh: " + DriverManager.getDriver().getCurrentUrl());
        ExtentTestManager.logMessage(Status.PASS, "Current URL After Refresh: " + DriverManager.getDriver().getCurrentUrl());
    }

    @Step("Forward current URL")
    public static void forwardCurrentUrl() {
        waitForPageLoaded();
        DriverManager.forwardCurrentPage();
        LogUtils.info("Current URL After Forward: " + DriverManager.getDriver().getCurrentUrl());
        ExtentTestManager.logMessage(Status.PASS, "Current URL After Forward: " + DriverManager.getDriver().getCurrentUrl());
    }

    @Step("Back current URL")
    public static void backCurrentUrl() {
        waitForPageLoaded();
        DriverManager.backCurrentPage();
        LogUtils.info("Current URL After Back: " + DriverManager.getDriver().getCurrentUrl());
        ExtentTestManager.logMessage(Status.PASS, "Current URL After Back: " + DriverManager.getDriver().getCurrentUrl());
    }

    @Step("Click on element {0}")
    public static void clickElement(By by) {
        waitForElementVisible(by);
        highLightElement(by);
        getWebElement(by).click();
        LogUtils.info("Click on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Click on element " + by);
    }

    @Step("Set text {1} on element {0}")
    public static void setText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Set text '" + value + "' on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Set text " + value + " on element " + by);
    }

    @Step("Get text of element {0}")
    public static String getTextElement(By by) {
        waitForElementVisible(by);
        LogUtils.info("Get text of element " + by);
        LogUtils.info("==> Text: " + getWebElement(by).getText());
        ExtentTestManager.logMessage(Status.PASS, "Get text of element " + by);
        ExtentTestManager.logMessage(Status.INFO, "==> Text: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    @Step("Get attribure {1} value of element {0}")
    public static String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        LogUtils.info("Get attribute value of element " + by);
        LogUtils.info("==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        ExtentTestManager.logMessage(Status.PASS, "Get attribute value of element " + by);
        ExtentTestManager.logMessage(Status.INFO, "==> Attribute value: " + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    public static void scrollDownToElementWithJS(By by) {
        waitForElementPresent(by);
        //Dùng Actions class
        //Robot class
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        logConsole("Scroll to element " + by);
    }

    public static void scrollDownToElementToBottomPageWithJS() {
        //waitForElementPresent(by);
        //Dùng Actions class
        //Robot class
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //logConsole("Scroll to element " + by);
    }

    public static void scrollHorizontallyToElementWithJS(By by) {
        waitForElementPresent(by);
        //Dùng Actions class
        //Robot class
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView();");
        logConsole("Scroll to element " + by);
    }

    public static void scrollToElement(By by) {
        //Dùng Actions class

    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT), Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean verifyElementVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean verifyElementNotVisible(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyElementNotPresent(By by, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(second), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean checkElementExist(By by) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // Handle empty or null strings
        }

        // Use regular expression for integers with optional sign
        return str.matches("-?\\d+");
    }

    public static boolean isStringWithoutNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // Handle empty or null strings
        }

        // Use regular expression to match strings without digits
        return str.matches("^[^\\d]*$");
    }

    public static boolean isSpecialCharactersOnly(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // Handle empty or null strings
        }

        // Use regular expression to match strings with only special characters
        return str.matches("^[^a-zA-Z0-9\\s]*$");
    }

    public static boolean hasNumbersLettersSpecialChars(String str) {
        if (str == null || str.isEmpty()) {
            return false;  // Handle empty or null strings
        }

        // Pattern to match a string with at least one number, letter, and special character
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9\\s]).+$");
        return pattern.matcher(str).matches();
    }
}