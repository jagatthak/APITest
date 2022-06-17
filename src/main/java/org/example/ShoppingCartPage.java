package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils{
    private By _ActualTextForShoppingCart= By.xpath("//h1[contains(text(),'Shopping cart')]");
    private By _ActualItemAdded = By.className("product-name");

    public void UserShouldVerifyShoppingCartAndBuildYourOwnComputer(){
        String actualText=driver.findElement(_ActualTextForShoppingCart).getText();
        String expectedText="Shopping cart";
        Assert.assertEquals(actualText,expectedText,"This is not Shopping cart");
        String actualItemAdded=driver.findElement(_ActualItemAdded).getText();
        String expectedItemToBeAdded="Build your own computer";
        Assert.assertEquals(actualItemAdded,expectedItemToBeAdded,"Wrong Item has been added");
    }
}
