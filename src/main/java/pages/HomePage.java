package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Haradan']")
    public WebElement fromCityInput;

    @FindBy(xpath = "//*[@id='vue-layout']/form/div[1]/div[2]/input")
    public WebElement toCityInput;

    @FindBy(xpath = "//input[@placeholder='Gediş tarixi']")
    public WebElement dateInput;

    @FindBy(xpath = "//*[@id='vue-layout']/form/button")
    public WebElement searchButton;

}
