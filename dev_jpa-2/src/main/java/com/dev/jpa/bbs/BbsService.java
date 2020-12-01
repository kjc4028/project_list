package com.dev.jpa.bbs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.UsrEntity;

@Service
@Transactional
public class BbsService {

	@Autowired
	private BbsRepository bbsRepository;
	
	public void save(BbsEntity bbsEntity) {
		bbsRepository.save(bbsEntity);
	}
	
	public List<BbsEntity> findAll(){
		return bbsRepository.findAll();
	}

	public List<BbsEntity> findByUsrEntity(String userId){
		UsrEntity usrEntity = new UsrEntity();
		usrEntity.setUsrId(userId);
		return bbsRepository.findByUsrEntity(usrEntity);
	}

	public BbsEntity findByBbsSeq(int bbsSeq) {
		return bbsRepository.findByBbsSeq(bbsSeq);
	}
	
}
