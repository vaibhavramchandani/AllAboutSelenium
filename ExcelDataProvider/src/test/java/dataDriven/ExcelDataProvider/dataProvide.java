package dataDriven.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

	@Test(dataProvider = "driveTest")
	public void testCaseData(String name, String comu, String id) {
		System.out.println(name + comu + id);
	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
		// Object[][] data=
		// {{"hello","vaibhav","20"},{"hello","sanskar","11"},{"hello","reddy","10"}};
		// return data;
		DataFormatter formatter = new DataFormatter();
		FileInputStream fis = new FileInputStream("D:\\CP\\VAIBHAV\\Sel.xlsx");
		@SuppressWarnings("resource")
		ArrayList<String> a = new ArrayList<String>();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object Data[][] = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				Data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return Data;

	}

}
