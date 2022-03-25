import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.io.IOException;


public class Firststep {



    public static void main(String[] args) throws InterruptedException, IOException {
        // Подробнее про алерт --------- https://www.guru99.com/alert-popup-handling-selenium.html

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\TESTING\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");


        WebElement elemn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]"));
        elemn.click();
        Thread.sleep(5000);


        // меняем на алерт
        Alert alert = driver.switchTo().alert();


        String text = alert.getText();
        if(text.equals("Please enter a valid user name")){
            System.out.println("correct alert messg");
        }
        else{
            System.out.println("in-correct alert messg");
        }


        //click on OK btn
        alert.accept();


    }
}
