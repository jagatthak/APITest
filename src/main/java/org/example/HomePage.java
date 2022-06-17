package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utils{
    LoadProp loadprop = new LoadProp();

    private By _registrationButton = By.className("ico-register");
    private By _addToCartForBuildYourOwnComputer = By.xpath("//div[@class='product-grid']//div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");
    private By _BuildYourOwnComputerText = By.xpath("//a[contains(text(),'Build your own computer')]");
    private By _SelectCurrencyInDropdown = By.id("customerCurrency");
    private By _BuildYourOwnComputerPriceInEuro = By.xpath("//span[contains(text(),'€1032.00')]");
    private By _BuildYourOwnComputerPriceInUSDollar = By.xpath("//span[contains(text(),'$1,200.00')]");
    private By _ClickOnComputers = By.xpath("//ul[1]/li[1]/a[@href='/computers']");
    private By _SelectGoodRadioButton = By.id("pollanswers-2");
    private By _ClickOnVoteButton = By.id("vote-poll-1");
    private By _SelectVoteErrorMessage = By.className("poll-vote-error");
    private By _SelectTotalVotesMessage = By.className("poll-total-votes");
    private By _ClickOnFacebook = By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]");
    private By _getProductTitles =By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _NopcommerceNewRelease =By.xpath("//div[@class='news-items']/div[2]/div/a[@class='news-title']");
    private By _TextForSearch =By.xpath("//input[@type=\"text\"]");
    private By _ClickOnSearch =By.xpath("//button[@type=\"submit\"]");

    //Verify Homepage
    public void UserShouldVerifyHomePageUrl() {
        urltobe(10, loadprop.getProperty("urlHomePage"));
        validateURL(loadprop.getProperty("urlHomePage"));
    }
    //Click on register button
    public void ClickOnRegisterButton() {
        ClickElement(_registrationButton);
    }

    //Click on Build Your Own Computer
    public void UserShouldClickOnBuildYourOwnComputer() {
        ClickElement(_BuildYourOwnComputerText);
    }

    //Select Euro as Currency
    public void UserShouldSelectEuroAsCurrency() {
        Select CurrencyEuro = new Select(driver.findElement(_SelectCurrencyInDropdown));
        CurrencyEuro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }

    //Verify if Build Your Own Computer Price Changed to Euro
    public void UserShouldVerifyBuildYOurOwnComputerPriceChangedToEuro() {
        String actualPriceForBuildYourOwnComputerInEuro = driver.findElement(_BuildYourOwnComputerPriceInEuro).getText();
        String expectedPriceForBuildYourOwnComputerInEuro = "€1032.00";
        Assert.assertEquals(actualPriceForBuildYourOwnComputerInEuro, expectedPriceForBuildYourOwnComputerInEuro, "Wrong currency");
    }

    //Select USDollar as Currency
    public void UserShouldSelectUSDollarAsCurrency() {
        Select CurrencyUSDollar = new Select(driver.findElement(_SelectCurrencyInDropdown));
        CurrencyUSDollar.selectByValue("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");
    }

    //Verify if Build Your Own Computer Price Changed to Euro
    public void UserShouldVerifyBuildYourOwnComputerPriceChangedToUSDollar() {
        String actualPriceForBuildYourOwnComputerInUSD = driver.findElement(_BuildYourOwnComputerPriceInUSDollar).getText();
        String expectedPriceForBuildYourOwnComputerInUSD = "$1,200.00";
        Assert.assertEquals(actualPriceForBuildYourOwnComputerInUSD, expectedPriceForBuildYourOwnComputerInUSD, "Wrong currency");
    }

    //Click on Computers
    public void UserShouldClickOnComputers() {
        ClickElement(_ClickOnComputers);
    }

    //Click on Good radio button
    public void UserShouldClickGoodRadioButtonForCommunityPoll() {
        ClickElement(_SelectGoodRadioButton);
    }

    //click on Vote
    public void UserShouldClickOnVoteButton() {
        ClickElement(_ClickOnVoteButton);
    }

    //Verify Only registered user can vote
    public void UserShouldVerifyMessageAfterClickingVoteButton() {
        String actualMessage = driver.findElement(_SelectVoteErrorMessage).getText();
        System.out.println(actualMessage);
        String expectedMessage = "vote.";
        Assert.assertFalse(actualMessage.contains("vote"), "User is not registered");
    }

    //    Assert.assertTrue(String.IsNullOrEmpty(actualMessage));}
    //Verify After Registering User Should be able to vote
    public void UserShouldBeAbleTOVoteAfterRegistering() {
        String actualMessage1 = driver.findElement(_SelectTotalVotesMessage).getText();
        System.out.println(actualMessage1);
        String expectedMessage1 = "vote";
        Assert.assertTrue(actualMessage1.contains("vote"), "User is not able to vote");
    }

    //ArrayList to print Four Items On Homepage
    public void GetProductTitles() {
        List<WebElement> productTitles = driver.findElements(_getProductTitles);
        System.out.println(productTitles.size());
        List<String> ProductName = new ArrayList<String>();
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }
    }

    public void UserShouldBeAbleToClickOnFacebookButton() {
        ClickElement(_ClickOnFacebook);
    }

    public void UserShouldSwitchToAlertWithoutRegisteringAndComeBackToParentWindow() {
        //Creating alert Object
        Alert alert = driver.switchTo().alert();
        //Getting Text From Alert
        alert.getText();
        System.out.println(alert.getText());
        //Verify Alert Message
        Assert.assertTrue(alert.getText().contains("Please select an answer"));
        //Close Alert
        alert.accept();
        //Switch to Main Page
        driver.switchTo().parentFrame();
    }


    public void UserShouldClickOnNopCommerceNewRelease(){
        ClickElement(_NopcommerceNewRelease);
    }
    public void UserShouldEnterTextInSearchAndClickOnSearch(){
        //Enter text in searchBox and Click on Search Button
        TypeText(_TextForSearch,loadprop.getProperty("TextForSearch"));
        ClickElement(_ClickOnSearch);
    }

}
