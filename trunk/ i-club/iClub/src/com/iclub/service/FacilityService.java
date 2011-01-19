package com.iclub.service;

import java.util.List;

import com.iclub.member.vo.Facility;

public interface FacilityService {
	void createFacility(Facility c);
	void update(Facility p);
	List<Facility> getAllFacilities();
	Facility getFacility(long id);
	void delete(long id);
}
