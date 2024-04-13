package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins");

        WebDriver driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Test Automation");
        driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).submit();

        String title = driver.getTitle();

        assertEquals("Test Automation - Google Search", title);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}