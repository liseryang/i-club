package com.iclub.member.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long clubId;
	
	String clubShortName;
	
	String clubFees;
	
	String clubLongName;
	
	String clubDescription;
	
	String clubOtherDetails;
	
	
	public long getClubId() {
		return clubId;
	}
	public void setClubId(long clubId) {
		this.clubId = clubId;
	}
	public String getClubShortName() {
		return clubShortName;
	}
	public void setClubShortName(String clubShortName) {
		this.clubShortName = clubShortName;
	}
	public String getClubFees() {
		return clubFees;
	}
	public void setClubFees(String clubFees) {
		this.clubFees = clubFees;
	}
	public String getClubLongName() {
		return clubLongName;
	}
	public void setClubLongName(String clubLongName) {
		this.clubLongName = clubLongName;
	}
	public String getClubDescription() {
		return clubDescription;
	}
	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}
	public String getClubOtherDetails() {
		return clubOtherDetails;
	}
	public void setClubOtherDetails(String clubOtherDetails) {
		this.clubOtherDetails = clubOtherDetails;
	}

	
}
