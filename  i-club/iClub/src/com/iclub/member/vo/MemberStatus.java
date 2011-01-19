package com.iclub.member.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MemberStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long memberStatusId;
	
	@NotNull
	String description;

	public long getMemberStatusId() {
		return memberStatusId;
	}

	public void setMemberStatusId(long memberStatusId) {
		this.memberStatusId = memberStatusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
