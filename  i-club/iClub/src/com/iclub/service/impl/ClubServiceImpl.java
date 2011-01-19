package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.dao.GenericDao;
import com.iclub.member.vo.Club;
import com.iclub.service.ClubService;

@Service("clubService")
public class ClubServiceImpl implements ClubService {
	
	@Autowired
	GenericDao<Club,Long> clubDao;
	
	@Transactional
	public void createClub(Club c) {
		clubDao.create(c);
	}
	
	@Transactional
	public void update(Club p) {
		clubDao.update(p);
	}

	@Transactional
	public List<Club> getAllClubs() {
		return clubDao.getAll(Club.class);
	}

	@Transactional
	public Club getClub(long id) {
		return clubDao.read(id,Club.class);
	}

	@Transactional
	public void delete(long id){
		Club club = new Club();
		club.setClubId(id);
		clubDao.delete(club);
	}

}
