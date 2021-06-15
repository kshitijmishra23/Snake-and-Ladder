Design the game of Snake & Ladder
--------------------------------------------------------------------------------

- Create a Snake and Ladder application.
- The application should take input n from the user.
- The game should have a board size of n x n.
- There should be n snakes and n ladders placed randomly in the board.
- Each snake will have its head at some number and its tail at a smaller number.
- Each ladder will have its start position at some number and end position at a larger number.
- There can be multiple players in the game.

### Rules
- The board has numbers from 1 to n^2.
- The players will make there move turn-by-turn.
- The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
- Each player has a piece which is initially kept outside the board (i.e., at position 0).
- Each player rolls the dice when their turn comes.
- Based on the dice value, the player moves their piece forward that number of cells. 
  Ex: If the dice value is 4 and the player is at position 7, the player will move to position 11 (7+4).
- A player wins if he reached the last cell in the board.
- Whenever a player ends up at a cell with the head of the snake, the player should go down to the cell that has the tail of that snake.
- Whenever a player ends up at a cell with the start of the ladder, the player should go up to the cell that has the end of that ladder.
- The game should continue till there are at least 2 players still playing to win.
- After the dice roll, if a piece is supposed to move outside position 100, it does not move.
- Snakes and Ladders do not create a cycle.

### Future Scope
- The game can be played by more than one dices. (i.e. if there are two dices then the numbers from 2 to 12 will be generated).
- On getting a 6, you get another turn and on getting 3 consecutive 6s, all the three of those get cancelled.
