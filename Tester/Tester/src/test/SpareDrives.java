package test;

public class SpareDrives {
	public static void main(String[] args) {
		int vBrick = 8;
		int numberOfDrives = 810;
		int spare  = getSpare(vBrick, numberOfDrives);
		System.out.println("Spare =->"+spare);
	}

	private static int getSpare(int vBrick, int numberOfDrives) {
		// TODO Auto-generated method stub
		int spareCount = 0;
		spareCount = (numberOfDrives/vBrick)/50;
		if ((numberOfDrives/vBrick)%50 != 0)
			spareCount++;
		spareCount =  spareCount*vBrick;
		return spareCount;
	}

}
