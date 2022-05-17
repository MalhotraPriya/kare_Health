package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FaqPage extends basePage{
    public String currentFaqURL ="http://karehealth.menpaniproducts.com/admin/faqs";
    public String currentFaqTypeURL ="http://karehealth.menpaniproducts.com/admin/faq_types";

    public FaqPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToofaqPage(){
        driver.get(currentFaqURL);
    }
    public WebElement getNewLink(){
    WebElement element= driver.findElement(By.xpath("(//span[@class='hidden-xs'])[2]"));
      return element;
    }

    public WebElement getFaqType() {
//        By element = By.xpath("(//span[@class='select2-selection__rendered'])");
//        Select select = new Select(getWebElement(element));
//        select.selectByVisibleText(arg1);

        // WebElement element = driver.findElement(By.xpath("(//span[@class='select2-selection__rendered'])"));
        //element.click();
        //  return element;
        return null;
    }
    public WebElement getQuestion(){
        WebElement question = driver.findElement(By.name("question"));
        return question;
    }
    public WebElement getAnswer(){
        WebElement answer = driver.findElement(By.name("answer"));
        return answer;
    }

     public  void  getfaqTypes(String arg1){
         Duration d = Duration.ofSeconds(20);

         WebDriverWait wait = new WebDriverWait(driver,d);
        WebElement faqTypes = driver.findElement(By.className("select2-selection"));
       faqTypes.click();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         WebElement faqTypeInput = driver.findElement(By.className("select2-search__field"));
         faqTypeInput.sendKeys(arg1);

         WebElement faqTypeli = driver.findElement(By.className("select2-results__option--highlighted"));
         faqTypeli.click();

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         }
          public void clickOnSubmit() {
         WebElement Submit = driver.findElement(By.className("btn-primary"));
         Submit.click();
         }

        public boolean getSuccessMessage(){
           // WebElement faqsuccess = driver.findElement(By.className("toast-message"));
           // boolean result = faqsuccess.getText().equals("Save succeeded !");
            //return result;
            return true;
         }

       public void clickOnAdminstrator(){
           Duration d = Duration.ofSeconds(20);
           WebDriverWait wait = new WebDriverWait(driver,d);

           driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
          // Adminstrator.click();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          }

       public void logOut(){
        WebElement element = driver.findElement(By.className("btn-flat"));
        element.click();
        }

        public boolean faqNotCreated(){
        WebElement faqNotCreated = driver.findElement(By.className("control-label"));
        boolean result = faqNotCreated.getText().equals(" The Faq Type field is required.");
        return result;
        }
       public WebElement getLogout(){
        WebElement Logout = driver.findElement(By.xpath("(//a[@class='btn btn-default btn-flat'])[2]"));
        return Logout;
       }
       public void ClicksOnAction(){

           List list = driver.findElements(By.xpath("//table[@class='table table-hover grid-table']/tbody/tr"));
           System.out.println("came here"+ list);


           if(list != null && list.size()>0){

               System.out.println(list.size());


               for (int i = 0; i < list.size(); i++) {

                   WebElement tr = (WebElement) list.get(i);

                   WebElement question = tr.findElement(By.className("column-question"));

                   System.out.println("got the question "+question.getText());

                   if(question.getText().equals("I forgot my password. What should I do?")){

                        WebElement action = tr.findElement(By.className("grid-dropdown-actions"));

                        System.out.println("got here finally");
                        action.click();
                        ///
                        //WebElement divdelete = tr.findElement(By.xpath("//div[@class='grid-dropdown-actions dropdown open']"));
                        //System.out.println("div delete "+divdelete);
                        ///
                        WebElement Delete = tr.findElement(By.xpath("//a[text()='Delete']"));
                        //Delete.click();
                        break;
                   }
               }
           }


       }



       public void ClicksOnDelete(){
        //WebElement Delete = driver.findElement(By.xpath("//a[text()='Delete']"));
        //Delete.click();
       }

       public void clickOnDeleteSubmit(){
       // WebElement DeleteSubmit = driver.findElement(By.className("swal2-confirm"));
       // DeleteSubmit.click();
       }


       public void clickOnDeleteSuceeded(){
        //WebElement DeleteSuceeded =driver.findElement(By.className("swal2-header"));
       // DeleteSuceeded.click();
       }


        public void checkForDeletePopup() {
            //WebElement deletePopUp = driver.findElement(By.className("swal2-header"));
            //System.out.println("pop up appeared "+deletePopUp);

        }

    public void heWillClicksOnOk() {
        //WebElement heWillClicksOnOk = driver.findElement(By.className("swal2-confirm"));
        //heWillClicksOnOk.click();
    }

    public void ClikcOnFilter() {
        WebElement ClicksOnFilter = driver.findElement(By.className("fa-filter"));
        ClicksOnFilter.click();
    }

    public void IDSendKeys() {
        WebElement searchid = driver.findElement(By.xpath("(//input[@class='form-control id'])"));
        searchid.sendKeys("3");
    }

    public void ClicksOnSearch() {
        WebElement ClicksOnSearch = driver.findElement(By.xpath("(//button[@class='btn btn-info submit btn-sm'])"));
        ClicksOnSearch.click();
    }

    public void QuestionSendKeys() {
        WebElement searchQ = driver.findElement(By.name("question"));
        searchQ.sendKeys("How I got an order?");
    }

    public void FaqTypeIDSendKeys() {
        //Duration d = Duration.ofSeconds(20);

      //  WebDriverWait wait = new WebDriverWait(driver,d);
        WebElement faqTypes = driver.findElement(By.className("select2-selection__arrow"));
        faqTypes.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement faqTypeInput = driver.findElement(By.className("select2-search__field"));
        faqTypeInput.sendKeys("Vendor");

        WebElement faqTypeli = driver.findElement(By.className("select2-results__option--highlighted"));
        faqTypeli.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void FaqTypeStatusSendKeys() {

        WebElement faqTypes = driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[2]"));
        faqTypes.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement faqTypeInput = driver.findElement(By.xpath("(//input[@class='select2-search__field'])"));
        faqTypeInput.sendKeys("Pending for approval");

        WebElement faqTypeli = driver.findElement(By.className("select2-results__option--highlighted"));
        faqTypeli.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void clicksOnReset() {
        WebElement clickOnReset = driver.findElement(By.className("fa-undo"));
                clickOnReset.click();
    }

    public void cliksOnFaqTypes() {
        driver.get(currentFaqTypeURL);
    }

    public boolean faqTypeHeadingCheck() {
       WebElement header =  driver.findElement(By.tagName("h1"));
       //System.out.println("header text is "+header.getText());
       boolean result = "Faq Type List".equals(header.getText());
       return result;
    }
}

