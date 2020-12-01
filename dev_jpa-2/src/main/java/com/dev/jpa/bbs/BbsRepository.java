package com.dev.jpa.bbs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jpa.usr.entity.UsrEntity;


public interface BbsRepository extends JpaRepository<BbsEntity, Long>{

	BbsEntity findByBbsSeq(int bbsSeq);
	
	List<BbsEntity> findByUsrEntity(UsrEntity usrEntity);
}
