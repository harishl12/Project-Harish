package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestcaseCombo {
	public static void main(String[] args) throws IOException {
		AllLists al = new AllLists();

		// workloads
		ArrayList<String> osWorkLoads = new ArrayList<String>();
		al.addItemsToList("OLTP	TYPICAL	DSS	CUSTOM", osWorkLoads);
		ArrayList<String> mfWorkLoads = new ArrayList<String>();
		al.addItemsToList("ONLINE	BATCH	CUSTOM", mfWorkLoads);
		ArrayList<String> avgLogicalVolumes = al.createList(1, 99, 5);

		ArrayList<String> drrEnabled = new ArrayList<String>();
		al.addItemsToList("Yes No", drrEnabled);
		ArrayList<String> drrValues = al.createList(1.3, 8.0, 0.3);
		ArrayList<String> opValues = al.createList(1.0, 6.0, 0.3);
		ArrayList<String> capacity = al.createList(50, 1000, 50);
		Collections.shuffle(capacity);
		ArrayList<String> iOPs = al.createList(10, 250, 10);
		ArrayList<String> replication = new ArrayList<>();
		al.addItemsToList("LocalReplication(Snapshot) SRDF/A SRDF/S", replication);
		ArrayList<String> snapshotCapacity = al.createList(100, 850, 25);
		ArrayList<String> mountedCapacity = al.createList(10, 350, 25);
		ArrayList<String> changeRate = al.createList(3, 100, 5);
		ArrayList<String> srdfScapacity = al.createList(100, 850, 25);
		ArrayList<String> srdfAcapacity = al.createList(100, 850, 25);

		// softwares
		ArrayList<String> softwares = new ArrayList<String>();
//		al.addItemsToList("eNAS D@re CloudArray VVOLS CloudMobility RecoverPoint", softwares);
		al.addItemsToList("eNAS D@re CloudArray VVOLS RecoverPoint", softwares);
		ArrayList<String> mfSoftwares = new ArrayList<String>();
		al.addItemsToList("AutoSwap D@re GDDR zDP", mfSoftwares);
//		ArrayList<String> mixedSoftwares = new ArrayList<String>();
//		al.addItemsToList("eNAS D@re CloudArray VVOLS RecoverPoint  GDDR zDP", softwares);
		ArrayList<String> eNASDM = new ArrayList<String>();
		al.addItemsToList("2 4", eNASDM);
		ArrayList<String> eNASSlics = new ArrayList<String>();
		al.addItemsToList("Tape_Backup 10_GigE_Optical 10_GigE_Copper 1_GigE", eNASSlics);
		ArrayList<String> cloudArray = al.createList(10, 240, 25);
		ArrayList<String> hBE = new ArrayList<String>();
//		al.addItemsToList("Yes No", hBE);
		al.addItemsToList("No", hBE);
		ArrayList<String> vvols = al.createList(1000, 40000, 3000);
		ArrayList<String> vasa = new ArrayList<String>();
//		al.addItemsToList("Yes No", vasa);
		al.addItemsToList("No", vasa);
		ArrayList<String> rp = new ArrayList<String>();
		al.addItemsToList("Yes No", rp);

		// hardware
		ArrayList<String> feConnectivity = new ArrayList<String>();
//		al.addItemsToList("FC_16GB	FC_32GB	NVMeOF	25GbE_iSCSI iSCSI", feConnectivity);
		al.addItemsToList("FC_16GB	FC_32GB	NVMeOF	iSCSI", feConnectivity);
		ArrayList<String> mfFEConnectivity = new ArrayList<String>();
		al.addItemsToList("Ficon_16GB_MM	Ficon_16GB_MM", mfFEConnectivity);
		ArrayList<String> useSCM = new ArrayList<String>();
		al.addItemsToList("No_SCM No_SCM No_SCM No_SCM No_SCM SCM_as_a_tier SCM_as_a_tier All_SCM", useSCM);
		ArrayList<String> useNDM = new ArrayList<String>();
		al.addItemsToList("Yes No", useNDM);
		ArrayList<String> ndmPorts = new ArrayList<String>();
		al.addItemsToList("2 4 6 8", ndmPorts);
		ArrayList<String> useSRDFCompression = new ArrayList<String>();
		al.addItemsToList("Enabled Disabled", useSRDFCompression);
		ArrayList<String> rackTypes = new ArrayList<String>();
		al.addItemsToList("Dell_EMC Third_Party VxBlock 2nd_System IBM_z14_ZR1", rackTypes);
		ArrayList<String> foreignComponents = new ArrayList<String>();
		al.addItemsToList("Yes No", foreignComponents);

		// Advanced
		ArrayList<String> raidLevels = new ArrayList<String>();
//		al.addItemsToList("Raid5-3+1 Raid5-7+1 Raid6-6+2 default default default default default", raidLevels);
		al.addItemsToList(" Raid5-7+1 Raid6-6+2 default default default default default", raidLevels);
		ArrayList<String> nvmeDriveTypes = new ArrayList<String>();
		al.addItemsToList("1.92TB 3.84TB 7.68TB 15.36TB Mixed", nvmeDriveTypes);
		ArrayList<String> scmDriveTypes = new ArrayList<String>();
		al.addItemsToList("750GB 1.5TB Mixed", scmDriveTypes);
		ArrayList<String> numberOfBricks = new ArrayList<String>();
		al.addItemsToList("1 2 3 4 5 6 7 8 default default default default default", numberOfBricks);
		ArrayList<String> cachePerBricks = new ArrayList<String>();
		al.addItemsToList("1TB 2TB Mixed Mixed Mixed Mixed", cachePerBricks);
//		al.addItemsToList("512GB 1TB 2TB Mixed Mixed Mixed Mixed", cachePerBricks);

//		//System.out.println(al.returnRandomElement(capacity));

		// Write data to excel sheet
		String path = System.getProperty("user.dir") + "\\Files";
		String fileName = "power.xlsx";
		String ext = fileName.split("\\.")[1];

		File file = new File(path + "\\" + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		Workbook workbook = null;

		if (ext.equalsIgnoreCase("xlsx"))
			workbook = new XSSFWorkbook();
		else if (ext.equalsIgnoreCase("xls"))
			workbook = new HSSFWorkbook();
		else
			System.out.println("Invalid file type");

		Sheet sheet = workbook.createSheet("power");
		int rowId = 0;
		int count = 1;

		for (String s : capacity) {
			String testcaseName = "Comparison test" + count++ + ", PMax 8000 MF, ";
			String expectedResult = "Expected:\r\n" + "\r\n"
					+ "Compare the results from PowerSizer with Legacy Sizer\r\n"
					+ "1.  Configurations should be similar.\r\n" + "2. Config XML and PPTs.\r\n"
					+ "3. Load Analysis tab, View Reports.\r\n" + "4. View Mapping";
			String steps = "";
			// workloads
			String step1 = "";
			String drr = al.returnRandomElement(drrEnabled);
			String dedupe = "";
			String dedupeVal = "";
			String op = al.returnRandomElement(opValues);
			String iops = al.returnRandomElement(iOPs);
			String rep = al.returnRandomElement(replication);
			String repcap = al.returnRandomElement(snapshotCapacity);
			String wl = al.returnRandomElement(osWorkLoads);
			String mfwl = al.returnRandomElement(mfWorkLoads);
			testcaseName += rep + ", ";

			// softwares
			String step2 = "";
			String sw = al.returnRandomElement(softwares);
			String mfsw = al.returnRandomElement(mfSoftwares);
			String dms = al.returnRandomElement(eNASDM);
			String enasslic = al.returnRandomElement(eNASSlics);
			String cloud = al.returnRandomElement(cloudArray);
			String e2e = al.returnRandomElement(hBE);
			String numberOfVMs = al.returnRandomElement(vvols);
			String vasaprovider = al.returnRandomElement(vasa);
			String replica = al.returnRandomElement(rp);
			testcaseName += mfsw + ", ";

			// hardware
			String step3 = "";
			String fe = al.returnRandomElement(feConnectivity);
			String mffe = al.returnRandomElement(mfFEConnectivity);
			String usescm = al.returnRandomElement(useSCM);
			String ndm = al.returnRandomElement(useNDM);
			String ndmports = al.returnRandomElement(ndmPorts);
			String srdfa = al.returnRandomElement(feConnectivity);
			String srdfs = al.returnRandomElement(feConnectivity);
			String rack = al.returnRandomElement(rackTypes);
			String foreign = al.returnRandomElement(foreignComponents);
			testcaseName += usescm + ", " + mffe + ", ";

			// Advanced
			String step4 = "";
			String raids = al.returnRandomElement(raidLevels);
			String nvme = al.returnRandomElement(nvmeDriveTypes);
			String scm = al.returnRandomElement(scmDriveTypes);
			String bricks = al.returnRandomElement(numberOfBricks);
			String cache = al.returnRandomElement(cachePerBricks);
			testcaseName += raids;

			if (drr.equalsIgnoreCase("yes"))
				dedupe = "enabled";
			else
				dedupe = "disabled";

			if (dedupe.equalsIgnoreCase("enabled"))
				dedupeVal = al.returnRandomElement(drrValues);

			while (Integer.parseInt(repcap) > Integer.parseInt(s)) {
				repcap = al.returnRandomElement(snapshotCapacity);
			}

//			//System.out.println(s + " " + al.returnRandomElement(iOPs));

			// System.out.print("Step-1: Workloads Tab\nSize an PowerMax 2000 scenario, with
			// drr ");
			// System.out.print(dedupe + " " + dedupeVal + " ");
			// System.out.print("Over Subscription Factor values of " + op);
			// System.out.print(",Capacity " + s + ", IOPS " + iops);
			// System.out.print(", Select " + rep + " capacity of " + repcap);
			// System.out.print(", Select workload type as " + wl + "\n");
			step1 += "Step-1: Workloads Tab\nSize an PowerMax 8000 Mixed scenario, ";
//			step1 += dedupe + " " + dedupeVal + " ";
//			while (Double.parseDouble(op) < 1.0) {
//				op = al.returnRandomElement(opValues);
//				break;
//			}

			step1 += "Over Subscription Factor values of " + op;
//			step1 += ",Capacity " + s + ", IOPS " + iops;
			step1 += ",MF Capacity as  " + s + ", IOPS " + iops;
			step1 += ", Select " + rep + " capacity of " + repcap;
//			step1 += ", Select workload type as " + wl + "\n";
//			step1 += ", Select OS workload type as " + wl + ",MF workload as " + mfwl + "\n";
			step1 += ",MF workload as " + mfwl + "\n";

			// softwares
			// System.out.print("Step-2: Softwares Tab \nfrom software tab select software
			// as " + sw);
//			step2 += "Step-2: Softwares Tab \nfrom software tab select software as " + sw;
			step2 += ", MF software as " + mfsw;
			if (sw.equalsIgnoreCase("eNAS")) {
				// System.out.print(", Number of Data Movers " + dms);
				step2 += ", Number of Data Movers " + dms;
				// System.out.print(", eNAS Slics " + enasslic);
				step2 += ", eNAS Slics " + enasslic;
			} else if (sw.equalsIgnoreCase("CloudArray")) {
				// System.out.print(", CloudArray directly connected to VMAX over FC capacity of
				// " + cloud + " TBu");
				step2 += ", CloudArray directly connected to VMAX over FC capacity of " + cloud + " TBu";

			} else if (sw.equalsIgnoreCase("D@re")) {
				if (e2e.equalsIgnoreCase("yes")) {
					// System.out.print(" , Enable End-to-end Efficient Encryption");
					step2 += " , Enable End-to-end Efficient Encryption";
				}
			} else if (sw.equalsIgnoreCase("VVOLS")) {
				if (vasaprovider.equalsIgnoreCase("yes")) {
					// System.out.print(", Enable Embedded VASA Provider");
					step2 += "Enable Embedded VASA Provider";
				}
			} else if (sw.equalsIgnoreCase("RecoverPoint")) {
				if (replica.equalsIgnoreCase("yes")) {
					// System.out.print(
//							"Enable Replica and Primary with Protected Front-End Capacity (TBe) same as total capacity ");
					step2 += "Enable Replica and Primary with Protected Front-End Capacity (TBe) same as total capacity ";
				} else {
					// System.out.print("Enable Primary with Protected Front-End Capacity (TBe) same
					// as total capacity ");
					step2 += "Enable Primary with Protected Front-End Capacity (TBe) same as total capacity ";
				}

			}
			step2 += "\n";
			// System.out.println();

			// hardware tab
			// System.out.print("Step-3: Hardware Tab \nfrom hardware tab, Use SCM option as
			// " + usescm);
			// System.out.print(", select FE connectivity as " + fe);
			step3 += "Step-3: Hardware Tab \nfrom hardware tab, Use SCM option as " + usescm;
//			step3 += ", select FE connectivity as " + fe;
			step3 += ", select FE connectivity as " + mffe;
			if (rep.equalsIgnoreCase("SRDF/A")) {
				String srdfComp = al.returnRandomElement(useSRDFCompression);
				// System.out.print(", SRDF/A connectivity as " + srdfa + " and SRDF compression
				// " + srdfComp);
				step3 += ", SRDF/A connectivity as " + srdfa + " and SRDF compression " + srdfComp;

			}
			if (rep.equalsIgnoreCase("SRDF/S")) {
				if (ndm.equalsIgnoreCase("yes")) {
					// System.out.print(", Configure NDM Ports with Min. NDM Ports " + ndmports);
					step3 += ", Configure NDM Ports with Min. NDM Ports " + ndmports;
				}
				// System.out.print(", SRDF/S Connectivity as " + srdfs);
				step3 += ", SRDF/S Connectivity as " + srdfs;
			}
			// System.out.print(", Rack Type " + rack);
			// System.out.print(", Foreign Components " + foreign + "\n");
			step3 += ", Rack Type " + rack;
			step3 += ", Foreign Components " + foreign + "\n";

			// Advanced
			// System.out.print("Step-4: Advanced Tab \nfrom Advanced Options tab, Select
			// Raid Level " + raids);
			step4 += "Step-4: Advanced Tab \nfrom Advanced Options tab, Select Raid Level " + raids;

			if (usescm.equalsIgnoreCase("No_SCM")) {
				// System.out.print(", nvme Drive Type as " + nvme);
				step4 += ", nvme Drive Type as " + nvme;
			} else if (usescm.equalsIgnoreCase("SCM_as_a_tier")) {
				// System.out.print(", nvme Drive Type as " + nvme);
				// System.out.print(", SCM Drive Type as " + scm);
				step4 += ", nvme Drive Type as " + nvme;
				step4 += ", SCM Drive Type as " + scm;
			} else {
				while (scm.equalsIgnoreCase("750GB")) {
					scm = al.returnRandomElement(scmDriveTypes);
				}
				// System.out.print(", SCM Drive Type as " + scm);
				step4 += ", SCM Drive Type as " + scm;
			}
			// System.out.print(", Min bricks as " + bricks);
			// System.out.print(", Cache per Bricks as " + cache + "\n");
			step4 += ", Min bricks as " + bricks;
			step4 += ", Cache per Bricks as " + cache + "\n";
			steps = step1 + step2 + step3 + step4 + "\n\n" + expectedResult;

			int cellId = 0;
			Row row = sheet.createRow(rowId++);
			Cell cell = row.createCell(cellId++);
			cell.setCellValue(testcaseName);
			Cell cell2 = row.createCell(cellId++);
			cell2.setCellValue(steps);

			System.out.println(testcaseName);
			System.out.println(steps);
		}
		fos.flush();
		workbook.write(fos);
		fos.close();
		workbook.close();
		System.out.println();
	}

}
