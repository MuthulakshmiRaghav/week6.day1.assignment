package week6.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {

	@Test(invocationCount = 2, timeOut = 7000)
	public void LeafTapsEditLead() {

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Muthulakshmi");

		// Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on first resulting lead
		driver.findElement(By.linkText("Muthulakshmi")).click();
		// Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);

		// Click Edit
		driver.findElement(By.linkText("Edit")).click();

		// Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Infosys");

		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Confirm the changed name appears
		String newCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(newCompany);
		if (newCompany.contains("Infosys"))
			System.out.println("New company name is updated");
		else
			System.out.println("New company name is not updated");

	}

}
