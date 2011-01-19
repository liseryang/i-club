package com.iclub.service;

import java.util.List;

import com.iclub.member.vo.Club;

public interface ClubService {
	void createClub(Club c);
	void update(Club p);
	List<Club> getAllClubs();
	Club getClub(long id);
	void delete(long id);
}
