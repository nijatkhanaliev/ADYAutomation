package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.Driver;

import java.time.Duration;

public class SearchStep {

    private final WebDriver webDriver = Driver.getDriver();
    private final HomePage homePage = new HomePage();
    private WebDriverWait wait;

    public SearchStep(){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Given("user is on the ADY homepage")
    public void user_is_on_the_ady_homepage(){
        webDriver.get("https://ticket.ady.az/");
    }

    @When("user selects from city {string}")
    public void user_selects_from_city(String city){
        homePage.fromCityInput.click();
        homePage.fromCityInput.sendKeys(city);
        homePage.fromCityInput.sendKeys(Keys.ENTER);
    }

    @When("user selects to city {string}")
    public void user_selects_to_city(String city) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(homePage.toCityInput));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('input'));",
                homePage.toCityInput, city
        );

        Thread.sleep(500);

        js.executeScript(
                "arguments[0].dispatchEvent(new KeyboardEvent('keydown', {'key':'Enter'}));",
                homePage.toCityInput
        );
    }

    @When("user selects travel date {string}")
    public void user_selects_travel_date(String date) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(homePage.dateInput));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                homePage.dateInput, date);
        Thread.sleep(500);

        js.executeScript(
                "arguments[0].dispatchEvent(new KeyboardEvent('keydown', {'key':'Enter'}));",
                homePage.toCityInput
        );
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].removeAttribute('disabled')", homePage.searchButton);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.searchButton));
        homePage.searchButton.click();
    }


    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='all_parts']/section[3]/div")));
        boolean isDisplayed = webDriver.findElements(By.xpath("//*[@id='all_parts']/section[3]/div")).size()>0;
        assert isDisplayed;
    }
}
