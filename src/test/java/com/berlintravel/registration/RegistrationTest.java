package com.berlintravel.registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Step;
import java.time.Duration;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.manage().window().maximize();
        openPage("http://localhost:3001/account-management");
    }

    @Test
    public void testSuccessfulRegistration() {
        clickButton("Account Management",
                By.xpath("//section[@id='account-management']//button[1]"));

        clickButton("О НАС",
                By.xpath("//a[contains(text(),'О НАС')]"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Открытие страницы {url}")
    public void openPage(String url) {
        driver.get(url);
    }

    @Step("Клик по кнопке: {buttonName}")
    public void clickButton(String buttonName, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
}