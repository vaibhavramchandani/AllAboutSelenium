package Vaibhav_Test.SelFramework;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		String jsoncontent=FileUtils.readFileToString(new File("D:\\eclipse-java-2023-03-R-win32-x86_64 (1)\\eclipse\\SelFramework\\src\\test\\java\\Vaibhav_Test\\SelFramework\\product.json"),StandardCharsets.UTF_8);
	
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference <List<HashMap<String, String>>>(){});
		
		return data;
	}
	
}
	
	
	
//	import java.io.File;
//
//	import java.io.FileReader;
//
//	import java.io.IOException;
//
//	import java.util.HashMap;
//
//	import java.util.List;
//
//
//
//	import org.apache.commons.io.FileUtils;
//
//
//
//	import com.fasterxml.jackson.core.JsonParser;
//
//	import com.fasterxml.jackson.core.JsonProcessingException;
//
//	import com.fasterxml.jackson.core.type.TypeReference;
//
//	import com.fasterxml.jackson.databind.JsonMappingException;
//
//	import com.fasterxml.jackson.databind.ObjectMapper;
//
//	import com.google.gson.JsonArray;
//
//	import com.google.gson.JsonObject;
//
//
//
//	import java.nio.charset.StandardCharsets;
//
//
//
//	public class DataReaderFile {
//
//
//
//	public List<HashMap<String, String>> getJsonFileToMap() throws IOException {
//
//	// Convert json to String
//
//	// String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")
//
//	// + "//src//test//java//FrameworkAutomation//data//PurchaseOrder.json").StandardCharsets.UTF_8);
//
//
//
//	String JsonContent = FileUtils.parse(new FileReader(
//
//	System.getProperty("user.dir") + "//src//test//java//FrameworkAutomation//data//PurchaseOrder.json"))
//
//	.getAsJsonObject();
//
//	// Convert String to HashMap through jackson DataBind
//
//	ObjectMapper mapper = new ObjectMapper();
//
//	List<HashMap<String, String>> data = mapper.readValue(JsonContent,
//
//	new TypeReference<List<HashMap<String, String>>>() {
//
//	});
//
//	return data;
//
//	}
//
//
//
//	}
