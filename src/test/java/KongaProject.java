import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

import javax.swing.*;

public class KongaProject {
    private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
         driver = new ChromeDriver();
        //make fullscreen
        driver.manage().window().maximize();
        //open  konga website
        driver.get("https://www.konga.com");
        //navigate the login page from homepage
        driver.findElement(By.xpath("//a[contains(text(),'Login / Signup')]")).click();
        //to link the login page
        KongaLoginPage login = new KongaLoginPage(driver);
        //enter valid email
        login.getLogin().sendKeys("azakalucy@gmail.com");
        //enter valid pasword
        login.getPassword().sendKeys("chinenye26");
        //click on the login button
        login.getLoginButton().click();
        Thread.sleep(5000);

        try {
            //close the newslestter modal if available
            driver.findElement(By.id("NC_CLOSE_ICON")).click();
        }catch (Exception e){
            //do nothing
        }

        Actions actions = new Actions(driver);
        // Get the account dropdown button
        WebElement accountDropdown = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a"));
        //Hover on the accountDropdown
        actions.moveToElement(accountDropdown);
        //Get the logout item under dropdown and save to variable logoutBtn
        WebElement logoutBtn =  driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a"));
        //Hover on the logout btn
        actions.moveToElement(logoutBtn);
        //compile all the actions to one and perform
        actions.click().build().perform();

        Thread.sleep(5000);





    }


    @AfterTest
    public void stopTest(){
        driver.quit();
    }

}
