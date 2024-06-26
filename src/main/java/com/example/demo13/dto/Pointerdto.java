
package com.example.demo13.dto;

import com.example.demo13.entities.Pointer;
import com.example.demo13.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pointerdto {
	private String matchid;
	private Pointer pointer;
	private Status status;
	public Pointerdto(String matchid,Status status,Pointer pointer) {
		super();
		this.status=status;
		this.matchid=matchid;
		this.pointer = pointer;
	}
	
	public Status getStatus() {
		return status;
	}

	public Pointer getPointer() {
		return pointer;
	}

	public String getMatchid() {
		return matchid;
	}
}
