package com.iclub.service;

import java.util.List;

import com.iclub.member.vo.ClubFacility;

public interface ClubFacilityService {
	void createClubFacility(ClubFacility c);
	void update(ClubFacility p);
	List<ClubFacility> getAllClubFacilities();
	ClubFacility getClubFacility(long id);
	void delete(long id);
}
