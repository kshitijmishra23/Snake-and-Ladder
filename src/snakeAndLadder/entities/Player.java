package snakeAndLadder.entities;

public class Player {
	int position;
	String userName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Player(String userName) {
		position = 0;
		this.userName = userName; 
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
