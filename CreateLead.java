package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@Test(invocationCount = 2 , groups = "quickcheck")
	public void LeafTapsCreatelead() {

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click on create lead link
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter companyName, firstName and lastName

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Perficient");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Muthulakshmi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raghav");

		// Enter Firstname_local, department,description and email
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Muthu");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation Tester");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sai@gmail.com");

		// State/Province as NewYork
		WebElement dropdown1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select choice = new Select(dropdown1);
		choice.selectByVisibleText("New York");

		// Click on create button
		driver.findElement(By.className("smallSubmit")).click();

		// Get the resulting page title
		driver.findElement(By.id("sectionHeaderTitle_leads")).isDisplayed();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
