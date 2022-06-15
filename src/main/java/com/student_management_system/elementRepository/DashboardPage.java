package com.student_management_system.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy(xpath="//span[.='Teacher']")
	private WebElement teacherLink;
	
	@FindBy(xpath="//a[.=' Add Teacher']")
	private WebElement addTeacherLink;
	
	@FindBy(xpath="//a[.=' All Teacher']")
	private WebElement allTeacherLink;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickTeacher()
	{
		teacherLink.click();
	}
	public void clickAddTeacher()
	{
		addTeacherLink.click();
	}
	public void clickAllTeacher()
	{
		allTeacherLink.click();
	}
}
