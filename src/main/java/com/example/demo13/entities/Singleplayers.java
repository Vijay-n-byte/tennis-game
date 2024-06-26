package com.example.demo13.entities;

import java.util.List;
import java.util.ArrayList;

public class Singleplayers implements Team{
	private List<Player> team_a=null;
	private List<Player> team_b=null;
	
	public Singleplayers() {
		super();
	}

	public Singleplayers(List<Player> a,List<Player> b) {
		super();
		team_a=new ArrayList<Player>(1);
		team_a.add(a.get(0));
		team_b=new ArrayList<Player>(1);
		team_b.add(b.get(0));
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
