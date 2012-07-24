package com.example.apaeasy;

public class Ball {
	private final Integer ballNumber;  // The ball's number, e.g. 1-15
	
	public static enum BallState{
		POCKETED, 	// The ball has been legally pocketed by a player
		DEAD,		// The ball was pocketed on a foul.  Does not count.
		ALIVE,		// The ball is alive, on the table.
	}
	private BallState state;  // The state of the ball.  Can be one of the states in the enum ballState
	
	/*
	 *  Constructor
	 *  @param int: the ball's number
	 *  @param BallState: the ball's initial state.. BallState.POCKETED, BallState.DEAD, or BallState.ALIVE
	 */
	Ball(int ballNumber, BallState s)
	{
		this.ballNumber = Integer.valueOf(ballNumber);
		this.state = s;
	}
	
	/*
	 * Getter for BallNumber
	 * @return Integer: the ballnumber
	 */
	public Integer getBallNumber()
	{
		return this.ballNumber;
	}	
	
	/*
	 * Getter for the Ball's state
	 * @return BallState: Either POCKETED, DEAD, or ALIVE
	 */
	public BallState getState()
	{
		return this.state;
	}
	
	/*
	 * Setter for BallState
	 * @param BallState: Either BallState.POCKETED, BallState.DEAD, or BallState.ALIVE
	 */
	public void setState(BallState s)
	{
		this.state = s;
	}
}
