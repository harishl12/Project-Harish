package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyExcel {

	void copyToExcel(String filePath, String src, String tgt, String sheetName) throws IOException {
		String ext = src.substring(src.indexOf("."));
		File srcFile = new File(filePath + "\\src");
		File tgtFile = new File(filePath + "\\tgt");

		FileInputStream sfis = new FileInputStream(srcFile);
//		FileOutputStream tfos = new FileOutputStream(tgtFile);

//		Workbook swb = null;
		XSSFWorkbook twb = null;

		if (ext.contains(".xlsx")) {
//			Workbook swb = new XSSFWorkbook(sfis);
//			twb = new XSSFWorkbook();
//
//		}else if(ext.contains(".xls")) {
//			swb = new HSSFWorkbook();
		}

	}

	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\Files";
		CopyExcel copy = new CopyExcel();
		copy.copyToExcel(filePath, "OPTS.xlsx", "copiedOPTS.xlsx", "Sizer");
	}

}
