package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NopcommerceNewReleasePage extends Utils{
    LoadProp loadprop = new LoadProp();

    private By _NopcommerceReleaseTitle =By.xpath("//h1");
    private By _CommenterName =By.xpath("//input[@class=\"enter-comment-title\"]");
    private By _ActualComment =By.xpath("//textarea[@class=\"enter-comment-text\"]");
    private By _NewCommentButton =By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]");
    private By _NewCommentMessage =By.xpath("//div[contains(text(),'News comment is successfully added.')]");
    private By _NewCommentAdded =By.xpath("//div[@class=\"footer\"]//preceding::strong[1]");
    private By _AllCommentList =By.xpath("//div[@class='comment-title']");

    public void VerifyUrlNopcommerceNewRelease(){
        //Verify NopcommerceNewRelease URL
        validateURL(loadprop.getProperty("urlNopCommerceNewRelease"));
    }
    public void VerifyNopcommerceNewReleaseTitle() {
        //Verify Title
        VerifyActualAndExpected(_NopcommerceReleaseTitle, "nopCommerce new release!");
    }
    public void UserShouldEnterCommentWithTitle(){
        //Enter comment name
        TypeText(_CommenterName,loadprop.getProperty("CommentName"));
        //Enter new comment
        TypeText(By.xpath("//textarea[@class=\"enter-comment-text\"]"),loadprop.getProperty("Comment"));
        //Click On New Comment Button
        ClickElement(_NewCommentButton);

    }
    public void VerifyResultTextMessage(){
        //Verify comment message after submit
        VerifyActualAndExpected(_NewCommentMessage,"News comment is successfully added.");
    }
    public void VerifyCommentIsAdded(){
        //Verify comment is added in list
        VerifyActualAndExpected(_NewCommentAdded,loadprop.getProperty("CommentName"));
    }

    public void VerifyYourCommentIsLast(){
        //Creating list of all comments
        List<WebElement> AllComments=driver.findElements(_AllCommentList);
        List<String>CommentList = new ArrayList<>();
        for(WebElement t: AllComments){
            CommentList.add(t.getText());
        }
        //Verify that added comment is last in the list
        Assert.assertTrue(CommentList.contains(loadprop.getProperty("CommentName")));
        String LastComment = CommentList.get(CommentList.size()-1);

        Assert.assertEquals(LastComment,loadprop.getProperty("CommentName"),"Comment is not in last place");

    }
}
