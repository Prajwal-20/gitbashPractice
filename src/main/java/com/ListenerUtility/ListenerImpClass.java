package com.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseUtility.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class ListenerImpClass implements ITestListener,ISuiteListener{
	
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	   System.out.println("======Report Configuration======");
	   String time= new Date().toString().replace(" ","_").replace(":","_");
	   ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
	   spark.config().setDocumentTitle("CRM TEST suite results");
	   spark.config().setReportName("CRM report");
	   spark.config().setTheme(Theme.DARK);
	   
	   //add env information and add test
	   report=new ExtentReports();
	   report.attachReporter(spark);
	   report.setSystemInfo("OS", "Windows-10");
	   report.setSystemInfo("BROWSER", "CHROME-100");
	   
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("=====Report Backup=====");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"===Start===");
	 test = report.createTest(result.getMethod().getMethodName());
	// UtilityClassObject.setTest(test);
	 test.log(Status.INFO,result.getMethod().getMethodName()+"===>started<====");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"==end==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(filepath, testName+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====>FAILED<====");
		//File target = new File("./ScreenShots/"+testName+"+"+time+".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("====skipped====");
	}

	
	
	
	
	

	
}
