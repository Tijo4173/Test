package com.share.general;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.share.testdata.DataDriven;
import com.share.utility.Utilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

@Listeners(com.share.listener.ITListeners.class)
public class DriverSetUp extends DataDriven {
	public static AndroidDriver<AndroidElement> driver;
	public static IOSDriver<IOSElement> driver1;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest logger;
	public Properties prop;
	public static Map map;
	public static ExtentTest testlog;

/*
	protected final String package_production= "com.maf.share";
	protected final String package_sit  = "com.maf.sharesit";
	private boolean is_production = false;

	public String getPackage() {

		return is_production?package_production:package_sit;

	}*/

	@BeforeSuite
	public void SetUp() throws MalformedURLException {
		DateFormat currTimeDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		String dateTD= currTimeDate.format(date);

		File file = new File(System.getProperty("user.dir") + "/Results/"+dateTD +"_TestReport");
		if (!file.exists())
		{
			System.out.println("File created " + file);
			file.mkdirs();
		}

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Results/"+dateTD +"_TestReport/AutomationExecutionReport.html");
		//	htmlReporter = new ExtentHtmlReporter("TestReport.html");
		htmlReporter.config().setReportName("Automation Suite Execution Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo(strDeviceName, strDeviceUDID);
		extent.setSystemInfo("Automation", "Android");
		extent.setSystemInfo("QA", "Smithin");
		extent.setSystemInfo("Application", "Share");
		extent.setSystemInfo("AndroidVersion", "9.0");

	}
	@BeforeTest(alwaysRun=true)
	public void CreateDriver() throws Exception {

		String platform = "android";
		if(platform.equalsIgnoreCase("android")) {
			createAndroidDriver();
		}else {
			createiOSDriver();
		}
	}
	public void createAndroidDriver() throws Exception {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Test=="+projectPath);

		//FileInputStream file =new FileInputStream(projectPath+"/Global.properties");
		prop=new Properties();
		prop.load(new FileInputStream("C:\\Users\\thi1907501\\git\\ShareAppV2\\ShareAppV2\\src\\com\\share\\utility\\Global.properties"));
		//		prop.get("StoreApp");
		//		File appDir=new File("src");
		//		File app=new File(appDir,(String) prop.get("StoreApp"));

		//System.out.println(prop.getProperty("TestDataSheet"));
		setExcelFile(prop.getProperty("TestDataPath"), prop.getProperty("TestDataSheetName"));
		map = getCellData();
		////		getDeviceDetails(prop.getProperty("TestDataPath"), "Devicelist");
		//		System.out.println("Device Name  --- " + strDeviceName);
		//		System.out.println("Device UDID --- " + strDeviceUDID);
		Map mapDeviceDetail = getDeviceDetail(prop.getProperty("TestDataPath"), "Devicelist");
		String strDeviceUDID = mapDeviceDetail.get("GalaxyS9").toString();
		System.out.println(mapDeviceDetail.get("GalaxyS9").toString());
		DesiredCapabilities cap = new DesiredCapabilities();
		//String device=(String) prop.get("Device");
		cap.setCapability("device", "Android");
		cap.setCapability("deviceName",strDeviceUDID);
		//cap.setCapability("udid", strDeviceUDID);
		cap.setCapability("appPackage", "com.maf.sharesit");
		cap.setCapability("appActivity", "com.maf.android.share.presentation.splash.SplashActivity");
		cap.setCapability("noReset", "true");
		cap.setCapability("noSign", "true");
		cap.setCapability("autoGrantPermissions","true");


		//cap.setCapability("unicodeKeyboard", "true");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		System.out.println("BeforeTest");

	}

	public void createiOSDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("device", "iOS");
		cap.setCapability("deviceName","iPhone");
		cap.setCapability("platformVersion", "10.1");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath())
		driver1 = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

	}

	@AfterMethod(alwaysRun=true)
	public void setTestResult(ITestResult result) throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String destination=Utilities.getScreenshot(driver,result.getName());
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(destination));
			
		} else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(destination));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
	
	}

	@AfterSuite
	public void reportClose() {
		extent.flush();
		System.out.println("Test Complete");
	}


}
