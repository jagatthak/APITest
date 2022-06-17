package org.example;

import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends Utils {
    private By _EmailAFriendButton = By.xpath("//button[contains(text(),'Email a friend')]");

    //Click on Email a Friend Button
    public void UsershouldClickOnEmailAFriendButton(){
        ClickElement(_EmailAFriendButton);
    }
}
