package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTestcase {
	public void readFromExcel(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		File opfile = new File(filePath + "\\output.xlsx");
		FileOutputStream os = new FileOutputStream(opfile);
		FileInputStream is = new FileInputStream(file);
		String fileExtension = fileName.substring(fileName.indexOf("."));
		Workbook workbook = null;
		if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(is);
		} else if (fileExtension.equals(".xls")) {
			workbook = new HSSFWorkbook(is);
		} else {
			System.out.println("Invalid file format");
		}

		Sheet sheet = workbook.getSheet(sheetName);
		int count = 0;
		for (Row row : sheet) {
			ArrayList<String> testCase = new ArrayList<>();
			for (Cell cell : row) {
				System.out.print(cell.toString() + count + " || ");
				count++;
			}
			// System.out.println(testCase.get(3));
			// System.out.println(testCase);
		}
		// System.out.println(testCase);

	}

	public static void main(String[] args) throws IOException {
		ReadExcelTestcase readObject = new ReadExcelTestcase();
		// System.out.println(System.getProperty("user.dir"));
		String filePath = System.getProperty("user.dir") + "\\" + "Files";
//		readObject.readFromExcel(filePath, "Testcase.xlsx", "Data Sheet");
		readObject.readFromExcel(filePath, "Cat_Tests.xlsx", "Data Sheet");
	}

}
