package com.app.model;

public class Player implements Comparable<Player>{
	public int score;
	public String name;
	
	public Player(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}

	public Player() {
		super();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Player player) {
		//Sorting based on score ,if Two Players have same score sorting based on name.
		if(this.score-player.score==0)
			return this.name.compareTo(player.name);
		else
	        return this.score-player.score;
	}

	@Override
	public String toString() {
		return "{ score : " + score + ", name : " + name + " } ";
	}


}
