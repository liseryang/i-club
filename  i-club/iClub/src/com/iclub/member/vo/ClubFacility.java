package com.iclub.member.vo;

import java.util.Date;

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
public class ClubFacility {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateAvailable;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date dateNotAvailable;    
    
    private long facilityCost;

    @ManyToOne(targetEntity=Club.class)
    @JoinColumn
    private Club club;
    
    @ManyToOne(targetEntity=Facility.class)
    private Facility facility;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public Date getDateNotAvailable() {
		return dateNotAvailable;
	}

	public void setDateNotAvailable(Date dateNotAvailable) {
		this.dateNotAvailable = dateNotAvailable;
	}

	public long getFacilityCost() {
		return facilityCost;
	}

	public void setFacilityCost(long facilityCost) {
		this.facilityCost = facilityCost;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
    
    
    
    
}
