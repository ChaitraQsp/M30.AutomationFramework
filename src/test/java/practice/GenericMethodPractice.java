package practice;

public class GenericMethodPractice {
	
	public static void main(String[] args) { //Caller Function
		
		//Hard Coding
//		int a = 10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		
		//add logic
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,40));
		System.out.println(add(sum,40));
		System.out.println(add(40,40));
		System.out.println(add(50,40));
		System.out.println(add(sum,sum));
			
	}

	public static int add(int a, int b)//Called function - generic 
	{
		int c = a+b;
		return c;
	} //subtraction / product / division
}
