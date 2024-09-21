package com.google.org;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudTask {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(xpath="//input[@jsname='YPqjbf' and @type='number' and @value='1']")
    WebElement instances;

    @FindBy(xpath ="//div[contains(@data-idom-key,'custom')]")
    WebElement machineType;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    WebElement selectMachineType;

    @FindBy(xpath = "//div[starts-with(@data-idom-key,'nvidia-tesla-t4')]")
    WebElement gpuOption;


    GoogleCloudTask(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCloudTask startTasks(){
        driver.findElement(By.xpath("//span[@jsname='V67aGc' and @class='UywwFc-vQzf8d']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf' and @data-service-form='8']"))).click();
        driver.findElement(By.xpath("//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf' and @data-service-form='8']")).click();
        return this;
    }

    public GoogleCloudTask fillForm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@jsname='YPqjbf' and @type='number' and @value='1']")));
        instances.click();
        instances.sendKeys(Keys.BACK_SPACE);
        instances.sendKeys("4");
        driver.findElement(By.xpath("//label[@class='zT2df' and @for='107regular']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-idom-key,'custom')]")));
        js.executeScript("arguments[0].click();",machineType);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-value='n1-standard-8']")));
        js.executeScript("arguments[0].click();",selectMachineType);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button/div/span[1]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[starts-with(@data-idom-key,'nvidia-tesla-t4')]")));
        js.executeScript("arguments[0].click();",gpuOption);

       // driver.findElement(By.xpath("//*[@id='c18762']/following-sibling::div")).click();

        WebElement selectingGpu =  driver.findElement(By.xpath("//li[@data-value='nvidia-tesla-v100']"));
        js.executeScript("arguments[0].click();",selectingGpu);


        driver.findElement(By.xpath("//span[@id='c53']/following-sibling::div")).click();
        driver.findElement(By.xpath("//li[starts-with(@class,'MCs1Pd') and @data-value='europe-west4']")).click();
        driver.findElement(By.xpath("//label[@class='zT2df' and @for='1161-year']")).click();
        return this;
    }

    public GoogleCloudTask submit() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Open Share Estimate dialog']")));
        driver.findElement(By.xpath("//button[@aria-label='Open Share Estimate dialog']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[starts-with(@href,'./products/calculator/estimate-preview') and @track-name='open estimate summary']")));
        WebElement estimateSummary = driver.findElement(By.xpath("//a[starts-with(@href,'./products/calculator/estimate-preview') and @track-name='open estimate summary']"));
        js.executeScript("arguments[0].click();",estimateSummary);
        return this;
    }
}
