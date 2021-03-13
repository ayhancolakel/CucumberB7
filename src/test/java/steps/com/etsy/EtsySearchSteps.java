package steps.com.etsy;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import pages.com.etsypages.EtsyHomePages;
import utils.BrowserUtils;
import utils.Driver;

import java.security.PublicKey;

public class EtsySearchSteps {


    WebDriver driver;
    EtsyHomePages homePages;

    @Before
    public void beforeScenario(){
        // it will run before  each scenario
        System.out.println("before Annotation.");
    }
    @Before("@tc2")
    public void conditionalHook(){
        System.out.println("Conditional Annotation.");

        // condition is run only for tc2
    }

    @After
    public void afterScenario(Scenario scenario){
        // it will run after each scenario
        System.out.println("After Annotation.");
        if(scenario.isFailed()){
            BrowserUtils.takeScreenshot();
        }
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("Before Each Step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("After Each Step");
    }


    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) { // url is coming from feature file
        driver= Driver.getDriver();
        driver.get(url);
    }
    @When("the user search with {string}")   //  for search we need to find webElements location. In EtsHomePage class
    public void the_user_search_with(String searchValue) { //  this parameter taking the value from our scenario
        homePages=new EtsyHomePages(driver);
        homePages.sendSearchKey(searchValue); //sendKeys icin EtsHomePages e method olusturup oyle cagiriyoruz. Boyel implementation

    }
    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle)  {  //expectedTitle is coming from scenario
   String actualTitle= driver.getTitle();
        Assert.assertEquals("Validation of Title",expectedTitle,actualTitle);

    }
}
