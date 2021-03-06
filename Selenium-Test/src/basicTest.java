/**
 * Created by Tim Wang on 4/3/2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class basicTest {
    public static void testChrome() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
    }

    public static void testBase() throws IOException {
        WebDriver driver = null;
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("Selenium-Test/properties/dataDriven.properties");
        prop.load(fis);
        if(prop.getProperty("browser").equals("firefox")) {
            driver =new FirefoxDriver();
        } else if(prop.getProperty("browser").equals("chrome")) {
            driver =new ChromeDriver();
        } else {
            driver =new InternetExplorerDriver();
        }
        driver.get(prop.getProperty("url"));
        //driver.findElement(By.xpath:').sendkeys(username)
        System.out.println(prop);
        //driver.findElement(By.xpath(":'")).sendKeys(prop.getProperty("username"));
    }

    public static void remoteDriver() throws MalformedURLException {
        DesiredCapabilities dc= DesiredCapabilities.firefox();
        dc.setCapability("version", "5");
        dc.setCapability("platform", "XP");
        WebDriver driver = new RemoteWebDriver(
                new URL("http://rahul1:e950d779-1817-4c3c-b122-06715b814dfd@ondemand.saucelabs.com:80/wd/hub"),
                dc);

        driver.get("http://ebay.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay", driver.getTitle());
    }

    public static void loginLinkedin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://linkedin.com");
        driver.findElement(By.id("login-email")).sendKeys("123123");
        driver.findElement(By.id("login-password")).sendKeys("123123");
        //driver.findElement(By.partialLinkText("forget password")).click();
        driver.findElement(By.xpath("//*[@id=\"pagekey-uno-reg-guest-home\"]/div[1]/div/form/input[6]")).click();
    }

    public static void CSSselector() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        System.out.println(driver.findElement(By.cssSelector("#gsr > script")).getText());

    }

    public static void main(String[] args) throws IOException{
        //testChrome();
        //testBase();
        //remoteDriver();
        //loginLinkedin();
        CSSselector();
    }
}
