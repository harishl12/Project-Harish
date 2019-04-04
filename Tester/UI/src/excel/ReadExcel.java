package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public void readFromExcel(String filePath, String fileName, String sheetName) throws IOException {
		String sL = null;
		String type = null;
		String testName = null;
		String description = null;
		String steps = null;
		File file = new File(filePath + "\\" + fileName);
		FileInputStream is = new FileInputStream(file);
		String fileExtension = fileName.substring(fileName.indexOf("."));
		// System.out.println(fileExtension);
		Workbook workbook = null;
		if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(is);
		} else if (fileExtension.equals(".xls")) {
			workbook = new HSSFWorkbook(is);
		} else {
			System.out.println("Invalid file format");
		}

		Sheet sheet = workbook.getSheet(sheetName);

		// int rowCount = sheet.getLastRowNum();
		// System.out.println(rowCount);
		int cellNumber = 1;
		// Map<String, String> testMap =
		for (Row row : sheet) {
			ArrayList<String> testCase = new ArrayList<>();
			for (Cell cell : row) {
				// for(int i=0;i<row.getPhysicalNumberOfCells();i++) {
				// testCase.add(cell.toString());
				// rowList = new ArrayList<Row>();
				// rowList.add(row.getPhysicalNumberOfCells());
				// System.out.println(row.getPhysicalNumberOfCells());
				// testCase.add(cell.toString());
				// if (!cell.toString().equals(""))
				System.out.print(cell.toString() + " || ");
				System.out.println(cellNumber);
				cellNumber++;
				if (cellNumber == 5)
					cellNumber = 1;
			}
			// System.out.println(testCase.get(3));
			// System.out.println(testCase);
		}
		// System.out.println(testCase);

	}

	public static void main(String[] args) throws IOException {
		ReadExcel readObject = new ReadExcel();
		// System.out.println(System.getProperty("user.dir"));
		String filePath = System.getProperty("user.dir") + "\\" + "Files";
		readObject.readFromExcel(filePath, "Test.xlsx", "Data Sheet");
	}

}
