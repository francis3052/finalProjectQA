import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//פרנציס מארון 305233652
// אימאן סליבא 034740183
//דוניא גובראן 065978702


import java.util.List;

import static org.testng.Assert.assertFalse;

public class DemoTest
{
   @BeforeEach
     void testOne()
   {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();//קורא לדריביר
       driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");//מנווט לאתר


   }



   //the first part for the project

   @Test
   void testTwo()
   {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
      WebElement firstName = driver.findElement(By.id("input-firstname"));
       firstName.sendKeys("francis");// מכניס ערך לתא

       WebElement lastName = driver.findElement(By.id("input-lastname"));
       lastName.sendKeys("maroun");// מכניס ערך לתא

       WebElement email = driver.findElement(By.id("input-email"));
       email.sendKeys("fr1234@gmail.com");// מכניס ערך לתא

       WebElement telephone = driver.findElement(By.name("telephone"));
       telephone.sendKeys("0543397460");// מכניס ערך לתא

       WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[1]/div/input"));
       password.sendKeys("123456789");// מכניס ערך לתא

       WebElement confirmpassword = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
       confirmpassword.sendKeys("123456789");// מכניס ערך לתא

       WebElement subscribe = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input"));
       subscribe.click();

       WebElement pri = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]"));
       pri.click();


       driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]")).click();



   }



   @Test
    void testUrl()
   {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://tutorialsninja.com/demo/index.php?route=account/success");
       Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/success", driver.getCurrentUrl());//מאמת כתובת URL

   }

   //part two for the project

   @Test
    void testLogin()
   {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");

       WebElement Emailadress = driver.findElement(By.id("input-email"));
       Emailadress.sendKeys("fr1234@gmail.com");//מכניס ערך לתא

       WebElement password1 = driver.findElement(By.id("input-password"));
       password1.sendKeys("123456789");//מכניס ערך לתא

       WebElement login = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
       login.click();

       Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/account", driver.getCurrentUrl());// מאמת כתובת URL
   }

   //part three for the project

   @Test
    void cartTest()
   {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");

       WebElement addToCart1 = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
       addToCart1.click();//בוחר מוצר

       driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=33");//מנווט לכתובת URL

       WebElement addToCart2 = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
       addToCart2.click();//בוחר מוצר

       WebElement cart = driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
       cart.click();

       String total= driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[4]/td[2]")).getText();

       Assertions.assertEquals("$844.00",total );//בודק אם הסכום תואם



   }

   @Test
    void testFour() throws Exception {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");

       WebElement review = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[3]/a"));
       review.click();

       WebElement name = driver.findElement(By.id("input-name"));
       name.sendKeys("balalna");//מכניס ערך לתא

       WebElement rev = driver.findElement(By.id("input-review"));
       String reviews = "very nice very nice very nice very nice very nice very nice very nice very nice very nice very nice very nice very nice";
       rev.sendKeys(reviews);//מכניס ערך לתא

       WebElement checkbox1= driver.findElement(By.cssSelector("#form-review > div:nth-child(5) > div > input[type=radio]:nth-child(4)"));
       checkbox1.click();

       WebElement cont = driver.findElement(By.xpath("//*[@id=\"button-review\"]"));
       cont.click();

      List<WebElement> massege =driver.findElements(By.xpath("//*[@id=\"form-review\"]/div[2]"));

       assertFalse(massege.size()==0);// בודק שהערך הוא לא NULL

       
   }

}

