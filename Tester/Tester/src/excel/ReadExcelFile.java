package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public void excelRead(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = null;

		String fileExtension = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtension);

		if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtension.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} 
/*		else {
			System.out.println("Invalid file type");
		}
*/
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		System.out.println(rowCount);

	}

	public static void main(String[] args) throws IOException {
		ReadExcelFile readExcelObj = new ReadExcelFile();
		String filePath = System.getProperty("user.dir") + "\\src\\excel";
		System.out.println(filePath);
		readExcelObj.excelRead(filePath, "SCM.xls", "NewPath");
	}

}
