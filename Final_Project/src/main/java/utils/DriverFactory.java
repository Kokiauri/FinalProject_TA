package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {

        WebDriver webDriver = new FirefoxDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.set(webDriver);
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();

        }
    }
}
