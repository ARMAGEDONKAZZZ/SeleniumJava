package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.time.Duration;

public class Firststep {
public static void main(String[] args) throws InterruptedException, IOException {
        String baseurl = "url your test web-site";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\TESTING\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        driver.get(baseurl);
        Actions actions = new Actions(driver);
        WebElement login = driver.findElement(By.xpath("xpath code"));
        login.click();
        WebElement secondlogin = driver.findElement(By.xpath("xpath code"));
        secondlogin.click();
         Select select = new Select(driver.findElement(By.xpath("xpath code")));
        select.selectByValue("1");
        WebElement choose_login = driver.findElement(By.xpath("xpath code"));
        choose_login.click();
        Thread.sleep(5000);


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("All links in web-site " + links.size());
        List<WebElement> Activelinks = new ArrayList<WebElement>();




        for (int i = 1; i <= links.size(); i = i + 1) {
            System.out.println(((WebElement) links.get(i)).getText());

            WebElement elem = links.get(i);
            String linkUrl = elem.getAttribute("href");

            verifyLinks(linkUrl);

            Thread.sleep(1000);
        }

        driver.quit();
    }



    public static void verifyLinks(String websiteLink) throws IOException, InterruptedException {
        URL url = new URL(websiteLink);
        HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
        httpURLConnect.setConnectTimeout(5000);
        httpURLConnect.connect();

        if(httpURLConnect.getResponseCode() >= 400 ){
            System.out.println(websiteLink+" - "
                    +httpURLConnect.getResponseMessage()+"is a broken link");
        }
        else{
            System.out.println(websiteLink+" - "+httpURLConnect.getResponseMessage());
        }
        Thread.sleep(500);

        httpURLConnect.disconnect();
      }
}
