package com.iclub.service;

import java.util.List;

import com.iclub.common.ClubException;
import com.iclub.member.vo.Member;
import com.iclub.member.vo.Person;

public interface MemberService {
	void registerMember(Member p);
	void update(Member p);
	List<Member> getAllMembers();
	Member getMember(long id);
	void delete(long id) throws ClubException;
}
