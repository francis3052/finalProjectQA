import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\חנא 2\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com/"); // open google page
        driver.get("https://www.youtube.com/"); //open youtube page
        driver.close();


    }
}
