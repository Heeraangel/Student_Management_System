package com.student_management_system.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all the Web Driver common action
 * @author HP
 *
 */
public class WebDriverLibrary {
	public WebDriverWait wait;
	public Actions act;
	public Select select;
	public JavaLibrary jl=new JavaLibrary();
	public FileLibrary fileLibrary=new FileLibrary();
	//public TakesScreenshot ts;
	//static JavascriptExecutor js;
	/**
	 * This method is used to navigate the application
	 * @param driver
	 * @param url
	 */
	public  void navigateApp(WebDriver driver,String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public  void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicit wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public  void waitTillPageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to maximize the browser and implicit wait
	 * @param longTimeOut
	 * @param driver
	 */
	public  void browserSetting(long longTimeOut,WebDriver driver)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut,driver);
	}
	/**
	 * This method is used to initilize the actions class
	 * @param driver
	 */
	public void initilizeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover element
	 * @param driver
	 * @param wb
	 * @param driver 
	 * @param driver 
	 */
	public void mouseHoverOnTheElement(WebElement wb)
	{
		
		act.moveToElement(wb).perform();
	}
	/**
	 * This method is used to quit the browser
	 * @param driver
	 */
	public  void quit(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is used to web driver wait
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitWaitUsingVisibility(WebDriver driver,long timeOut,WebElement element) 
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to web driver wait the is clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void explicitWaitUsingElementClick(WebDriver driver,long timeOut,WebElement element) 
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to switch window the window based on title
	 * @param driver
	 * @param current_id
	 * @param partialText
	 */
	public  void switchToWindowBasedOnTitle(WebDriver driver,String partialText)
	{
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch to the frame
	 * @param wb
	 * @param driver
	 */
	public  void switchToFrame(WebElement wb, WebDriver driver)
	{
		driver.switchTo().frame(wb);
	}
	public void switchToFrame(WebDriver driver,int i)
	{
		driver.switchTo().frame(i);
	}
	/**
	 * This method is used to switch to main frame
	 * @param driver
	 */
	public  void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to parent frame
	 * @param driver
	 */
	public  void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to initilize the select class object
	 * @param element
	 */
	public void initilizeSelectClass(WebElement element)
	{
		select=new Select(element);
	}
	/**
	 * This method is used to select value from dropdown using value
	 * @param element
	 * @param value
	 * @param element 
	 * @param element 
	 */
	public void dropdown(String value, WebElement element)
	{
		initilizeSelectClass(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to select value from dropdown using index
	 * @param index
	 * @param element 
	 * @param element 
	 */
	public  void dropdown(int index, WebElement element)
	{
		initilizeSelectClass(element);
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select value from dropdown using visible text
	 * @param value
	 * @param element 
	 */
	public  void dropdown( WebElement element,String value)
	{
		initilizeSelectClass(element);
		select.selectByVisibleText(value);
	}
	/**
	 * This method is used to take screen shot
	 * @param driver
	 * @param fileName
	 * @return 
	 * @throws IOException
	 */
	public  String takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+fileName+"-"+jl.dateTimeInFormat()+".png");
		FileUtils.copyFile(src,dst);
		return dst.getAbsolutePath();
	}
	/**
	 * This method is used to initilize the java script
	 * @param driver
	 * @param script 
	 */
	public  void scrollByUsingJavaScript(WebDriver driver, String script)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
	}
}