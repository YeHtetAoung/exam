package ass;

import java.io.IOException;
import java.util.*;

public class NumberMatch {
	
	

	public static void main(String[] args) throws IOException {
		
		new Play();
		Play.Secret();
		
		Vector<Integer> SecretNumber = Play.list;

		while (Play.notOver) {
			
			
			Play.display("Round- "+ Play.Round);
			Play.display ("You have " + Play.chance + " chances!!!");
			if (Play.chance == 0) {
				SecretNumber.removeAllElements();

				Play.Round++;
				
				if (Play.Round == 3) {
					Play.display ("Your Round Complete!!!");
					System.exit(0);

				}

				Play.display("Game Over !!!");
				Play.display("Try Another Round!!  y/n?  ");
				char game = (char) System.in.read();
				Play.scanner.nextLine();
				Play.chance = 3;

				if (game == 'y') {
					Play.display ("Start new game!!!");
					Play.display("Round- "+ Play.Round);
					Play.display ("You have " + Play.chance + " chances!!!");
					
					SecretNumber = Play.list;

				} else
					return;
			}

			Play.play();
			Play.check(SecretNumber,Play.list );

		}
	}

	
}
