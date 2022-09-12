package KiteTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import Base.Base_Class;
import Pom_Classes.Pom1;
import Pom_Classes.Pom2;
import Pom_Classes.Pom3;
import Utility.Utility_Class;

public class Test_Class extends Base_Class {
	//declare all useful members as global
	Pom1 login1;
	Pom2 login2;
	Pom3 home;
	@BeforeClass
	public void openBrowser()throws Throwable
	{
		initilizeBrowser();
		//all objet are of POM classes
		login1=new Pom1(driver);
		login2=new Pom2(driver);
		home=new Pom3(driver);
	}
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		login1.enterUN(Utility_Class.getTD(0,0));//DPG458
		System.out.println((Utility_Class.getTD(0,0)));
		
		login1.enterPWD(Utility_Class.getTD(0,1));
		login1.clickBTNClick();
		
		login2.enterPIN(Utility_Class.getTD(0,2));
		login2.clickctnBtn();
		
	}
	  @Test
	  public void verifyuserid() throws Throwable{
		  Reporter.log("Running verify userId",true);
		  String acID = home.verifyuserid();
			String expID=Utility_Class.getTD(0, 0);
			Assert.assertEquals(expID,acID,"Both are different TC is failed");
		  
		  
	  }
	 @AfterMethod
	  public void LogOutApp()
	  {
		  Reporter.log("Logout the application",true);
		
	  }
	 
	 @AfterClass
	
	public void closeBrowser() {
		 
	Reporter.log("Close the Browser", true);
	}
	
	
	
	

}
