package com.example.apaeasy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.apaeasy.Ball.BallState;

public class ConcreteNineBallScoringSystem extends AbstractScoringSystem{
	
		public ConcreteNineBallScoringSystem(){}
	
		public int getScore(List<Ball> ballList)
		{
			int score = 0;
			Iterator<Ball> i = ballList.iterator();
			while(i.hasNext())
			{
				Ball temp = i.next();
				if(temp.getBallNumber().intValue() == 9)
				{
					score += 2;
				}
				else
					score += 1;
			}
			return score;
		}

		@Override
		public List<Ball> getInitialBallSet() {
			List<Ball> ballList = new ArrayList<Ball>();
			// 9ball list
			for(int i=0; i<10; i++)
				ballList.add(new Ball(i+1, BallState.ALIVE));
			return null;
		}
}
