package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        // 1. Setup Chrome browser.
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
        }else{
            System.out.println("You have entered wrong browser.");
        }

        // 2. Open URL.
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  3. Print the title of the page.
        String title=driver.getTitle();
        System.out.println("The page title: "+title);
        System.out.println("***************************************");

        //  4. Print the current url.
        String currentUrl=driver.getCurrentUrl();
        System.out.println(currentUrl);
        System.out.println("***************************************");

        //  5. Print the page source.
        System.out.println(driver.getPageSource());
        System.out.println("***************************************");

        //  6. Enter the email to email field.
       WebElement email= driver.findElement(By.id("username"));
       email.sendKeys("tomsmith");

        //  7. Enter the password to password field.
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //  8. Click on Login Button.
        driver.findElement(By.className("radius")).click();

        //  9. Print the current url.
        System.out.println(driver.getCurrentUrl());
        System.out.println("***************************************");

        //  10. Refresh the page.
        driver.navigate().refresh();

        // 11. Close the browser.
        driver.quit();

    }

}
