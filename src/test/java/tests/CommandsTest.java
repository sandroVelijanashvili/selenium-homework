package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) {
        //1
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //2
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        //3

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //4
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        System.out.println("Input field enabled and text visible");

        //5
        if (driver.findElement(By.xpath("//button[text()='Disable']")).isDisplayed())
            System.out.println("Button text changed successfully");

        //6
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Bootcamp");
        input.clear();

        //7
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        //8
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));
        if (a.getLocation().getY() == b.getLocation().getY())
            System.out.println("Columns A and B aligned successfully");

        driver.quit();
    }
}
