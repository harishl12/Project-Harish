package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellValue {
	public static int getRowCount(String xlPath, String sheet) {
		int rc = 0;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {

		}
		return rc;
	}

	public static String getCellValue(String xlPath, String sheet, int row, int cell) {
		String v = "";
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			v = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} catch (Exception e) {

		}
		return v;
	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		String xlPath = System.getProperty("user.dir") + "\\" + "Files\\Testcase2.xlsx";
		String sheet = "Data Sheet";
		ArrayList<String> list = new ArrayList<>();
		int rc = CellValue.getRowCount(xlPath, sheet);
		for (int i = 1; i <= rc; i++) {
			// String un = CellValue.getCellValue(xlPath, sheet, i, 0);
			// int j = 0;

			String pw = CellValue.getCellValue(xlPath, sheet, i, 1);
			if (pw.equals(""))
				continue;

			if (pw.contains("Description"))
				continue;
			list.add(pw);

		}
		File file = new File(System.getProperty("user.dir") + "\\" + "Files\\good.xlsx");
		FileOutputStream os = new FileOutputStream(file);
		Workbook wb = new XSSFWorkbook();
		Sheet sheet1 = wb.createSheet("test");
		int rows = list.size() / 2;
		int k = 0;
		for (int j = 0; j < rows; j = j + 1) {
			// for (int k = 0; k < rows; k++) {
			Row row = sheet1.createRow(j);
			Cell tgtCell = row.createCell(0);
			tgtCell.setCellValue(list.get(k));
			Cell tgtCell2 = row.createCell(1);
			tgtCell2.setCellValue(list.get(k + 1));
			k = k + 2;
			// }
		}
		wb.write(os);
		System.out.println("list index 0" + list.get(0));
		System.out.println("list index 1" + list.get(1));
		// System.out.println("list index 2" + list.get(2));
		// System.out.println("list index 3" + list.get(3));
		// System.out.println("list index 4" + list.get(4));
		// System.out.println("list index 5" + list.get(5));
		// System.out.println("list index 6" + list.get(6));
		// System.out.println("list index 7" + list.get(7));
	}
}