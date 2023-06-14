package Vaibhav_Test.SelFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage firstpage;
	public WebDriver initialzerDriver() throws IOException
	{   Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\SelFramework\\src\\main\\java\\Vaibhav_Test\\SelFramework\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initialzerDriver();
		firstpage = new LandingPage(driver);
		firstpage.goTo();
		return firstpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		String jsoncontent=FileUtils.readFileToString(new File("D:\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\SelFramework\\src\\test\\java\\Vaibhav_Test\\SelFramework\\product.json"),StandardCharsets.UTF_8);
	
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference <List<HashMap<String, String>>>(){});
		
		return data;
	}
	
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}
}
