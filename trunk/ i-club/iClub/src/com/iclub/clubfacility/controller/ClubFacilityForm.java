package com.iclub.clubfacility.controller;

import com.iclub.member.vo.ClubFacility;

public class ClubFacilityForm extends ClubFacility{
	private long clubId;
	private long facilityId;
	
	private String dateAvailbleStr;
	private String dateNotAvailableStr;
	
	public String getDateAvailbleStr() {
		return dateAvailbleStr;
	}
	public void setDateAvailbleStr(String dateAvailbleStr) {
		this.dateAvailbleStr = dateAvailbleStr;
	}
	public String getDateNotAvailableStr() {
		return dateNotAvailableStr;
	}
	public void setDateNotAvailableStr(String dateNotAvailableStr) {
		this.dateNotAvailableStr = dateNotAvailableStr;
	}
	public long getClubId() {
		return clubId;
	}
	public void setClubId(long clubId) {
		this.clubId = clubId;
	}
	public long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	
	
}
