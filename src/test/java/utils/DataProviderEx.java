package utils;

import org.testng.annotations.DataProvider;

public class DataProviderEx {

	@DataProvider(name="loginData")
	public Object[][] getData(){
		return new Object[][] {
			{"admin123","admin"},
			{"username123","admin"},
			{"Admin","admin123"}
		};
	}

}
