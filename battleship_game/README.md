Battleship game by Terka G.

This is a simple battleship game.
The Game.java is executable program that will start the game.
It creates two players, one of class Human and another of class Computer. Both of these extend the class Player.
Class Player has a constructor that uses generateRandomBoard() from Grid class to create board for each player. This class also takes care of evaluating the shooting request. It gives the appropriate response and changes values of board field so it represents the situation after the turn.
Both Computer and Human subclass have one most important function and that it makeTurn() which does exactly so. In Human that means asking for coordinates from real-life players. Computer chooses the position on some logic that is designed to decrease the necessary number of turns.



RULES:
 - the goal of the game is to shoot and sink all of opponent's ships
 - there are 5 ships - two of length 3 and one of each of lengths 2,4 and 5
 - the ships are placed in a way that no two of them ovelap or share a border or corner
 - players take turns of shooting at enemy's fleet, human player starts
 - if a player hits the ship, they can have another turn
 - if the player shoots down the whole ship, they are informed and all bordering fields are revealed since it has to be water
 - first to sink all ships wins the game