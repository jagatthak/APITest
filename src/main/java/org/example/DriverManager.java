package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils{
    //    String browserName = "Chrome";
    LoadProp loadprop = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();

    public  final String AUTOMATE_USERNAME = loadprop.getProperty("bsUsername");
    public  final String AUTOMATE_ACCESS_KEY = loadprop.getProperty("bsAccessKey");
    public  final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));

    String browserName = System.getProperty("browser");

    public void openBrowser() {

        //making decision cloud true or false
        // this will be run if cloud true (In cloud)
        if (cloud) {
            System.out.println("running cloud");
            //applying conditional loop for different browser options
            if (browserName.equalsIgnoreCase("Chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            } else if (browserName.equalsIgnoreCase("Edge")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");
            } else {
                System.out.println("Your browser name is wrong");
            }
            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        else {
            //this will be run if cloud false(locally)
            System.out.println("running locally......");
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("Either your browser name is wrong or not provided");
            }

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }
    public void closeBrowser() {

        driver.quit();
    }
}
