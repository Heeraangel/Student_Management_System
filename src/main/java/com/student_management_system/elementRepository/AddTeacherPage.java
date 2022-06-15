package com.student_management_system.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.student_management_system.genericLibrary.WebDriverLibrary;

public class AddTeacherPage {
	WebDriverLibrary webDriverLibrary=new WebDriverLibrary();
	@FindBy(xpath="//input[@id='index_number']")
	private WebElement indexNumberTxt;
	
	@FindBy(xpath="//input[@id='full_name']")
	private WebElement fullNameTxt;
	
	@FindBy(xpath="//input[@id='i_name']")
	private WebElement nameWithInitialsTxt;
	
	@FindBy(xpath="//input[@id='address']")
	private WebElement addressTxt;
	
	@FindBy(xpath="//input[@id='address']")
	private WebElement genderDropdown;
	
	public AddTeacherPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void addTeacher()
	{
		indexNumberTxt.sendKeys("1002");
		fullNameTxt.sendKeys("Liya");
		nameWithInitialsTxt.sendKeys("F");
		addressTxt.sendKeys("Kerala");
		webDriverLibrary.dropdown(,);
		
	}
	
}
