package RaaOnlineProject01.Raaonline;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportRaaonline {
	static ExtentReports extent;
	public static ExtentTest test;
			public static ExtentReports getRepoterObject()
			{
//			    ExtentReports . ExtentSpeakerReporter
				String path=System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reporter=new ExtentSparkReporter(path); 
			    reporter.config().setReportName("Web Automation Results");
			    reporter.config().setDocumentTitle("Test result");
			    
			    extent=new ExtentReports();
			    extent.attachReporter(reporter);
			    extent.setSystemInfo("Tester","janani" );
			    return extent;
			}

		
	}


