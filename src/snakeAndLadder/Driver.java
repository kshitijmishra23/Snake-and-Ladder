package snakeAndLadder;

import snakeAndLadder.entities.Player;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game= new Game(10, 1);
		game.addPlayer(new Player("A"));
		game.addPlayer(new Player("B"));
		game.addPlayer(new Player("C"));
		
		game.launch();

	}

}

