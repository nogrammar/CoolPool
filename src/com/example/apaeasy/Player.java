package com.example.apaeasy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
	
	private String playerName = null;
	private List<Ball> sunkBallsList = null; // Wanted to use an ArrayDeque but not supported till API9 :/
	private Game parentGame = null;
	
	Player(String playerName, Game parentGame)
	{
		this.playerName = playerName;	
		this.parentGame = parentGame; // The game that the player is currently playing in.
		this.sunkBallsList = new ArrayList<Ball>(); // haven't sunk any balls yet.
	}	
	
	/*
	 * ballInSunkList(Ball)
	 * @param Ball: the ball in question
	 * @return boolean: true if the ball is in the sunkList else false.
	 */
	public boolean ballInSunkList(Ball b)
	{
		Iterator<Ball> i = sunkBallsList.iterator();
		while(i.hasNext())
		{
			Ball temp = i.next();
			if(temp.getBallNumber() == b.getBallNumber())
				return true;
		}
		return false;
	}
	
	/*
	 * sunkball(Ball): add's a given ball to the players sunkballs list
	 * @param Ball: the ball that was sunk by the player
	 */
	public void sunkBall(Ball b)
	{
		if(this.ballInSunkList(b))
			System.err.print("Ball is already listed in " + this.getPlayerName() + "'s sunk list.");
		else
			sunkBallsList.add(b);
	}
	
	/*
	 * getScore(): calls up to the parent games (current game's) ScoringSystem (9ball, etc)
	 * @return int: the player's score.
	 */
	public int getScore()
	{
		return this.parentGame.getScore(this.sunkBallsList);
	}
	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
