package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void create()
	{
		Assert.fail();
		System.out.println("create"); //pass
	}


	@Test(dependsOnMethods = "create")
	public void modify()
	{
		System.out.println("modify");
	}


	@Test
	public void delete()
	{
		System.out.println("delete");
	}

}
