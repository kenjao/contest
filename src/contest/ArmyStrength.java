package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArmyStrength {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = Integer.valueOf(scan.nextInt()).intValue();
		scan.skip("\n");

		for (int i = 0; i < testCase; i++) {
			int numberOfGodzillaArmy = 0;
			int numberOfMechaGodzillaArmy = 0;

			numberOfGodzillaArmy = scan.nextInt();
			numberOfMechaGodzillaArmy = scan.nextInt();
			scan.skip("\n");

			String godzils;
			String mechas;

			godzils = scan.nextLine();
			mechas = scan.nextLine();

			String[] arrayGodzils = godzils.split(" ");
			String[] arrayMechas = mechas.split(" ");

			int[] intArrayGodz = convertToIntArray(arrayGodzils);
			int[] intArrayMechas = convertToIntArray(arrayMechas);

			intArrayGodz = sort(intArrayGodz);
			intArrayMechas = sort(intArrayMechas);

			List<Integer> godzArmy = convertToList(intArrayGodz);
			List<Integer> mechasArmy = convertToList(intArrayMechas);

			calculateWinner(numberOfGodzillaArmy, numberOfMechaGodzillaArmy, godzArmy, mechasArmy);
		}

		try {
			scan.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	@SuppressWarnings("boxing")
	private static void calculateWinner(int numberOfGodzillaArmy, int numberOfMechaGodzillaArmy, List<Integer> godzArmy,
			List<Integer> mechasArmy) {

		// int minNumberOfAttacks = 0;
		//
		// if(godzArmy > mechasArmy){
		// minNumberOfAttacks = numberOfMechaGodzillaArmy;
		// }
		// else{
		// minNumberOfAttacks = numberOfGodzillaArmy;
		// }

		while (godzArmy.size() >= 1 && mechasArmy.size() >= 1) {
			if (godzArmy.get(0) == mechasArmy.get(0)) {
				// int random = (int) (Math.random() * (1 - 2)) + 2;
				int random = (int) Math.rint(Math.random());
				// System.out.println("Random was" + random);
				if (random == 0) {
					godzArmy.remove(0);
				}
				if (random == 1) {
					mechasArmy.remove(0);
				}
			} else if (godzArmy.get(0) < mechasArmy.get(0)) {
				godzArmy.remove(0);
			} else if (godzArmy.get(0) > mechasArmy.get(0)) {
				mechasArmy.remove(0);
			} else {

			}
		}

		if (godzArmy.size() > mechasArmy.size()) {
			System.out.println("Godzilla");
		} else if (godzArmy.size() < mechasArmy.size()) {
			System.out.println("MechaGodzilla");
		} else {
			System.out.println("uncertain");
		}

	}

	// private static int randInRange(int min, int max) {
	// return min + (int) (rand() / (double) (RAND_MAX + 1) * (max - min + 1));
	// }

	@SuppressWarnings("boxing")
	private static List<Integer> convertToList(int[] arrayList) {
		int arraySize = arrayList.length;
		List<Integer> newList = new ArrayList<>();

		for (int i = 0; i < arraySize; i++) {
			newList.add(arrayList[i]);
		}

		return newList;
	}

	private static int[] sort(int[] list) {
		int size = list.length;
		int temp = 0;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (list[j] > list[i]) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}

		}

		return list;
	}

	private static int[] convertToIntArray(String[] array) {
		int size = array.length;
		int[] newArray = new int[size];

		for (int i = 0; i < size; i++) {
			newArray[i] = Integer.valueOf(array[i]).intValue();
		}
		return newArray;
	}

}
