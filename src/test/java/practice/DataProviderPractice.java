package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "customerinfo")
	public void createCustomer(String name, int id)
	{
		System.out.println("Customer name is - "+name);
		System.out.println("Customer id is - "+id);
	}
	
	//to run same @Test with diff set / multiple set of data

	@DataProvider(name = "customerinfo")
	public Object[][] getData()
	{
		//rows and columns - there are 3 data sets with 2 info each
		 Object[][] data = new Object[3][2];
		 
		 //First set
		 data[0][0] = "Lekhana";
		 data[0][1] = 12;
		 
		 //Second set
		 data[1][0] = "Aarthy";
		 data[1][1] = 13;
		 
		 //Third set
		 data[2][0] = "Dhananjay";
		 data[2][1] = 14;
		 
		 return data;
	}
	
}
