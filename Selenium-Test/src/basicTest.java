/**
 * Created by Tim Wang on 4/3/2016.
 */
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class basicTest {
    public static void testChrome() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
    }

    public static void
    public static void main(String[] args) throws MalformedURLException{
        testChrome();


    }
}
