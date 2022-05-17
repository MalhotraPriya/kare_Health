package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends basePage{
    public final static String USERNAME = "admin";
    public final static String PASSWORD = "admin";
    public HomePage (WebDriver driver){
        super(driver);
    }
      public void adminLogin(){
          driver.findElement((By.name("username"))).sendKeys(USERNAME);
          driver.findElement((By.name("password"))).sendKeys(PASSWORD);
          driver.findElement(By.xpath("//button[@type='submit']")).click();

      }

}
