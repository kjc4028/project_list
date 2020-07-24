package com.dev.jpa.category;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

import com.dev.jpa.usr.entity.RoleUsrEntity;
import com.dev.jpa.usr.entity.UsrEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="TB_CATEGORY")
public class CategoryEntity {
	
	
	public CategoryEntity() {
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int categorySeq;
	
	@Column
	private String usrId;
	
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