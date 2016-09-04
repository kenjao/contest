package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = Integer.valueOf(scan.nextInt()).intValue();
		String consistent = "YES";

		for (int i = 0; i < testCase; i++) {
			int numberOfPhones = Integer.valueOf(scan.nextInt()).intValue();
			List<String> listOfNumbers = new ArrayList<>();
			for (int j = 0; j < numberOfPhones; j++) {
				listOfNumbers.add(scan.nextLine());
			}
			// check for uniquenes
			for (int k = 0; k < numberOfPhones; k++) {
				for (int m = 0; m < numberOfPhones; m++) {
					// loop through check if it exist, if it does it is itself
					// if no then its not consistent
				}
			}

		}

	}

}
