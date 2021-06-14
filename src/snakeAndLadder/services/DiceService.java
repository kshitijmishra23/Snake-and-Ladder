package snakeAndLadder.services;

public class DiceService {
	public static int roll(int n) {
		int min = 1;
		int max = n*6;
		return (int) Math.floor(Math.random()*(max-min+1)+min);
	}

}
