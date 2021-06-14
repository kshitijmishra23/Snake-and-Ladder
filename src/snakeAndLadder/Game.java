package snakeAndLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import snakeAndLadder.entities.Cell;
import snakeAndLadder.entities.Ladder;
import snakeAndLadder.entities.Player;
import snakeAndLadder.entities.Snake;
import snakeAndLadder.services.BoardGeneratorService;
import snakeAndLadder.services.DiceService;

public class Game {

	ArrayList<Cell> board;
	Queue<Player> players;
	Queue<Player> winners;
	int diceCount;
	int dimention;
	int size;
	
	public Game(int dimention, int diceCount) {
		this.size = dimention*dimention;
		this.dimention = dimention;
		this.diceCount = diceCount;
		board = BoardGeneratorService.generate(dimention);
		players = new LinkedList<Player>();
		winners = new LinkedList<Player>();
		

	}
	
	public void launch() {
		printBoard();
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
			if(board.get(finalPos).hasSnakeOrLadder()) {
				System.out.println(board.get(finalPos).getEntity().getEncounterMessage());
				finalPos = board.get(finalPos).getEntity().getEnd();
			}
			System.out.println("Taking you to "+finalPos);
		}else {
			System.out.println("Try again in the next turn.");
			finalPos = currPosition;
		}
		
		player.setPosition(finalPos);
		
	}
	
	public void printBoard() {
		
		for(int i=size-1; i>0; i--) {
			System.out.print(i+" ");
			if(board.get(i).hasSnakeOrLadder()) {
				System.out.print(board.get(i).getEntity().getString());
			}
			else {
				System.out.print("         ");
			}
			if(i%10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}

	public ArrayList<Cell> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<Cell> board) {
		this.board = board;
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
