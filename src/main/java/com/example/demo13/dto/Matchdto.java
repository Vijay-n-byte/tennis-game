package com.example.demo13.dto;

import java.util.List;
import com.example.demo13.entities.Player;

public class Matchdto {
	private int gametype; //single or doubles.
	private List<Player> a;
	private List<Player> b;
	private int noofsets;
	public int getGametype() {
		return gametype;
	}
	public List<Player> getA() {
		return a;
	}
	public List<Player> getB() {
		return b;
	}
	public int getNoofsets() {
		return noofsets;
	}
}
 