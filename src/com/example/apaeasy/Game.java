package com.example.apaeasy;

import java.util.List;
import java.util.Queue;
/*
 * Game Class.
 * We assume that there will only be one game at at a time and that each player is playing in 
 * exactly one game. However, there could be many games in a match.
 * 
 */
public class Game {
	AbstractScoringSystem scoringSystem = null;
	private List<Ball> ballList = null; // Initial ball list
	private Queue<Player> playerQueue = null;
	private Player lagWinner = null;
	private Player initialBreaker = null;
	private Player currentPlayer = null;
	private int innings = 0;
	
	// Initializes the game
	Game(AbstractScoringSystem scoringSystem,Queue<Player> playerQueue)
	{
		this.scoringSystem = scoringSystem;
		this.ballList = scoringSystem.getInitialBallSet();
		this.playerQueue = playerQueue;
		this.initialBreaker = playerQueue.peek();
		this.lagWinner = null;
	}
	
	public void addPlayer(Player p)
	{
		this.playerQueue.add(p);
	}
	
	public void cycleTurn()
	{
		Player previousPlayer = this.currentPlayer;
		this.currentPlayer = playerQueue.remove();
		this.playerQueue.add(previousPlayer);
		
		if(currentPlayer.equals(this.initialBreaker))
			innings++;
	}

	public int getInnings()
	{
		return this.innings;
	}
	
	public int getScore(List<Ball> ballList)
	{
		return this.scoringSystem.getScore(ballList);
	}
}
