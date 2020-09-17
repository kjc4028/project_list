package com.dev.jpa.bbs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
