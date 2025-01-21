package com.ntrs.testpractice;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;



import java.time.Duration;



public class UIAutomationEBAY {

    public static void main(String[] args){


        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

        try {

            // navigate to EBAY website

            driver.get("https://www.ebay.com");

            driver.manage().window().maximize();

            // wait to load

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));



            // Search for 'book'

            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("booksXXX")));

            searchBox.sendKeys("book");

            WebElement searchButton = driver.findElement(By.id("book-btn"));

            searchButton.click();



            // click on the first book on list

            WebElement firstBook = wait.until(ExpectedConditions.elementToBeClickable(Byhref("XYZ")));

            firstBook.click();



            // click 'Add to cart'

            WebElement addcardBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("AccountID_btn")));

            addToCartButton.click();



            // Wait for the confirmation

            WebElement countElementLinks= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Confirmation")));

            String count= countElementLinks.getText();



            // Verify the cart has been updated

            if (count.equals("1")) {

                System.out.println("1 item Added successfully");

            } else {

                System.out.println("failed to add" + count);

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // Close the browser

            driver.quit();

        }

    }

}
