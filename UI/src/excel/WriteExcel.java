package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		String path = System.getProperty("user.dir") + "//Files";
		String fileName = "new.xlsx";
		String sheetName = "Sheet1";

		WriteExcel we = new WriteExcel();
		we.writeDataToFile(path, fileName, sheetName);

	}

	void writeDataToFile(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		String ext = fileName.split("\\.")[1];
		Workbook workbook = null;
		if (ext.equalsIgnoreCase("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (ext.equalsIgnoreCase("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			System.out.println("Invalid file type");
		}

		Sheet sheet = workbook.createSheet(sheetName);
		int rowId = 0;
		for (int i = 0; i < 15; i++) {
			Row row = sheet.createRow(rowId++);
			for (int j = 0; j < 2; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(i);
			}
		}
		fos.flush();
		workbook.write(fos);
		workbook.close();

	}

}
