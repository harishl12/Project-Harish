package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.collect.Table.Cell;

public class ReadExcel {

	public void readExcelSheet(String path, String fileName, String sheetName) throws IOException {
		File file = new File(path + "\\" + fileName);
		String ext = fileName.substring(fileName.indexOf("."));
		FileInputStream fis = new FileInputStream(file);

		Workbook wb = null;
		if (ext.contains(".xlsx")) {
			wb = new XSSFWorkbook(fis);
		} else if (ext.contains(".xls")) {
			wb = new HSSFWorkbook(fis);
		} else
			System.out.println("Invalid file type");

		Sheet sheet = wb.getSheet(sheetName);

		for (Row row : sheet) {
			for (org.apache.poi.ss.usermodel.Cell cell : row) {
				System.out.println(cell.toString() + " || ");
			}
		}

	}

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources";
		ReadExcel re = new ReadExcel();
		re.readExcelSheet(filePath, "CAT.xlsx", "Sheet1");
	}

}
