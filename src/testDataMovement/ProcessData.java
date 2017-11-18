package testDataMovement;

public class ProcessData {
	
	ProcessData(int i) {
	new storeData(i);
	}

	public int returnData() {
		int sum = storeData.getSum();
		return sum;
		
	}

}
