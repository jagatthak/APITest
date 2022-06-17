package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utils{
    LoadProp loadprop = new LoadProp();

    private By _AddToCartButtonForBuildYourOwnComputer =By.xpath("//div[@class='product-grid']//div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");
    private By _SelectProcessor = By.id("product_attribute_1");
    private By _SelectRAM = By.id("product_attribute_2");
    private By _SelectRadioButtonHDD = By.id("product_attribute_3_6");
    private By _SelectRadioButtonOS = By.id("product_attribute_4_9");
    private By _SelectAcrobatReaderOnSoftware = By.id("product_attribute_5_11");
    private By _SelectTotalCommanderOnSoftware = By.id("product_attribute_5_12");
    private By _SelectAddToCartButton = By.id("add-to-cart-button-1");
    private By _selectShoppingCart = By.xpath("//p[1]/a[@href=\"/cart\"]");
    private By _SelectSortByDropDownMenu = By.id("products-orderby");
    private By _AllProductsNames = By.xpath("//div[@class=\"item-box\"]/div/div[2]/h2/a");

    public void UserShouldClickOnAddToCartForBuildYourOwnComputer(){
        ClickElement(_AddToCartButtonForBuildYourOwnComputer);
    }
    public void UserShouldSelectProcessor(){
        Select Processor = new Select(driver.findElement(_SelectProcessor));
        Processor.selectByValue("1");
    }
    public void UserShouldSelectRAM(){
        Select RAM = new Select(driver.findElement(_SelectRAM));
        RAM.selectByValue("3");

    }
    public void UserShouldSelectRadioButton320GBOnHDD(){
        SelectRadioButton(_SelectRadioButtonHDD);
    }
    public void UserShouldSelectRadioButtonVistapremiumOnOS(){
        SelectRadioButton(_SelectRadioButtonOS);
    }
    public void UserShouldClickOnAcrobatReaderAndTotalCommanderOnSoftware(){
        SelectCheckBox(_SelectAcrobatReaderOnSoftware);
        SelectCheckBox(_SelectTotalCommanderOnSoftware);
    }
    public void UserShouldClickOnAddToCart(){
        ClickElement(_SelectAddToCartButton);
    }
    public void UserShouldClickOnShoppingCart(){
        ClickElement(_selectShoppingCart);
    }

    public void UserShouldVerifyDesktopUrl(){
        validateURL(loadprop.getProperty("urlDesktopPage"));

    }

    public void SelectFromDropDownMenu(){
        SelectFromDropDownMenuByValue(_SelectSortByDropDownMenu,loadprop.getProperty("DesktopSortByValue"));
    }
    public void UserShouldCompareToExpectedSortingZToA(){
        //Creating List of Products on Desktop Page From WebElements To String
        ArrayList<String> ActualList = new ArrayList<>();
        List<WebElement> ProductsList = driver.findElements(_AllProductsNames);
        System.out.println(ProductsList.size());

        for(WebElement e:ProductsList){
            ActualList.add(e.getText());
            System.out.println(e.getText());
        }
        //Creating Second list for sorting
        ArrayList<String> ExpectedList = new ArrayList<>();
        for(String a:ActualList){
            ExpectedList.add(a);
        }
        Collections.sort(ExpectedList);
        //Changing sorted list in reverse ZToA Order
        Collections.reverse(ExpectedList);
        //Verify if Products Actually sorted Z to A
        Assert.assertTrue(ExpectedList.equals(ActualList),"Products Are Not Sorted To Z To A");
    }
}
