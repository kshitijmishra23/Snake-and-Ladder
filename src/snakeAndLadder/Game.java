package snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import snakeAndLadder.entities.Board;
import snakeAndLadder.entities.Player;
import snakeAndLadder.services.DiceService;

public class Game {

	Board board;
	Queue<Player> players;
	Queue<Player> winners;
	int diceCount;
	int dimention;
	int size;
	
	public Game(int dimention, int diceCount) {
		this.size = dimention*dimention;
		this.dimention = dimention;
		this.diceCount = diceCount;
		board = new Board(dimention);
		players = new LinkedList<Player>();
		winners = new LinkedList<Player>();
		

	}
	
	public void launch() {
		this.board.print();
		while (players.size() > 1) {
			
			Player currPlayer = players.poll();
			System.out.println();
			System.out.println(currPlayer.getUserName()+"'s turn.");
			System.out.println("Press 'r' to roll the dice.");

			Scanner sc = new Scanner(System.in);
			char c = sc.next().charAt(0);
			makeMove(currPlayer);
			if (currPlayer.getPosition() == size) {
				System.out.println(currPlayer.getUserName() + " won!!!");
				winners.add(currPlayer);
			} else {
				players.add(currPlayer);
			}
			printPositions();
		}
	}

	private void printPositions() {
		for(Player player : players) {
			System.out.println(player.getUserName()+":"+player.getPosition());
		}
		
	}

	private void makeMove(Player player) {
		int currPosition = player.getPosition();
		int move = DiceService.roll(this.diceCount);
		//if move is 6 then you get another chance
		//What to do in case of multiple dices?
		System.out.println("You got: "+move);
		int finalPos = currPosition + move ;
		if(finalPos <= size) {
			if(board.hasSnakeOrLadder(finalPos)) {
				System.out.println(board.getEntity(finalPos).getEncounterMessage());
				finalPos = board.getEntity(finalPos).getEnd();
			}
			System.out.println("Taking you to "+finalPos);
		}else {
			System.out.println("Try again in the next turn.");
			finalPos = currPosition;
		}
		
		player.setPosition(finalPos);
		
	}
	
	public Queue<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public Queue<Player> getWinners() {
		return winners;
	}

	public void setWinners(Queue<Player> winners) {
		this.winners = winners;
	}

	public int getDiceCount() {
		return diceCount;
	}

	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
