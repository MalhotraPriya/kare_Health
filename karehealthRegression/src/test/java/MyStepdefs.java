import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.createFAQPage;
import pages.FaqPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

        WebDriver driver;
        HomePage homePage;
        pages.FaqPage FaqPage;
        createFAQPage CreateFAQPage;

        @Before
        public void start(){
            System.out.println("hello came in start");
            driver = TestRunner.driver;
            homePage = new HomePage(driver);
            FaqPage =  new FaqPage(driver);
            CreateFAQPage = new createFAQPage(driver);
        }

        @When("^he login as valid admin to the application$")
        public void heLoginAsValidAdminToTheApplication() {
            homePage.adminLogin();
        }
        @Then("^he should see the dashboard$")
        public void heShouldSeeTheDashboard() {
            Assert.assertTrue(driver.findElement((By.className("sidebar-toggle"))).isDisplayed());
        }

        @When("he clicks on Faqlinks")
        public void heClicksOnFaqlinks() {
            FaqPage.navigateToofaqPage();
        }

        @Then("Newlink will be displayed on that page")
        public void newlinkWillBeDisplayedOnThatPage() {
        Assert.assertTrue(FaqPage.getNewLink().isDisplayed());

        }
        @When("he clicks on new link")
        public void heClicksOnNewLink() {
            FaqPage.getNewLink().click();
        }

        @Then("he create the new FAQ with details  {string},{string},{string}")
        public void heCreateTheNewFAQWithDetails(String arg1, String arg2, String arg3) throws InterruptedException{
        Duration d = Duration.ofSeconds(20);

        WebDriverWait wait = new WebDriverWait(driver,d);
        int  attempts = 0;
        boolean result = false;
        while(attempts < 2) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(FaqPage.getQuestion()));
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        FaqPage.getQuestion().sendKeys("What about his appointment");
            FaqPage.getAnswer().sendKeys("Your appointment is been booked");
            FaqPage.getfaqTypes(arg1);
        }

        @And("submit to create the FAQ")
        public void submitToCreateTheFAQ() {
        FaqPage.clickOnSubmit();
        }

        private WebElement getWebElement(By locator) {
        return driver.findElement(locator);
       }

         @Then("FAQ should  not be created")
         public void faqShouldNotBeCreated() {
        // Assert.assertTrue(FaqPage.getSuccessMessage());
        }

         @And("he should clicks on Administer")
         public void heShouldClicksOnAdminister() {
         FaqPage.clickOnAdminstrator();
         System.out.println("its on Adminsterator");
         Duration d = Duration.ofSeconds(20);

        WebDriverWait wait = new WebDriverWait(driver,d);
        int  attempts = 0;
        boolean result = false;
        while(attempts < 2) {
            try {
                System.out.println("its waiting");
                wait.until(ExpectedConditions.elementToBeClickable(FaqPage.getLogout()));
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        System.out.println("about to click");
        // FaqPage.logOut();
        driver.navigate().to("http://karehealth.menpaniproducts.com/admin/auth/logout");
    }

         @Then("FAQ should be created")
         public void faqShouldBeCreated() {
        
        }
        @Then("admin should logout")
        public void adminShouldLogout() {
            driver.navigate().to("http://karehealth.menpaniproducts.com/admin/auth/logout");
        }

        @Then("he create the new FAQ without the Question")
       public void heCreateTheNewFAQWithoutTheQuestion() {
            Duration d = Duration.ofSeconds(20);

            WebDriverWait wait = new WebDriverWait(driver,d);
            int  attempts = 0;
            boolean result = false;
            while(attempts < 2) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(FaqPage.getQuestion()));
                    result = true;
                    break;
                } catch(Exception e) {
                }
                attempts++;
            }
          //  FaqPage.getQuestion().sendKeys("What about his appointment");
            FaqPage.getAnswer().sendKeys("Your appointment is been booked");
            FaqPage.getfaqTypes("Doctor");

       }
        @Given("Admin is in landing page")
       public void admin_is_in_landing_page() {

       }

    @Then("Action will be displayed on the page FAQ Page")
    public void actionWillBeDisplayedOnThePageFAQPage() {
    }

    @When("he clicks on Action")
    public void heClicksOnAction() {
            FaqPage.ClicksOnAction();
    }

    @Then("Edit and Delete will be displayed")
    public void editAndDeleteWillBeDisplayed() {

    }

    @When("he clicks on Delete")
    public void heClicksOnDelete() {
            FaqPage.ClicksOnDelete();
    }

    @Then("he will see the message Are you sure to delete the item?")
    public void heWillSeeTheMessageAreYouSureToDeleteTheItem() {
            FaqPage.checkForDeletePopup();

    }

    @When("he clicks on Submit")
    public void heClicksOnSubmit() {
            FaqPage.clickOnDeleteSubmit();
    }

    @Then("he will be able to see the message Delete succeeded!")
    public void heWillBeAbleToSeeTheMessageDeleteSucceeded() {
            FaqPage.getSuccessMessage();
    }

    @And("he will clicks on ok")
    public void heWillClicksOnOk() {
            FaqPage.heWillClicksOnOk();
    }

    @Then("he will clicks on Filter")
    public void heWillClicksOnFilter() {
            FaqPage.ClikcOnFilter();
    }

    @When("he will see the search form")
    public void heWillSeeTheIDForm() {
    }

    @Then("he will put the ID number")
    public void heWillPutTheIDNumber() {
            FaqPage.IDSendKeys();
    }

    @And("he will clicks on Search")
    public void heWillClicksOnSearch() {
            FaqPage.ClicksOnSearch();
    }

    @Then("he will get the result")
    public void heWillGetTheResult() {

    }

    @Then("he will put the Question")
    public void heWillPutTheQuestion() {
            FaqPage.QuestionSendKeys();
    }

    @Then("he will put the Faq Type Id")
    public void heWillPutTheFaqTypeId() {
           FaqPage.FaqTypeIDSendKeys();
    }

    @Then("he will put the Status")
    public void heWillPutTheStatus() {
            FaqPage.FaqTypeStatusSendKeys();
    }

    @Then("he clicks on Reset")
    public void heClicksOnReset() {
            FaqPage.clicksOnReset();

    }

    @And("admin should see the FAQ Page")
    public void adminShouldSeeTheFAQPage() {
    }


    @Then("he should be on Faq Types List Page")
    public void heShouldBeOnFaqTypesListPage() {
    }

    @When("he should clicks on Filter")
    public void heShouldClicksOnFilter() {
    }
    @Then("he should clicks on Faq Types")
    public void heShouldClicksOnFaqTypes() {
            FaqPage.cliksOnFaqTypes();
    }

    @Then("he should be able to see the Faq Type List Form")
    public void heShouldBeAbleToSeeTheFaqTypeListForm() {
            boolean result = FaqPage.faqTypeHeadingCheck();
            Assert.assertTrue(result);
    }

    @And("he should TypeName in TypeName box")
    public void heShouldTypeNameInTypeNameBox() {
    }

    @Then("he should clicks on Search")
    public void heShouldClicksOnSearch() {
    }


}



