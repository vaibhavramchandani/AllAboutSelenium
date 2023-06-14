package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.crome.driver","D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://crex.live/scoreboard/IQ4/19W/62nd-Match/KB/L/gt-vs-srh-62nd-match-indian-premier-league-2023/live");
		System.out.println(driver.getTitle());;
		driver.close();
	}

}
