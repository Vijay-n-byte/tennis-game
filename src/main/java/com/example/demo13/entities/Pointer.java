package com.example.demo13.entities;

import com.example.demo13.enums.Status;
public class Pointer {
	private int setno;
	private int gameno;
	private int serveside;
	public Pointer() {
	}
	
	public Pointer(int setno, int gameno,int serveside) {
		super();
		this.setno = setno;
		this.gameno = gameno;
		this.serveside=serveside;
	}

	public void setSetno(int setno) {
		this.setno = setno;
	}

	public int getSetno() {
		return setno;
	}
	public void incrementSetno() {
		this.setno++;
	}
	public int getGameno() {
		return gameno;
	}
	public void incrementGameno() {
		this.gameno++;
	}
	public void setGameno(int gameno) {
		this.gameno=gameno;
	}

	public int getServeside() {
		return serveside;
	}

	public void changeServeSide() {
		if(this.serveside==0) {
			this.serveside=1;
		}
		else {
			this.serveside=0;
		}
	}
	
}
