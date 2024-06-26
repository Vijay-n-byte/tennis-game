package com.example.demo13.entities;

import java.util.List;
import java.util.ArrayList;

public class Doubleplayers implements Team {
	private List<Player> team_a=null;
	private List<Player> team_b=null;
	
	public Doubleplayers() {
		super();
	}
	public Doubleplayers(List<Player> a,List<Player> b) {
		super();
		this.team_a=new ArrayList<Player>(2);
		this.team_a.add(a.get(0));
		this.team_a.add(a.get(1));
		this.team_b=new ArrayList<Player>(2);
		this.team_b.add(b.get(0));
		this.team_b.add(b.get(1));
	}
	@Override
	public List<Player> getTeam_a() {
		// TODO Auto-generated method stub
		return this.team_a;
	}
	@Override
	public List<Player> getTeam_b() {
		// TODO Auto-generated method stub
		return this.team_b;
	}
}
