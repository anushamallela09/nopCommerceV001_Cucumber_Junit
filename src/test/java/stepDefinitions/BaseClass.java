package stepDefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AddNewCustomerPage;
import pageObjects.CustomerPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import java.util.ResourceBundle;


public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CustomerPage customerPage;
    public AddNewCustomerPage addNewCustomerPage;
    public Logger logger = LogManager.getLogger(this.getClass());
    public ResourceBundle rb;



    public static String randomestring() {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

}

