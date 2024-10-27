package api.utilities;

	import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportManager implements ITestListener 
	{
	   public ExtentSparkReporter sparkReporter; //UI of the report
	   public ExtentReports extent;//populate common info on the report
	   public ExtentTest test;//creating test case entries in the report and update status of the test methods
	   
	  String repName;
	   	
	   	
	   	 public void onStart(ITestContext testContext) {
	   		 
//	   		 SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//	   		 Date dt = new Date();
//	   		 String currentdatetimestamp=df.format(dt);
	   		 
	   		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	   		 repName = "Test-Report-"+timeStamp+".html";
	   		
	   		
	   	   sparkReporter = new ExtentSparkReporter(".//reports//"+repName);//specify location of the report
	   	   sparkReporter.config().setDocumentTitle("RestAssyredAutomationProject");//Title of report
	   	   sparkReporter.config().setReportName("Pet Store Users API");//name of the report
	   	   sparkReporter.config().setTheme(Theme.DARK);
	   	   
	   	   
	   	   extent=new ExtentReports();
	   	   extent.attachReporter(sparkReporter);
	   	   
	   	   extent.setSystemInfo("Application","Pet Store users API");
	   	   extent.setSystemInfo("Operating System",System.getProperty("os.name"));
	   	   extent.setSystemInfo("User Name",System.getProperty("user.name"));
	       extent.setSystemInfo("Environment","QA");
	       extent.setSystemInfo("user", "AKHIL");
	   	    
	   	    }

	   	  
	   		 
	   public void onTestSuccess(ITestResult result)
	   
	   {
	   		 
		   test = extent.createTest(result.getName());
	 	   test.assignCategory(result.getMethod().getGroups());
	 	   test.createNode(result.getName());
	 	   test.log(Status.PASS,"Test Passed");
	   		 
	   }

	   
	   
	   		 
	   	public void onTestFailure(ITestResult result)
	    
	   	{
	   	   test = extent.createTest(result.getName());
	   	   test.createNode(result.getName());
	 	   test.assignCategory(result.getMethod().getGroups());
	 	   test.createNode(result.getName());
	 	   test.log(Status.FAIL,"Test Failed");
	       test.log(Status.FAIL, result.getThrowable().getMessage());    
	   	 }
	   	
	   	
	   	
	   	
	   	
 	  public void onTestSkipped(ITestResult result)
	    
	   	{
 		  
 		   test = extent.createTest(result.getName());
	   	   test.createNode(result.getName());
	 	   test.assignCategory(result.getMethod().getGroups());
	 	   test.createNode(result.getName());
	 	   test.log(Status.SKIP,"Test Skipped");
	       test.log(Status.SKIP, result.getThrowable().getMessage());
	   	}
	   	
 	  
 	  
	    public void onFinish(ITestContext context) 
	      
	    {
	   		
	   		extent.flush();
	   		
	    }
	    
	    
	    
	    
	    
	}