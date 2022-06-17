package org.example;

import org.openqa.selenium.By;

public class ComputersPage extends Utils{
    LoadProp loadprop =new LoadProp();

    private By _DesktopButton= By.xpath("//a[@title='Show products in category Desktops']/parent::h2");

    public void UserShouldClickOnDesktops(){
        ClickElement(_DesktopButton);
    }
    public void UserShouldVerifyComputersPageUrl(){
        //Verify computer page Url
        validateURL(loadprop.getProperty("urlComputersPage"));

    }
}
