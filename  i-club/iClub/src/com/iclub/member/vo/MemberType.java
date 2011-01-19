package com.iclub.member.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class MemberType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long memberTypeId;
	
	@NotNull
	String description;

	public long getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(long memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
