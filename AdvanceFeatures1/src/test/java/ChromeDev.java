import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.AuthChallengeResponse.Response;
import org.openqa.selenium.devtools.v113.network.model.Request;


import java.util.*;


public class ChromeDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\CP\\VAIBHAV\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		// devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty()));
		// devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
		// Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty(),
		// java.util.Optional.empty(), java.util.Optional.empty()));
		// driver.get("https://www.cricbuzz.com/live-cricket-scores/65805/aus-vs-ind-final-icc-world-test-championship-final-2023");
		// Map<String,Object> coordinates=new HashMap<String,Object>();
		// coordinates.put("latitude",40);
		// coordinates.put("longitude",3);
		// driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates );
		// driver.get("https://www.netflix.com/");
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devtools.addListener(Network.requestWillBeSent(), request -> {

			// org.openqa.selenium.devtools.v113.network.model.Response
			// res=respone.getResponse();

			Request res = request.getRequest();
			System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
		});

		
		devtools.addListener(Network.responseReceived(), respone -> {

			// org.openqa.selenium.devtools.v113.network.model.Response
			// res=respone.getResponse();

			org.openqa.selenium.devtools.v113.network.model.Response res = respone.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo");

		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
