package extentreport;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentreport2 {

	static ExtentTest logger;
	static ExtentReports report;
	
	
	@BeforeClass
	public static void startTest() {
		report=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportsResult.html",true);
	}
	
	@Test
	public void verifyPageTitle() {
		logger=report.startTest("Verify Page Title TC");
		String exp="Google";
		String act ="Google";
		Assert.assertEquals(act, exp);
		logger.log(LogStatus.PASS, "Test case passed");
		
		
	}
@Test
public void verifyPageURL() {
		logger=report.startTest("Verify Page Url TC");
		String exp="Google.com";
		String act ="Yahoo.com";
		Assert.assertEquals(act, exp);
		logger.log(LogStatus.PASS, "Test case passed");
		
		
	}
	
	
@AfterMethod

	
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"Test case failed"+result.getName());
			logger.log(LogStatus.FAIL,"Test case failed"+result.getThrowable());
		}
			
		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.SKIP,"Test case failed"+result.getName());
			logger.log(LogStatus.SKIP,"Test case failed"+result.getThrowable());
		}
	report.endTest(logger);
	}
@AfterClass
public void endTest()
{
	
	report.flush();
	report.close();
}
	
}
	

