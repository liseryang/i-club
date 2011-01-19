package com.iclub.member.controller;

import java.util.Date;

import com.iclub.member.vo.Member;
import com.iclub.member.vo.Person;

public class ClubMemberForm {
	private Person person;
	private Member member;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
}
