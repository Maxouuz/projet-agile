package ZombIUT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tabScore {
	public tabScore() {
	}


	public static void readFile() {
		try {
			String data;
			File myObj = new File("ressources/score.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}



}
