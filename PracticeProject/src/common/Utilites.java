package common;

import static org.testng.Assert.assertTrue;

public class Utilites {
	
	
	
	
	
	public static void Assert(String ActualValue, String ExpectedValue, String Message) {
		org.testng.Assert.assertEquals(ActualValue, ExpectedValue, Message);
	}
	
	public static void AssertContains(String ActualValue, String ExpectedValue, String Message) {
	if(ActualValue.contains(ExpectedValue)) assertTrue(true);
	else assertTrue(false);
	}

}
