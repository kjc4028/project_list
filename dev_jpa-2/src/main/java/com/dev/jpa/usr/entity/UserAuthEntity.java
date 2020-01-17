package com.dev.jpa.usr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USR_AUTH")
public class UserAuthEntity {

	public UserAuthEntity() {
	}
	
	@Id
	@ManyToOne(targetEntity=UsrEntity.class)
	@JoinColumn(name="USR_SEQ")
	private Long usrSeq;
	
/*	@ManyToOne(targetEntity=UsrEntity.class)
	@JoinColumn(name="USR_ID")
	@Column(length = 20, nullable = false, unique = true, updatable = false)
	private String usrId;*/
	
	@Column(nullable = false)
	private String role_cd;
	
	
	
}
