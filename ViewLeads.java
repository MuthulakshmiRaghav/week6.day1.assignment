package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ViewLeads extends BaseClass{

	@Test(dependsOnMethods = "week6.day1.assignment.EditLead.LeafTapsEditLead" , groups = "quickcheck")
	public void LeafTapsViewLead() {

		// verify the page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attr = logout.getAttribute("value");

		if (attr.equals("Logout"))
			System.out.println("Successfully logged in");

		// click CRM/SFA link

		driver.findElement(By.linkText("CRM/SFA")).click();

		// click Leads link

		driver.findElement(By.linkText("Leads")).click();

		// click Create Lead link
		driver.findElement(By.linkText("Create Lead")).click();

		// Give inputs for Companyname, Firstname and Lastname

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Perficient");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Muthulakshmi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raghav");
		driver.findElement(By.className("smallSubmit")).click();

		// Verify the Lead page title
		driver.findElement(By.id("sectionHeaderTitle_leads")).isDisplayed();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
