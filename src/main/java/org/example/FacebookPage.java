package org.example;

import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class FacebookPage extends Utils{
    public void UserShouldBeAbleToNavigateToFacebookPageSuccessfullyAndComeBackToHomePage() {
        //Creating object for main window handle
        String MainWindow = driver.getWindowHandle();
        //Method to handle New child windows
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                //Switching to child window
                driver.switchTo().window(ChildWindow);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Verify Current Url Contains facebook text
                System.out.println(driver.getCurrentUrl());

                Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
                //Close child window
                driver.close();
            }
            //Switching to main window
            driver.switchTo().window(MainWindow);
        }
    }
}
