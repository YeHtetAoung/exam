package ass;


import java.util.*;

public class Play {
	
	
	
	static Scanner scanner = new Scanner(System.in);
	
	static Vector<Integer> secretRandom;
	static Vector<Integer> list;
	

	static boolean notOver;
	static int Round = 1;
	static int chance = 3;

	Play() {
		
		notOver = true;
		secretRandom = new Vector<Integer>();
		list = new Vector<Integer>();
	}
	
	
	
	public static void Secret() {
		
		int num;
		boolean notComplete = true;
		Random randomObj = new Random();
		while (notComplete) {
			num = randomObj.nextInt(1,9);
			if (!secretRandom.contains(num)) {
				secretRandom.addElement(num);
				if (secretRandom.size() == 4)
					notComplete = false;
			}

		}
		display("Welcome");
		display("Computer- " + secretRandom);
		//display("Round - " + Round + "\n");
		return;

	}

	public static  void play() {
		Vector<Integer> list = new Vector<Integer>();
		int num;
		String cutString = null;
		boolean notComplete = true;

		while (notComplete) {
			System.out.print("Enter Numbers: ");
			String numString = scanner.next();

			if (numString.length() >= 4) {

				for (int i = 0; i < 4; i++) {

					String n = Character.toString(numString.charAt(i));
					try {
						num = Integer.parseInt(n);

						if (list.contains(num)) {
							display("Duplicate!!!\n");
							list.removeAllElements();
							break;
						}

						else {
							list.addElement(num);
							if (list.size() == 4) {
								notComplete = false;
							}
						}
					} catch (NumberFormatException e) {
						display("Please input Number format!!!");
						list.removeAllElements();
						break;
					}

				}

			} else {
				display("Please input aleast 4 numbers!!!");
			}
		}
		display("Player- " + list + "\n");
		return;
	}

	public static void check(Vector<Integer> computer, Vector<Integer> player) {
		int H = 0, B = 0;
		boolean notOver = true;
		for (int i = 0; i < computer.size(); i++) {
			for (int j = 0; j < player.size(); j++) {
				if (computer.get(i) == player.get(j)) {
					if (i == j)
						H++;
					else
						B++;
				}

			}
		}
		if (H == 4) {
			display("You Win!!!!");
			// display("Computer- " + computer);
			notOver = false;
		} else {
			display("Try again!!!");
			display("Result- " + H + "H\t" + B + "B\n");
			player.removeAllElements();
		}
		chance--;

		return;
	}
	
	public static void display(String print) {
		System.out.println(print);
	}

	
	
	
	
}
