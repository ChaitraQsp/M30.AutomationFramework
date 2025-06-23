package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserrtionsPractice {
	
	@Test
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(0, 1);//
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		
	}
	
	
	@Test
	public void sampleSoft()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);//
		
		System.out.println("Step 4");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 5");
		
		sa.assertAll();
		
		
	}

}
