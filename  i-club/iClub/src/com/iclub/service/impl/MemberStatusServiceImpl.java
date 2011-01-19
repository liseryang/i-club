package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.dao.GenericDao;
import com.iclub.member.vo.MemberStatus;
import com.iclub.service.MemberStatusService;

@Service("memberStatusService")
public class MemberStatusServiceImpl implements MemberStatusService {
	
	@Autowired
	GenericDao<MemberStatus,Long> memberStatusDao;
	
	@Transactional
	public MemberStatus getMemberStatus(long id) {
		return memberStatusDao.read(id,MemberStatus.class);
	}
	
	@Transactional
	public List<MemberStatus> getAllMemberStatus() {
		return memberStatusDao.getAll(MemberStatus.class);
	}
}