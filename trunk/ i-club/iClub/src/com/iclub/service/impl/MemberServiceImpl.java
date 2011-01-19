package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.common.ClubException;
import com.iclub.dao.GenericDao;
import com.iclub.member.vo.Member;
import com.iclub.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	GenericDao<Member,Long> memberDao;
	
	@Transactional
	public void registerMember(Member p){
		memberDao.create(p);
	}
	public List<Member> getAllMembers(){
		return memberDao.getAll(Member.class);
	}
	
	@Transactional
	public Member getMember(long id){
		return memberDao.read(id,Member.class);
	}
	
	@Transactional
	public void update(Member p) {
		memberDao.update(p);
	}

	@Transactional
	public void delete(long id) throws ClubException {
		Member m = new Member();
		m.setMemberId(id);
		memberDao.delete(m);
	}
	
}