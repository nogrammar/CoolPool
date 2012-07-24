package com.example.apaeasy;
import java.util.List;

abstract class AbstractScoringSystem {
	public abstract int getScore(List<Ball> ballList);
	public abstract List<Ball> getInitialBallSet();
}
