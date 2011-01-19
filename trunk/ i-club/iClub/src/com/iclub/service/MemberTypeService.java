package com.iclub.service;

import java.util.List;

import com.iclub.member.vo.MemberType;

public interface MemberTypeService {
	public List<MemberType> getAllMemberTypes();
	public MemberType getMemberType(long id);
}
