package com.iclub.service;

import java.util.List;

import com.iclub.member.vo.MemberStatus;

public interface MemberStatusService {
	public MemberStatus getMemberStatus(long id);
	public List<MemberStatus> getAllMemberStatus();
}
