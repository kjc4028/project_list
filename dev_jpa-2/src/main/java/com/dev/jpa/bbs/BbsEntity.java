package com.dev.jpa.bbs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.dev.jpa.category.CategoryEntity;
import com.dev.jpa.usr.entity.RoleUsrEntity;
import com.dev.jpa.usr.entity.UsrEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BbsEntity {

	public BbsEntity() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bbsSeq;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String contents;
	
	@Column
	private Date regDate;
	
	@Column
	private Date modDate;
	
	@Column(length = 1, nullable = false)
	private String useYn;
	
	@Column
	private int categorySeq;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "categorySeq", referencedColumnName = "categorySeq")
	 * private CategoryEntity categoryEntity;
	 */
	 
	@PrePersist
	public void prepersist() {
		this.useYn = this.useYn == null ? "N" : this.useYn;
		this.regDate = new Date();
		this.modDate = new Date();
	}
	
	
}
