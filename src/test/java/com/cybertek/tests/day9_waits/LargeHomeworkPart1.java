package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LargeHomeworkPart1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
         driver.quit();
    }
    @Test
    public void test1(){
        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter “wrong_dob” into date of birth input box.
        Step 4. Verify that warning message is displayed: “The date of birth is not valid”
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();
        driver.findElement(By.cssSelector("[data-bv-field='birthday']")).sendKeys("13/13/5000");

        WebElement warningMessage = driver.findElement(By.cssSelector("[data-bv-field='birthday']"));
        System.out.println("warningMessage.isDisplayed() = " + warningMessage.isDisplayed());
        Assert.assertTrue(warningMessage.isDisplayed(),"The date of birth is not valid");
    }
    @Test
    public void test2(){
        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();

        WebElement programmingLanguages = driver.findElement(By.xpath("//*[.='Select programming languages']"));
        System.out.println("programmingLanguages.isDisplayed() = " + programmingLanguages.isDisplayed());
        Assert.assertTrue(programmingLanguages.isDisplayed(),"Verify that following options for programming languages are displayed: c++, java, JavaScript");
    }
    @Test
    public void test3(){
        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into first name input box.
        Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();
        driver.findElement(By.xpath("//*[@data-bv-field='firstname']")).sendKeys("A");

        WebElement warningMessage = driver.findElement(By.xpath("//*[@data-bv-field='firstname']"));
        System.out.println("warningMessage.isDisplayed() = " + warningMessage.isDisplayed());
        System.out.println("warningMessage.getText() = " + driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText());
        Assert.assertTrue(warningMessage.isDisplayed(),"Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”");
    }
    @Test
    public void test4(){
        /*
        Step 1. Go to https://practice-cybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into last name input box.
        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();
        driver.findElement(By.cssSelector("[data-bv-field='lastname']")).sendKeys("a");


        WebElement lastnameInput = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and less than 64 characters long']"));
        System.out.println("lastnameInput.isDisplayed() = " + lastnameInput.isDisplayed());
        System.out.println("lastnameInput.getText() = " + lastnameInput.getText());

        Assert.assertTrue(lastnameInput.isDisplayed()," Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”");

    }
    @Test
    public void test5() throws InterruptedException {
        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter any valid first name.
        Step 4. Enter any valid last name.
        Step 5. Enter any valid user name.
        Step 6. Enter any valid password.
        Step 7. Enter any valid phone number.
        Step 8. Select gender.
        Step 9. Enter any valid date of birth.
        Step 10. Select any department.
        Step 11. Enter any job title.
        Step 12. Select java as a programming language.
         Step 13. Click Sign up.
        Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("(//*[.='Registration Form'])[2]")).click();
        driver.findElement(By.cssSelector("[data-bv-field='firstname']")).sendKeys("Zeynep");
        driver.findElement(By.cssSelector("[data-bv-field='lastname']")).sendKeys("bak");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("zeynepbak24");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("zeybak@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("zeyzehyas");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("571-622-1204");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("10/10/1980");

        //dropdown
        WebElement dropDownElement = driver.findElement(By.cssSelector("[name='department']"));
        Select stateDown = new Select(dropDownElement);
        stateDown.selectByIndex(0);
        String expectedOption="Select your Department/Office";
        String  actualOption = stateDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify is that first option");

        //dropdown2
        WebElement drop2 =driver.findElement(By.cssSelector("[name='job_title']"));
        Select state2 = new Select(drop2);
        state2.selectByVisibleText("Manager");
        String expectedOpt = "Manager";
        String actualOpt =state2.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOpt,actualOpt,"Verify that first selection");

        //checkbox
        WebElement javaBox = driver.findElement(By.cssSelector("[value='java']"));
        javaBox.click();
        Assert.assertTrue(javaBox.isSelected(),"verify that  java is selected");
        System.out.println("javaBox.isSelected() = " + javaBox.isSelected());

        //click sign up
        driver.findElement(By.xpath("//*[.='Sign up']")).click();

        Thread.sleep(3000);

        WebElement dissapearMessage= driver.findElement(By.xpath("//*[.='Well done!']/../p"));
        String  expectedMessage="You've successfully completed registration!";
        String actualMessage =dissapearMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage,"verify that actual message is equal to expected message");

        System.out.println("dissapearMessage.getText() = " + dissapearMessage.getText());

    }
}
