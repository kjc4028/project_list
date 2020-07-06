package com.dev.jpa.category;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.data.jpa.repository.Query;

import com.dev.jpa.usr.entity.RoleUsrEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categorySeq;
	
	@Column
	private String categoryNm;
	
	@Column
	private Date regDate;
	
	@Column(length = 1, nullable = false)
	private String UseYn;
	
	@PrePersist
	public void prepersist() {
		this.UseYn = this.UseYn == null ? "N" : this.UseYn;
		this.regDate = new Date();
	}
	
}
