import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




    @RunWith(Cucumber.class)
    @CucumberOptions(
           // features = {"src/test/features/searchProduct.feature"},
            plugin = {"pretty","html:target/Destination.html"}
    )


    public class TestRunner {
        public final static String URL = "http://karehealth.menpaniproducts.com/admin/auth/login";

         public final static String USERNAME = "admin";
         public final static String PASSWORD = "admin";
         public static WebDriver driver;

        @BeforeClass
        public static void StartBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(URL);

        }

       // @AfterClass
       //public static void StopBrowser() {

           // driver.quit();
       // }
    }


