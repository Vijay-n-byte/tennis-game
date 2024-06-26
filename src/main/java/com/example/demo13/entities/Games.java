package com.example.demo13.entities;

import java.util.List;

import com.example.demo13.enums.Status;
import com.example.demo13.enums.WinningTeam;

import java.util.ArrayList;
public class Games {
	private int gameno;
	private Status status;
	private WinningTeam won;
	private WinningTeam serveside;
	private Score gamescore;
	private List<Score> points;
	private boolean deuce;
	
	//constructors:
	public Games() {
		super();
	}
	public Games(int y,int serveside) {
		this.gameno=y;
		this.status=Status.started;
		this.serveside=chooseServeSide(serveside);
		this.points=new ArrayList<Score>();
	}
	
	
	private WinningTeam chooseServeSide(int y) {
		if(y==0) {
			return WinningTeam.Team_A;
		}
		else if(y==1){
			return WinningTeam.Team_B;
		}
		return null;
	}
	public WinningTeam getServeside() {
		return serveside;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public WinningTeam getWon() {
		return won;
	}
	public Score getS() {
		return gamescore;
	}
	public void setS(Score s) {
		this.gamescore = s;
	}
	public int getGameno() {
		return gameno;
	}
	public void setGameno(int gameno) {
		this.gameno = gameno;
	}
	public Score getGamescore() {
		return gamescore;
	}
	public void setGamescore(Score gamescore) {
		this.gamescore = gamescore;
	}
	public List<Score> getPoints() {
		return points;
	}
	
	public void addPoints(Score points) {
		this.points.add(points);
		updateOverallGameScore(points);
	}	
	private void gameWinningConditions() {
		//when is actual victory to a game?
		//when deuce is false,
		//1.when A scores 4 points and B scores less than 4 points,A wins
		//2.when B scores 4 points and A scores less than 4 points B wins
		//when deuce is true,
        //1.when A earns two points more than player B,A wins
        //2.when B earns two points more than player A,B wins
		if(this.deuce==false) {
			if(this.gamescore.getTeam_A()==4) {
				this.status=Status.ended;
				this.won=WinningTeam.Team_A;
			}
			else if(this.gamescore.getTeam_B()==4) {
				this.status=Status.ended;
				this.won=WinningTeam.Team_B;
			}
		}
		else {
			if(Math.abs(this.gamescore.getTeam_A()-this.gamescore.getTeam_B())==2) {
				this.status=Status.ended;
				if(this.gamescore.getTeam_A()>this.gamescore.getTeam_B()) {
					this.won=WinningTeam.Team_A;
				}
				else {
					this.won=WinningTeam.Team_B;
				}
			}
		}	
	}
	private void updateOverallGameScore(Score points) {
		if(this.gamescore==null) {
			System.out.print("first time update");
			this.gamescore=points;
		}
		else {
			this.gamescore.setTeam_A(this.gamescore.getTeam_A()+points.getTeam_A());
			this.gamescore.setTeam_B(this.gamescore.getTeam_B()+points.getTeam_B());
			if((this.gamescore.getTeam_A()==this.gamescore.getTeam_B()) && this.gamescore.getTeam_A()==3) {
				this.deuce=true;
			}
			gameWinningConditions();
		}
	}
}




