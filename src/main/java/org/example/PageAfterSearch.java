package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PageAfterSearch extends Utils{
    LoadProp loadprop = new LoadProp();

    private By _AllProductTitles =By.xpath("//div[@class=\"item-box\"]/div/div[2]/h2/a");

    public void UserShouldVerifySearchedTextPageUrl(){
        String ActualUrl = driver.getCurrentUrl();
        System.out.println(ActualUrl);
        Assert.assertTrue(ActualUrl.contains(loadprop.getProperty("TextForSearch")));
    }
    public void UserShouldVerifyIfAllProductsContainsSearchedText(){
        //CreatingStringListFromWebElementListForProductsOnPage
        ArrayList<String> SearchedProductsList = new ArrayList<>();
        List<WebElement> ProductsList = driver.findElements(_AllProductTitles);
        System.out.println(ProductsList.size());
        for(WebElement w:ProductsList) {
            SearchedProductsList.add(w.getText());
            System.out.println(w.getText());
            //VerifyThatAllProductsContainSearchedText
            Assert.assertTrue(w.getText().contains(loadprop.getProperty("TextForSearch")));
        }
    }
}
