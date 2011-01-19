package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.dao.GenericDao;
import com.iclub.member.vo.Facility;
import com.iclub.service.FacilityService;

@Service("facilityService")
public class FacilityServiceImpl implements FacilityService {

	
	@Autowired
	GenericDao<Facility,Long> facilityDao;
	
	@Transactional
	public void createFacility(Facility c) {
		facilityDao.create(c);
	}
	
	@Transactional
	public void update(Facility p) {
		facilityDao.update(p);
	}

	@Transactional
	public List<Facility> getAllFacilities() {
		return facilityDao.getAll(Facility.class);
	}

	@Transactional
	public Facility getFacility(long id) {
		return facilityDao.read(id, Facility.class);
	}

	@Transactional
	public void delete(long id){
		Facility facility = new Facility();
		facility.setFacilityId(id);
		facilityDao.delete(facility);
	}

}
