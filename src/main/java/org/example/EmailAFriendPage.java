package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils{
    private By _FriendEmail =By.id("FriendEmail");
    private By _PersonalMessage =By.id("PersonalMessage");
    private By _SendEmailButton = By.xpath("//button[contains(text(),'Send email')]");
    private By _ActualMessage = By.className("result");

    //Enter Friend's Email
    public void UserShouldEnterFriendEmail(){
        TypeText(_FriendEmail,"loy123"+RandomDate()+"@gmail.com");
    }
    //Enter Personal Message
    public void  UserShouldEnterPersonalMessage(){
        TypeText(_PersonalMessage,"This is a very good product");
    }
    //Click on Send Email
    public void UserShouldClickOnSendEmail(){
        ClickElement(_SendEmailButton);
    }
    //Verify Actual message and Expected message is same
    public void UserShouldVerifyTheMessage(){
        String actualmessage1=driver.findElement(_ActualMessage).getText();
        String expectedmessage1="Your message has been sent.";
        Assert.assertEquals(actualmessage1,expectedmessage1,"Message has not been sent");
    }
}
