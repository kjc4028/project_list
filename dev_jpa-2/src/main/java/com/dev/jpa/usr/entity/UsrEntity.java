package com.dev.jpa.usr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Setter
@Getter
@Entity
@Table(name="TB_USR")
public class UsrEntity {
  
	public UsrEntity() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long usrSeq;
	
	/*
	 * 사용자 아이디
	 */
	@Column(length = 20, nullable = false, unique = true, updatable = false)
	private String usrId;
	
	/*
	 * 사용자 비밀번호
	 */
	@Column(length = 200, nullable = false)
	private String usrPw;
	/*
	 * 사용자 성명
	 */
	@Column(length=300, nullable = false)
	private String usrNm;
	
	/**
	 * 주민등록번호 앞자리
	 */
	@Column(length = 6, nullable = false)
	private String rrn;
	
	/*
	 * 성명 m:남, f:여
	 */
	@Column(nullable = false)
	private String gender;
	
	/*
	 * 전화번호 1
	 */
	@Column(nullable = false)
	private String telNum1;

	/*
	 * 전화번호 2
	 */
	@Column(nullable = false)
	private String telNum2;
	
	/*
	 * 전화번호 3
	 */
	@Column(nullable = false)
	private String telNum3;
	
	@Builder
	public UsrEntity(Long usrSeq, String usrId, String usrNm, String rrn, String gender, String usrPw) {
		super();
		this.usrSeq = usrSeq;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.rrn = rrn;
		this.gender = gender;
		this.usrPw = usrPw;
	}

	public void setUsrSeq(Long usrSeq) {
		this.usrSeq = usrSeq;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTelNum1(String telNum1) {
		this.telNum1 = telNum1;
	}

	public void setTelNum2(String telNum2) {
		this.telNum2 = telNum2;
	}

	public void setTelNum3(String telNum3) {
		this.telNum3 = telNum3;
	}
	
	
	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */
	
}
