package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {

        private final By LatName1 =
                    By.cssSelector("input#TextField1");
        private final By Adress1 =
                By.cssSelector("input#TextField3");
        private final By Postcode1 =
                By.cssSelector("input#TextField5");
        private final By City1 =
                By.cssSelector("input#TextField6");
        private final By CardNumber1 =
                By.cssSelector("div.current-field input#number");
        private final By ExpirationDate =
                By.cssSelector("div.current-field input#expiry");
        private final By SecurityCode =
                By.cssSelector("div.current-field input#verification_value");
        private final By NameCard =
                By.cssSelector("div.current-field input#name");
        private final By PayNowButton =
                By.cssSelector("#checkout-pay-button");
        private final By DiscountCode =
                By.cssSelector("input#ReductionsInput0");

    public CheckOutPage(WebDriver driver) {
        super(driver);
     }

     public void enterLastName(String lastName) {
         WebElement el = waitForVisibility(LatName1, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(lastName);
     }

     public void enterAddress(String address) {
         WebElement el = waitForVisibility(Adress1, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(address);
     }

     public void enterPostcode(String postcode) {
         WebElement el = waitForVisibility(Postcode1, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(postcode);
     }

     public void enterCity(String city) {
         WebElement el = waitForVisibility(City1, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(city);
     }

     public void enterCardNumber(String cardNumber) {
         WebElement el = waitForVisibility(CardNumber1, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(cardNumber);
     }

     public void enterExpirationDate(String expirationDate) {
         WebElement el = waitForVisibility(ExpirationDate, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(expirationDate);
     }

     public void enterSecurityCode(String securityCode) {
         WebElement el = waitForVisibility(SecurityCode, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(securityCode);
     }

     public void enterNameOnCard(String nameOnCard) {
         WebElement el = waitForVisibility(NameCard, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(nameOnCard);
     }

     public void enterDiscountCode(String discountCode) {
         WebElement el = waitForVisibility(DiscountCode, DEFAULT_TIMEOUT_SECONDS);
         el.clear();
         el.sendKeys(discountCode);
     }

     public void clickPayNowButton() {
         clickWhenVisible(PayNowButton, DEFAULT_TIMEOUT_SECONDS);
     }
}
