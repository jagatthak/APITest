package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils{
    LoadProp loadprop = new LoadProp();
    private By _RadioButtonForMale = By.id("gender-male");
    private By _TextForFirstName = By.cssSelector("input#FirstName");
    private By _TextForLastName = By.cssSelector("input#LastName");
    //    private By _DayOfBirth = By.cssSelector("div.date-picker-wrapper>[name |=\"DateOfBirthDay\"]");
//    private By _MonthOfBirth = By.cssSelector("div.date-picker-wrapper>[name |=\"DateOfBirthMonth\"]");
//    private By _YearOfBirth = By.cssSelector("div.date-picker-wrapper>[name |=\"DateOfBirthYear\"]");
    private By _DayOfBirth = By.name("DateOfBirthDay");
    private By _MonthOfBirth =By.name("DateOfBirthMonth");
    private By _YearOfBirth = By.name("DateOfBirthYear");
    private By _Email = By.id("Email");
    private By _Password = By.name("Password");
    private By _ConfirmPassword = By.id("ConfirmPassword");
    private By _RegisterButton = By.name("register-button");

    //verify register page url
    public void UserShouldVerifyRegisterUrl(){
        urltobe(10,loadprop.getProperty("urlRegister"));
        validateURL(loadprop.getProperty("urlRegister"));
    }
    //select Radio Button for Male or Female
    public void UserShouldSelectRadioButton(){
        SelectRadioButton(_RadioButtonForMale);
    }
    //Enter Text for First Name
    public void UserShouldTypeTextForFirstName(){
        TypeText(_TextForFirstName, loadprop.getProperty("firstname"));
    }
    //Enter Text for Last Name
    public void UserShouldTypeTextForLastName(){
        TypeText(_TextForLastName,loadprop.getProperty("lastname"));
    }
    // select BirthDay
    public void UserShouldSelectSuccesfullyDayOfBirth(){
//       try {
//            Select Birthday = new Select(driver.findElement(_DayOfBirth ));
//            Birthday.selectByIndex(3);}
//       catch (Exception e){
//           e.printStackTrace();
//       }
        Select Birthday = new Select(driver.findElement(_DayOfBirth));
        Birthday.selectByValue(loadprop.getProperty("DayOfBirth"));
    }
    // select BirthMonth
    public void UserShouldSelectMonthOfBirth(){
//        try {
//        Select BirthMonth = new Select(driver.findElement(_MonthOfBirth));
//        BirthMonth.selectByValue(loadprop.getProperty("MonthOfBirth"));
//    }catch (Exception e){
//            e.printStackTrace();
//        }

        Select BirthMonth =new Select(driver.findElement(_MonthOfBirth));
        BirthMonth.selectByValue(loadprop.getProperty("MonthOfBirth"));}
    //select BirthYear
    public void UserShouldSelectYearOfBirth() {
//        try {
//            Select BirthYear = new Select(driver.findElement(_YearOfBirth));
//            BirthYear.selectByValue(loadprop.getProperty("YearOfBirth"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Select BirthYear = new Select(driver.findElement(_YearOfBirth));
        BirthYear.selectByValue(loadprop.getProperty("YearOfBirth"));
    }
    //Enter Email
    public void UserShouldEnterEmail(){
        TypeText(_Email,loadprop.getProperty("EmailFirstPart")+RandomDate()+loadprop.getProperty("EmailSecondPart"));
    }
    //Enter Password
    public void UserShouldEnterPassword(){
        TypeText(_Password,loadprop.getProperty("Password"));
    }
    //Confirm Password
    public void UserShouldConfirmPassword() {
        TypeText(_ConfirmPassword,loadprop.getProperty("ConfirmPassword"));
    }
    //Click on Register button
    public void UserShouldClickOnRegisterButton(){
        ClickElement(_RegisterButton);
    }

}
