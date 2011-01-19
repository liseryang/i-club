package com.iclub.member.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long memberId;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateJoined;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateLeft;

    @ManyToOne(targetEntity = MemberType.class)
    @JoinColumn
    private MemberType memberType;
	
	@ManyToOne(targetEntity=MemberStatus.class)
	@JoinColumn
	private MemberStatus memberStatus;
	
	@ManyToOne(targetEntity=Club.class)
	@JoinColumn
	private Club club;
	
	@ManyToOne(targetEntity=Person.class,cascade=CascadeType.ALL)
	@JoinColumn
	Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public MemberStatus getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	public Date getDateLeft() {
		return dateLeft;
	}
	public void setDateLeft(Date dateLeft) {
		this.dateLeft = dateLeft;
	}

}
