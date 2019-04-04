package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyToExcel {

	public void copyFromExcelFile(String filePath, String sourceFile, String targetFile, String sheetName)
			throws IOException {
		File srcFile = new File(filePath + "\\" + sourceFile);
		FileInputStream inputStream = new FileInputStream(srcFile);

		Workbook srcWorkBook = null;
		Workbook tgtWorkBook = null;

		String fileExtension = sourceFile.substring(sourceFile.indexOf("."));

		if (fileExtension.equals(".xlsx")) {
			srcWorkBook = new XSSFWorkbook(inputStream);
			tgtWorkBook = new XSSFWorkbook();
		} else if (fileExtension.equals(".xls")) {
			srcWorkBook = new HSSFWorkbook(inputStream);
			tgtWorkBook = new HSSFWorkbook();
		} else {
			System.out.println("Invalid file type");
		}

		Sheet sheet = srcWorkBook.getSheet(sheetName);
		Sheet tgtsheet = tgtWorkBook.createSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int tgtRowId = 0;

		for (Row row : sheet) {
			Row tgtRow = tgtsheet.createRow(tgtRowId++);
			int tgtCellId = 0;
			for (Cell cell : row) {
				CellType type = cell.getCellType();
				System.out.println(type);
				Cell tgtCell = tgtRow.createCell(tgtCellId++);
				if (type.toString().equals("STRING")) {
					System.out.print(cell.getStringCellValue() + " || ");
					tgtCell.setCellValue(cell.getStringCellValue());
				} else if (type.toString().equals("NUMERIC")) {
					System.out.print(cell.getNumericCellValue() + " || ");
					tgtCell.setCellValue(cell.getNumericCellValue());
				} else {
					System.out.print(cell.getStringCellValue());
					tgtCell.setCellValue(cell.getStringCellValue());
				}
			}

		}
		File outFile = new File(filePath + "\\" + targetFile);
		FileOutputStream outputStream = new FileOutputStream(outFile);
		tgtWorkBook.write(outputStream);

	}

	public static void main(String[] args) throws IOException {
		CopyToExcel copyObject = new CopyToExcel();
		String filePath = System.getProperty("user.dir") + "\\" + "Files";
		copyObject.copyFromExcelFile(filePath, "Testcase.xlsx", "Testcase2.xlsx", "Data Sheet");
	}
}
