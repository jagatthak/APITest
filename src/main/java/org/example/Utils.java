package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage{
    //User defined methods for driver

    //For taking screenshot
    public void takeSnapShot(String a){
        //Convert webdriver object to take screenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshots\\"+a+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //for random date using
    public String RandomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String CurrentDate = formatter.format(date);
        return CurrentDate;}

    public void TypeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public void ClickElement(By by)
    {
        driver.findElement(by).click();
    }
    public void getTextFromElement(By by)
    {
        driver.findElement(by).getText();
    }
    public void validateURL(String URL){
        String ActualURL=driver.getCurrentUrl();
        System.out.println(ActualURL);
        String ExpectedURL =URL ;
        Assert.assertEquals(ActualURL,ExpectedURL,"Wrong URL");
    }
    public void VerifyActualAndExpected(By by,String text){
        String ActualText = driver.findElement(by).getText();
        System.out.println(ActualText);
        String ExpectedText =text;
        Assert.assertEquals(ActualText,ExpectedText,"Wrong Text");

    }
    public void SelectRadioButton(By by){
        WebElement radio1 = driver.findElement(by);
        radio1.click();
    }
    public void SelectCheckBox(By by) {
        WebElement Checkbox = driver.findElement(by);
        Checkbox.click();
        for (int i = 0; i < 2; i++) {
            System.out.println(Checkbox.isSelected());
        }
    }
    public void SelectFromDropDownMenuByValue(By by,String Value){
        Select BirthMonth = new Select(driver.findElement(by));
        BirthMonth.selectByValue(Value);
    }

    //Explicit Wait methods
    // wait before it clicks the element
    public void waittillclickable(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // wait till element selected
    public void waittillselsect(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }
    // wait till confirming url
    public void urltobe(int time,String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    //wait till url contains
    public void waittillurlcontains(int time,String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(url));
    }
    // wait till title contain specific string
    public void titlecontain(int time,String title){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }
    // wait till certain text selected at given location
    public void waittillTexttobe(int time,String text,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by,text));
    }
    // wait till title loaded as given
    public void waittilltitleis(int time,String title){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(title));
    }
    // wait till element becomes invisible
    public void waittillinvisibility(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    // wail till element becomes present
    public void waittillpresenceofelement(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    // wait till text becomes present
    public void waittillitexttobepresent(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElementValue(by,"First"));
    }
    // wait till element is visible
    public void waittillvisibile_element(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //wait till attribute to be
    public void waittillattributetobe(int time,By by,String id,String path){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by,id,path));
    }
    //wait till attribute contains
    public void waittillattributecontains(int time,WebElement button,String name,String strvalue){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(button,name,strvalue));
    }
    //wait till attribute to be not empty
    public void waittillattributetobenotempty(int time,WebElement button,String name){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(button,name));
    }
    //wait till element is visible
    public void waittillElementIsVisible(int time,WebElement register){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(register));
    }
    //wait till element is present
    public void waittillalertispresent(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //wait till element selected
    public void waittillelementselected(int time,WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
}
