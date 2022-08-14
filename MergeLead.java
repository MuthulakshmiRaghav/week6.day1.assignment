package week6.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class MergeLead extends BaseClass {

	@Test
	public void LeafTapsMergeLead() throws InterruptedException {

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Merge Contacts
		driver.findElement(By.xpath("//li/a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("(//span[@class='requiredField'])[1]/following::a")).click();

		// Switch to Second Window
		Set<String> numOfWindows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(numOfWindows);

		String firstWindow = listOfWindows.get(0);
		String secondWindow = listOfWindows.get(1);
		driver.switchTo().window(secondWindow);
		Thread.sleep(3000);

		// Click on First Resulting Contact
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// Click on Widget of To Contact
		driver.switchTo().window(firstWindow);
		driver.findElement(By.xpath("//td/span[text()='To Contact']//following::a")).click();

		// Click on Second Resulting Contact
		Set<String> numOfWindows2 = driver.getWindowHandles();
		List<String> listOfWindows2 = new ArrayList<String>(numOfWindows2);

		String firstWindow2 = listOfWindows2.get(0);
		String secondWindow2 = listOfWindows2.get(1);
		driver.switchTo().window(secondWindow2);
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(firstWindow2);

		// Click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//Verify the title of the page
		System.out.println(driver.getTitle());

	}

}
