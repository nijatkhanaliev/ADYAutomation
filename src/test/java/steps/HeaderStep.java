package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderPage;
import utils.Driver;

import java.time.Duration;

public class HeaderStep {

    private final WebDriver driver = Driver.getDriver();
    private final HeaderPage headerPage = new HeaderPage();
    private WebDriverWait wait;

    public HeaderStep(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage(){
        driver.get("https://ticket.ady.az/");
    }

    @And("the user clicks on the first  header message")
    public void the_user_clicks_on_the_first_header_message(){
        headerPage.tarifOdenisHeader();
        headerPage.gedisHaqqiLink();
        headerPage.tarifOdenisHeader();
        headerPage.odenisUsullariLink();
        headerPage.tarifOdenisHeader();
        headerPage.biletSenediLink();
        headerPage.tarifOdenisHeader();
        headerPage.biletReturnLink();
        headerPage.tarifOdenisHeader();
        headerPage.elektronBiletLink();
    }

    @When("the user clicks on the second  header message")
    public void the_user_clicks_on_the_second_header_message() {
        headerPage.sernisinSInifleriLink();
        headerPage.birinciSinifLink();
        headerPage.sernisinSInifleriLink();
        headerPage.biznesClassLink();
        headerPage.sernisinSInifleriLink();
        headerPage.standartPlusLink();
        headerPage.sernisinSInifleriLink();
        headerPage.standartSinifLink();
    }

    @And("the user clicks on the third header message")
    public void the_user_clicks_on_the_third_header_message() {
        headerPage.dasimaQaydalariLink();
        headerPage.usaqlarlaSeyahetLink();
        headerPage.dasimaQaydalariLink();
        headerPage.elYukleriLink();
        headerPage.dasimaQaydalariLink();
        headerPage.heyvanlarlaSeyahetLink();
    }

    @Then("the corresponding page should open successfully")
    public void the_corresponding_page_should_open_successfully() {
       assert  headerPage.getMainTitleFromHeyvanlarinDasinmasi()
               .equals("Heyvanların daşınması");
    }

}
