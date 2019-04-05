package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Read {

	public void excelRead(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(fileName);
		FileInputStream inputStream = new FileInputStream(file);

		String fileExtension = fileName.substring(fileName.indexOf("."));
		Workbook workbook = null;

		if (fileExtension.equals(".xlsx"))
			workbook = new XSSFWorkbook(inputStream);
		else if (fileExtension.equals(".xls"))
			workbook = new HSSFWorkbook(inputStream);
		else
			System.out.println("Invalid file type");

		Sheet sheet = workbook.getSheet(sheetName);
//		int rowId = 0;
//
//		for (Row row : sheet) {
//			for(Cell cell : row) {
//				CellType type = cell.getCellType();
//				if(cell.getCellType().to)
//			}
//			
//			System.out.print(cell.getStringCellValue());
//		}
	}

	public static void main(String[] args) throws IOException {
		Read readObject = new Read();
		String filePath = System.getProperty("user.dir") + "\\Files";
		readObject.excelRead(filePath, "SCM.xls", "NewPath");
	}

}
