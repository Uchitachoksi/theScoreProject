package UchitachoksiTesting.theScoreProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class theScoreApp{
	
	AndroidDriver driver;
	public static ExtentReports extent;
	
	@BeforeClass
	public void configurationtest() throws MalformedURLException, URISyntaxException
	{
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("SCOREAPPDEVICE");
		options.setApp("//Users//uchita//eclipse-workspace//theScoreProject//src//main//java/resource//theScore_ Sports News & Scores_24.4.0_Apkpure.apk");
	    driver= new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void AppSetUp()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));	
		driver.findElement(By.id("com.fivemobile.thescore:id/accept_button")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
		
	}
	@Test
	public void LeagueSelection()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name']")).click();
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_allow")).click();
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name']")).click();
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
		driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void TeamSelection()
	{
		driver.findElement(By.id("com.fivemobile.thescore:id/icon_team_logo")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Team Stats']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
	}	
	
	@Test(dataProvider="getdata")
	public void searchplayername(String name)
	{
		driver.findElement(By.id("com.fivemobile.thescore:id/search_bar_text_view")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.fivemobile.thescore:id/search_src_text")).sendKeys(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Career")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
	}
	@DataProvider
	public String[][] getdata()
	{
		
		String a[][] = {{"kelce"}};
		return a;
	}		
}


	



