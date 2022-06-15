package com.student_management_system.TeacherTest;
import org.testng.annotations.Test;

import com.student_management_system.elementRepository.AddTeacherPage;
import com.student_management_system.elementRepository.DashboardPage;
import com.student_management_system.genericLibrary.BaseClass;

public class TC_Teacher_02_AddTeacher extends BaseClass{
	@Test
	public void addTeacher()
	{
		DashboardPage dashboardPage=new DashboardPage(driver);
		AddTeacherPage addTeacherPage=new AddTeacherPage(driver);
		dashboardPage.clickTeacher();
		dashboardPage.clickAddTeacher();
		
		
	}
}
