package snakeAndLadder.entities;

public class Cell {
	BoardEntity entity;

	
	public BoardEntity getEntity() {
		return entity;
	}

	public void setEntity(BoardEntity entity) {
		this.entity = entity;
	}
	
	public boolean hasSnakeOrLadder() {
		return entity != null;
	}
	
}
