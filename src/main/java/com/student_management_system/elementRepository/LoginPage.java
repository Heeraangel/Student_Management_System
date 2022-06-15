package com.student_management_system.elementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@id='email']")
	private WebElement userNameTxt;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void loginAction(String username,String password)
	{
		userNameTxt.sendKeys(username,Keys.TAB,password,Keys.ENTER);
	}
}
