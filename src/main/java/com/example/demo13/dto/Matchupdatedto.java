package com.example.demo13.dto;

import com.example.demo13.entities.Score;

public class Matchupdatedto {
	private String matchid;
	private int setno;
	private int gameno;
	private Score s;
	public Matchupdatedto() {
		super();
	}
	public String getMatchid() {
		return matchid;
	}
	public void setMatchid(String matchid) {
		this.matchid = matchid;
	}
	public int getSetno() {
		return setno;
	}
	public void setSetno(int setno) {
		this.setno = setno;
	}
	public int getGameno() {
		return gameno;
	}
	public void setGameno(int gameno) {
		this.gameno = gameno;
	}
	public Score getS() {
		return s;
	}
	public void setS(Score s) {
		this.s = s;
	}
}
