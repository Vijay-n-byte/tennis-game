package com.example.demo13.entities;

import java.util.List;
import java.util.ArrayList;

import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.enums.Status;
import com.example.demo13.enums.WinningTeam;

public class Tennis_set{
	private int setno;
	private Status status;//set closed are open
	private WinningTeam team;//who won this set?
	private Score setscore;
	private List<Games> games;
	
	//constructor:
	public Tennis_set() {
		super();
		this.games=new ArrayList<>();
	}
	
	//getters and setters:
	public int getSetno() {
		return setno;
	}
	public void setSetno(int setno) {
		this.setno = setno;
	}
	public Status getStatus() {
		return status;
	}
	public WinningTeam getTeam() {
		return team;
	}
	public List<Games> getG() {
		return games;
	}
	public Score getS() {
		return setscore;
	}
	
//	public void setS(Score s) {
//		this.setscore = s;
//	}
//	public void setTeam(WinningTeam team) {
//	this.team = team;
//}

	//some important private and public methods:
	public Games giveGames(int gameno,int serveside) {
		if(this.games.isEmpty() || games.size()!=gameno) {
			games.add(gameno-1,new Games(gameno,serveside));
		}
		return games.get(gameno-1);
	}
	
	public void updateGames(int position,Games g) {
		this.games.set(position, g);
		updateOverallTennisSetScore(g);
	}
	
	private void setWinningConditions() {
		if((this.setscore.getTeam_A()==6 || this.setscore.getTeam_B()==6) && (Math.abs(this.setscore.getTeam_A()-this.setscore.getTeam_B())>=2)) {
			this.status=Status.ended;
			if(this.setscore.getTeam_A()>this.setscore.getTeam_B()) {
				this.team=WinningTeam.Team_A;
			}
			else {
				this.team=WinningTeam.Team_B;
			}
		}
	}
	
	private void updateOverallTennisSetScore(Games g) {
		if(g.getStatus()==Status.ended) {
			if(this.setscore==null) {
				this.setscore=new Score();
				if(g.getWon()==WinningTeam.Team_A) {
				    this.setscore.setTeam_A(1);	
				    this.setscore.setTeam_B(0);	
				}
				else {
					this.setscore.setTeam_A(0);
					this.setscore.setTeam_B(1);	
				}
			}
			else {
				if(g.getWon()==WinningTeam.Team_A) {
				    this.setscore.incrementTeamA();
				}
				else {
					this.setscore.incrementTeamB();
				}
				setWinningConditions();
			}
		}
	}
}
