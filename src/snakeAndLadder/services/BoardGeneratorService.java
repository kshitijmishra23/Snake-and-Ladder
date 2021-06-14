package snakeAndLadder.services;

import java.util.ArrayList;

import snakeAndLadder.entities.Cell;
import snakeAndLadder.entities.Ladder;
import snakeAndLadder.entities.Snake;

public class BoardGeneratorService {
	public static ArrayList<Cell> generate(int size){
		ArrayList<Cell> board = new ArrayList<Cell>();
		for(int i=0; i<=size*size; i++) {
			Cell cell = new Cell();
			board.add(cell);
		}
		
		for(int i=0; i<size; i++) {
			int min = 2;
			int max = size*size - 1;
			int start = (int) Math.floor(Math.random()*(max-min+1)+min);
			max = start - 1;
			int end = (int) Math.floor(Math.random()*(max-min+1)+min);
			if(!board.get(start).hasSnakeOrLadder()) {
				board.get(start).setEntity(new Snake(start, end));
			}
			max = size*size - 1;
			end = (int) Math.floor(Math.random()*(max-min+1)+min);
			max = end - 1;
			start = (int) Math.floor(Math.random()*(max-min+1)+min);;
			if(!board.get(start).hasSnakeOrLadder()) {
				board.get(start).setEntity(new Ladder(start, end));
			}
			
		}
		
		return board;
	}
}
