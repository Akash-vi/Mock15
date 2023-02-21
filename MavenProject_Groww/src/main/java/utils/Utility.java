package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	// take a ScreenShorts
	public static void getScreenShot(WebDriver driver, String name) throws IOException {
		Random number = new Random();
		int num = number.nextInt();
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date d = new Date();
		String date = dtf.format(d).replace("/", "-").replace(":", " ");

		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\AKASH\\OneDrive\\Pictures\\Screenshots\\" + name + " " + date + " " + num + ".jpeg");
		FileHandler.copy(src, dest);
	}

	public static String getExcelData(int rollNum, int cellNum) throws EncryptedDocumentException, IOException {
		String path = "G:\\Akash\\Carrier\\Velocity\\Automation\\Excel data\\htmltable.xlsx";
		InputStream file = new FileInputStream(path);

		String data;
		try {
			data = WorkbookFactory.create(file).getSheet("Sheet2").getRow(rollNum).getCell(cellNum).getStringCellValue();
		}

		catch (Exception i) {

			double data1 = WorkbookFactory.create(file).getSheet("Sheet2").getRow(rollNum).getCell(cellNum).getNumericCellValue();
			data = String.valueOf(data1);
		}
		return data;
	}
}
