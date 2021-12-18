package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageObjects.AddNewCustomerPage;
import pageObjects.CustomerPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class LoginSteps extends BaseClass{
   public WebDriver driver;
   public LoginPage loginPage;
   public DashboardPage dashboardPage;
   public CustomerPage customerPage;
   public AddNewCustomerPage addNewCustomerPage;
   String inputEmail = "admin@yourStore.com";

    @Before
    public void setup() {
        rb = ResourceBundle.getBundle("config");
        String br = rb.getString("browser");
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger.info("Launched Chrome Browser");
        } else if
        (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            logger.info("Launched Edge Browser");
        } else if (br.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Launched Firefox Browser");
        }
    }


   @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
       /*logger.info("launch browser");
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();*/
       loginPage = new LoginPage(driver);
   }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        logger.info("openurl");
        driver.manage().window().maximize();
    }
    @When("user enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setLogin(email,password);
        logger.info("Enter user details");
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedText) {
        dashboardPage = new DashboardPage(driver);
        String actualText =   dashboardPage.getDashboardtext();
        if(actualText.equals(expectedText)) {
            logger.info("Dashboard page is displayed");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        logger.info("Log out from application");
        dashboardPage.clickLogout();
    }

    @Then("User navigate to Login Page and Title should be {string}")
    public void user_navigate_to_login_page_and_title_should_be(String expectedTitle) {
    String actualTitle = loginPage.verifyLogout();
        if(actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Then("close browser")
    public void close_browser() {
        logger.info("close browser");
        driver.quit();
    }

    //Add customer
    @When("User click on Customers main Menu and click on Customers sub menu")
    public void user_click_on_customers_main_menu_and_click_on_customers_sub_menu() throws InterruptedException {
            dashboardPage.clickCustomers();
            customerPage = new CustomerPage(driver);
            customerPage.clickAddNew();

    }
    @Then("click on Add new Customer Page and User can view Add customer page")
    public void click_on_add_new_customer_page_and_user_can_view_add_customer_page() {
            addNewCustomerPage = new AddNewCustomerPage(driver);
            addNewCustomerPage.setCustomer((LoginSteps.randomestring() + "@gmail.com"),"India@123","Usha",
                    "Reddy");
        logger.info("Added New Customer");
    }
    @Then("Verify Success Message {string}")
    public void verify_Success_Message(String expectedSuccessMessage) {
        String actualSuccessMessage = customerPage.verifySucessMessage();
        if (actualSuccessMessage.contains(expectedSuccessMessage)) {
            logger.info("Customer added success message");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
    //Search Customer
    @When ("User click on Customers main Menu and click on Customers sub menu in Dashboard Page")
    public void clickCustomers() throws InterruptedException {
        dashboardPage.clickCustomers();
    }

    @When("Enter Customer Mail and click on search button")
    public void enter_customer_mail_and_click_on_search_button() throws InterruptedException {
        customerPage= new CustomerPage(driver);
        customerPage.setSearch(inputEmail);
        logger.info("Customer is searched");
    }
    @Then("User should found email in Search table")
    public void user_should_found_email_in_search_table() {
      String actualSearchEmail = customerPage.verifySearchEmail();
      if(actualSearchEmail.equals(inputEmail)) {
          logger.info("searched Email id should displayed in the search results");
          Assert.assertTrue(true);
      }
      else {
          Assert.assertFalse(false);
      }
    }
}
