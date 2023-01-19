package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Singleton {
    private static WebDriver driver ;
    private static Singleton singleton = new Singleton();
    String browser=Constant.SelectedBrowser;
    private Singleton() {
        if (driver == null) {
             browser = browser == null ? "chrome" : browser;
            switch (browser) {
                case "chrome":
                    ChromeOptions option1 = new ChromeOptions();
                    option1.addArguments("--start-maximized", "--disable-notifications");
                    driver = WebDriverManager.chromedriver().avoidShutdownHook().capabilities(option1).create();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                  break;
                case "edge":
                    driver =new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
    }

    public static WebDriver getDriverInstance()
    {
        return driver;
    }
}
