package week6.day1.assignment;

import org.testng.annotations.Test;

public class PriorityAndEnabledCheck {

	@Test(priority = 2)
	public void test1() {
		System.out.println("Priority == 2");
	}

	@Test(priority = 3)
	public void test2() {
		System.out.println("Priority == 3");
	}

	@Test(priority = 4, enabled = false)
	public void test3() {
		System.out.println("Priority == 4");
	}

	@Test
	public void Test4() {
		System.out.println("Priority == 1");
	}
}
