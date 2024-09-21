package com.google.org;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GoogleCloudTaskTest {
    WebDriver driver;
    GoogleCloudTask task;

    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        task = new GoogleCloudTask(driver);
        driver.get("https://cloud.google.com/products/calculator");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void initialTest(){
        task.startTasks();
    }

    @Test(priority = 1)
    public void fillFormTest(){
        task.fillForm();
    }

    @Test(priority = 2)
    public void submitTest() throws InterruptedException {
        task.submit();
    }

    

}
