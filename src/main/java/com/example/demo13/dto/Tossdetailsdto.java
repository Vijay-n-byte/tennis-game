package com.example.demo13.dto;

import com.example.demo13.enums.WinningTeam;

public class Tossdetailsdto {

	private String matchid;
	private int firstserveteam;
	public Tossdetailsdto() {
		super();
	}
	public String getMatchid() {
		return matchid;
	}
	public void setMatchid(String matchid) {
		this.matchid = matchid;
	}
	public int getFirstserveteam() {
		return firstserveteam;
	}
	public void setFirstserveteam(int firstserveteam) {
		this.firstserveteam = firstserveteam;
	}
	
}
