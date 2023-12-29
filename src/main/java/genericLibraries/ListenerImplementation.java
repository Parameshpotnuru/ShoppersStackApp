package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()
				+" Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Fail");
		System.out.println("Failure occured due to: "+result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot)(BaseClass.sdriver);
		JavaUtility jutil = new JavaUtility();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"
				+result.getMethod().getMethodName()
				+"_"+jutil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Skipped");
		System.out.println("Skipped due to: "+result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Exceution Finished");
	}

}
