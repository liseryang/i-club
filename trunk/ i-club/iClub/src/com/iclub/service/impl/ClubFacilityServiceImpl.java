package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.dao.GenericDao;
import com.iclub.member.vo.ClubFacility;
import com.iclub.service.ClubFacilityService;

@Service("clubFacilityService")
public class ClubFacilityServiceImpl implements ClubFacilityService {
	@Autowired
	GenericDao<ClubFacility,Long> clubFacilityDao;
	
	@Transactional
	public void createClubFacility(ClubFacility c) {
		clubFacilityDao.create(c);
	}
	
	@Transactional
	public void update(ClubFacility p) {
		clubFacilityDao.update(p);
	}

	@Transactional
	public List<ClubFacility> getAllClubFacilities() {
		return clubFacilityDao.getAll(ClubFacility.class);
	}

	@Transactional
	public ClubFacility getClubFacility(long id) {
		return clubFacilityDao.read(id,ClubFacility.class);
	}

	@Transactional
	public void delete(long id){
		ClubFacility c = new ClubFacility();
		c.setId(id);
		clubFacilityDao.delete(c);
		
	}
	
}
