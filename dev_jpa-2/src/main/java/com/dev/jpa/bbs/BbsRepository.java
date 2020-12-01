package com.dev.jpa.bbs;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BbsRepository extends JpaRepository<BbsEntity, Long>{

	BbsEntity findByBbsSeq(int bbsSeq);
}
