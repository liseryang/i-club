package com.iclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iclub.dao.GenericDao;
import com.iclub.member.vo.MemberType;
import com.iclub.service.MemberTypeService;

@Service("memberTypeService")
public class MemberTypeServiceImpl implements MemberTypeService {
	
	@Autowired
	GenericDao<MemberType,Long> memberTypeDao;
	
	@Transactional
	public List<MemberType> getAllMemberTypes() {
		return memberTypeDao.getAll(MemberType.class);
	}
	
	@Transactional
	public MemberType getMemberType(long id) {
		return memberTypeDao.read(id,MemberType.class);
	}
}
