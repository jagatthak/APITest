package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils{
    private By _ActualMessage =By.className("result");
    private By _ContinueButton = By.xpath("//a[contains(text(),'Continue')]");

    //Verify Actual and expected message after registration
    public void UserShouldRegisterSuccessfully(){
        String actualmessage=driver.findElement(_ActualMessage).getText();
        String expectedmessage="Your registration completed";
        Assert.assertEquals(actualmessage,expectedmessage,"Registration is not working");
    }
    //Click on continue
    public void UserShouldClickOnContinueButton(){
        ClickElement(_ContinueButton);
    }

}
