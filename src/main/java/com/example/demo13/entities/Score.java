package com.example.demo13.entities;

public class Score {
	private int team_A;
	private int team_B;
	private String data; //if any msg need to save for that particular set/game
	public Score() {
		super();
	}
	public int getTeam_A() {
		return team_A;
	}
	public void setTeam_A(int team_A) {
		this.team_A = team_A;
	}
	public void incrementTeamA() {
		this.team_A++;
	}
	public void incrementTeamB() {
		this.team_B++;
	}
	public int getTeam_B() {
		return team_B;
	}
	public void setTeam_B(int team_B) {
		this.team_B = team_B;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}
