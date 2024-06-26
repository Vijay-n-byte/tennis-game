package com.example.demo13.entities;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo13.dto.Matchdto;
import com.example.demo13.dto.Matchupdatedto;
import com.example.demo13.enums.Gametype;
import com.example.demo13.enums.Status;
import com.example.demo13.enums.WinningTeam;
@Document
public class Match {
	@Id
	private String matchid;
	private Gametype gametype;
	private Team teams;
	private int noofsets;
	private Status status;
	private Score bestsetscore;
	private WinningTeam wt;
	private List<Tennis_set> sets;
	private Pointer pointer;
	
	//constructors:
	public Match() {
		super();
	}
	public Match(Matchdto md) {
		this.matchid=creatematchid();
		initiateTeam(md.getGametype(),md.getA(),md.getB());
		this.noofsets=md.getNoofsets();
		this.status=Status.started;
		initiateSets(md.getNoofsets());
	}

    //getters:
	public String getMatchid() {
		return matchid;
	}
	public Gametype getGametype() {
		return gametype;
	}
	public Team getTeams() {
		return teams;
	}
	public int getNoofsets() {
		return noofsets;
	}
	public Status getStatus() {
		return status;
	}
	public Score getBestsetscore() {
		return bestsetscore;
	}
	public WinningTeam getWt() {
		return wt;
	}
	public Pointer getPointer() {
		return pointer;
	}
	public List<Tennis_set> getSets() {
		return sets;
	}
//	public String sendmatchid() {
//		return this.matchid;
//	}
//	public void setGametype(Gametype gametype) {
//		this.gametype = gametype;
//	}
//	public void setTeams(Team teams) {
//		this.teams = teams;
//	}
//	public void setMatchid(String matchid) {
//		this.matchid = matchid;
//	}	
//	public void setNoofsets(int noofsets) {
//		this.noofsets = noofsets;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
//	public void setBestsetscore(Score bestsetscore) {
//		this.bestsetscore = bestsetscore;
//	}
//	public void setSets(List<Tennis_set> sets) {
//		this.sets = sets;
//	}
//	public void setWt(WinningTeam wt) {
//		this.wt = wt;
//	}
	
//	public void setPointer(Pointer pointer) {
//		this.pointer = pointer;
//	}
	
	//important private and public methods
	private void initiateTeam(int a,List<Player> b,List<Player> c) {
		if(a==0) {
			this.gametype=Gametype.singles;
			this.teams=new Singleplayers(b,c);
		}
		else if(a==1){ 
			this.gametype=Gametype.doubles;
			this.teams=new Doubleplayers(b,c);
		}
	}
	
	private void initiateSets(int a) {
		this.sets=new ArrayList<Tennis_set>();
		for(int y=0;y<a;y++) {
			Tennis_set w=new Tennis_set();
			w.setSetno(y+1);
			this.sets.add(w);
		}
	}
	private String creatematchid() { 
		return UUID.randomUUID().toString();
	}
	
	public void updateMatch(int position,Tennis_set n) {
		this.sets.set(position, n);
		updateMatchScore(n);
	}
	
	private void matchWinningConditions(Tennis_set n) {
		if(n.getSetno()==this.noofsets) {
			this.status=Status.ended;
			int h=(int)Math.ceil(this.noofsets/2);
			if(this.bestsetscore.getTeam_A()>=h) {
				this.wt=WinningTeam.Team_A;
			}
			else {
				this.wt=WinningTeam.Team_B;
			}
			this.pointer=null;
		}
	}
	
	private void updateMatchScore(Tennis_set n) {
		if(n.getStatus()==Status.ended) {
			this.pointer.incrementSetno();
			this.pointer.setGameno(1);
			this.pointer.changeServeSide();
			if(this.bestsetscore==null) {
				this.bestsetscore=new Score();
				if(n.getTeam()==WinningTeam.Team_A) {
					this.bestsetscore.setTeam_A(1);
					this.bestsetscore.setTeam_B(0);
				}
				else {
					this.bestsetscore.setTeam_B(1);
					this.bestsetscore.setTeam_A(0);
				}
			}
			else {
				if(n.getTeam()==WinningTeam.Team_A) {
					this.bestsetscore.incrementTeamA();
				}
				else {
					this.bestsetscore.incrementTeamB();
				}
			}
			matchWinningConditions(n);
		}
		else {
			List<Games> g=n.getG();
			if(g.get(g.size()-1).getStatus()==Status.ended) {
				this.pointer.incrementGameno();
				this.pointer.changeServeSide();
			}
		}
	}
}
