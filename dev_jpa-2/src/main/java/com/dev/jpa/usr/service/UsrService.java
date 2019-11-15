package com.dev.jpa.usr.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.jpa.usr.entity.UsrEntity;
import com.dev.jpa.usr.repository.UsrRepository;

@Service
@Transactional
public class UsrService {
	
	@Autowired
	UsrRepository usrRepository;
	
	public UsrEntity findByUsrNm(String name){
		return usrRepository.findByUsrNm(name);
	}
	
	public List<UsrEntity> findAll(){
		return usrRepository.findAll();
	}
	
	public void save(UsrEntity usr){
		usrRepository.save(usr);
	}
}
